package com.qfedu.bz.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qfedu.bz.BzException;
import com.qfedu.bz.dto.LeaveDto;
import com.qfedu.bz.service.ILeaveService;
import com.qfedu.bz.util.BzConstant;
import com.qfedu.common.entity.WoPage;
import com.qfedu.common.util.WoUtil;
import com.qfedu.esys.dao.IStaffDao;
import com.qfedu.esys.dto.UserDto;
import com.qfedu.esys.entity.Staff;

@Service
@Transactional
public class LeaveService implements ILeaveService {
	private final static Logger LOG = LogManager.getLogger(LeaveService.class);

	private final static String DEF_PROCESS = "leaveDemo";

	private final static String TASK_KEY_APPLY = "taskLeaveApply";

	private final static String TASK_KEY_REVIEW = "taskLeaveReview";

	@Resource
	private TaskService taskService;

	@Resource
	private FormService formService;

	@Resource
	private HistoryService historyService;

	@Resource
	private RepositoryService repositoryService;

	@Resource
	private RuntimeService runtimeService;

	@Resource
	private ProcessEngineConfiguration processEngineConfiguration;

	@Resource
	private IStaffDao staffDao;

	private HistoricTaskInstance getTaskByKey(List<HistoricTaskInstance> tasks, String taskKey) {
		for (HistoricTaskInstance task : tasks) {
			if (task.getTaskDefinitionKey().equals(taskKey)) {
				return task;
			}
		}
		return null;
	}

	private Object getValue(List<HistoricVariableInstance> variables, String key) {
		for (HistoricVariableInstance v : variables) {
			if (v.getVariableName().equals(key)) {
				return v.getValue();
			}
		}
		return null;
	}

	private String getString(List<HistoricVariableInstance> variables, String key) {
		return (String) getValue(variables, key);
	}

	private Boolean getResult(List<HistoricVariableInstance> variables) {
		Object val = getValue(variables, "result");
		return val == null ? false : (Boolean) val;
	}

	private LeaveDto createDto(String procInstId) {
		LeaveDto dto = new LeaveDto();
		// 设置流程实例ID和创建时间
		HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery().processInstanceId(procInstId)
				.singleResult();
		dto.setActProcInstId(procInstId);
		dto.setCreateTime(hpi.getStartTime());
		// 设置表单提交数据
		List<HistoricVariableInstance> variables = historyService.createHistoricVariableInstanceQuery()
				.processInstanceId(procInstId).list();
		dto.setReason(getString(variables, "reason"));
		dto.setReviewRemark(getString(variables, "remark"));
		dto.setReviewResult(getResult(variables));
		// 设置任务的人员及时间信息
		List<HistoricTaskInstance> hTasks = historyService.createHistoricTaskInstanceQuery()
				.processInstanceId(procInstId).orderByTaskCreateTime().desc().list();
		// 设置“申请”任务的人员及时间信息
		HistoricTaskInstance ht = getTaskByKey(hTasks, TASK_KEY_APPLY);
		if (ht != null && ht.getAssignee() != null) {
			dto.setStaffId(ht.getAssignee());
			Staff staff = staffDao.findById(dto.getStaffId()).get();
			dto.setStaffName(staff.getName());
			dto.setApplyTime(ht.getEndTime());
		}
		// 设置“审批”任务的人员及时间信息
		ht = getTaskByKey(hTasks, TASK_KEY_REVIEW);
		if (ht != null && ht.getAssignee() != null) {
			dto.setManagerId(ht.getAssignee());
			Staff staff = staffDao.findById(dto.getManagerId()).get();
			dto.setManagerName(staff.getName());
			dto.setReviewTime(ht.getEndTime());
		}
		return dto;
	}

	@Override
	public WoPage<LeaveDto> getListFor(UserDto u, String searchContent, Long page, Long rows) {
		if (WoUtil.isEmpty(u.getStaffIds())) {
			throw new BzException(BzConstant.ERR_STAFF);
		}
		// 获取需要当前人员处理的任务，条件：
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(DEF_PROCESS)
				.taskCandidateUser(u.getStaffIds()).list();
		// 遍历任务列表，构造dto列表
		List<LeaveDto> dtos = new ArrayList<LeaveDto>();
		for (Task t : tasks) {
			// 构造dto
			LeaveDto dto = createDto(t.getProcessInstanceId());
			// 设置任务信息
			dto.setTask(t);
			dtos.add(dto);
		}
		// 构造返回数据
		WoPage<LeaveDto> result = new WoPage<LeaveDto>();
		result.setRows(dtos);
		result.setResults(Long.valueOf(dtos.size()));
		return result;
	}

	@Override
	public WoPage<LeaveDto> getListOf(UserDto u, String searchContent, Long page, Long rows) {
		if (WoUtil.isEmpty(u.getStaffIds())) {
			throw new BzException(BzConstant.ERR_STAFF);
		}
		// 查询流程实例，条件：DefinitionKey、involvedUser
		List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery()
				.processDefinitionKey(DEF_PROCESS).involvedUser(u.getStaffIds()).orderByProcessInstanceStartTime()
				.desc().list();
		// 遍历流程实例列表，构造dto列表
		List<LeaveDto> dtos = new ArrayList<LeaveDto>();
		for (HistoricProcessInstance hpi : list) {
			// 构造dto，设置表单数据、任务的人员和时间信息
			LeaveDto dto = createDto(hpi.getId());
			// 根据流程实例Id，获取当前任务
			Task t = taskService.createTaskQuery().processInstanceId(hpi.getId()).singleResult();
			if (t != null) {// 说明当前流程还没有结束
				// 设置任务信息
				dto.setTask(t);
			}
			dtos.add(dto);
		}
		// 构造返回数据
		WoPage<LeaveDto> result = new WoPage<LeaveDto>();
		result.setRows(dtos);
		result.setResults(Long.valueOf(dtos.size()));
		return result;
	}

	@Override
	public WoPage<LeaveDto> getList(UserDto u, String searchContent, Long page, Long rows) {
		// 不需要involvedUser过滤条件
		List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery()
				.processDefinitionKey(DEF_PROCESS).orderByProcessInstanceStartTime().desc().list();
		// 遍历流程实例列表，构造dto列表
		List<LeaveDto> dtos = new ArrayList<LeaveDto>();
		for (HistoricProcessInstance hpi : list) {
			LeaveDto dto = createDto(hpi.getId());
			Task t = taskService.createTaskQuery().processInstanceId(hpi.getId()).singleResult();
			if (t != null) {
				dto.setTask(t);
			}
			dtos.add(dto);
		}
		// 构造返回数据
		WoPage<LeaveDto> result = new WoPage<LeaveDto>();
		result.setRows(dtos);
		result.setResults(Long.valueOf(dtos.size()));
		return result;
	}

	@Override
	public void apply(UserDto u, LeaveDto l) {
		if (WoUtil.isEmpty(u.getStaffIds())) {
			throw new BzException(BzConstant.ERR_STAFF);
		}
		if (WoUtil.isEmpty(l.getActProcInstId())) {
			// 1.启动流程
			// 获取最新版本的流程定义
			ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey(DEF_PROCESS)
					.latestVersion().singleResult();
			// 设置开始节点的表单数据
			Map<String, String> startFormData = new HashMap<String, String>();
			startFormData.put("staffId", u.getStaffIds());
			// 提交开始事件表单数据，启动流程
			ProcessInstance pi = formService.submitStartFormData(pd.getId(), startFormData);
			// 2.提交申请任务
			// 根据流程实例ID获取任务
			Task taskApply = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
			// 设置任务的执行人
			taskService.setAssignee(taskApply.getId(), u.getStaffIds());
			// 设置任务表单数据
			Map<String, String> applyFormData = new HashMap<String, String>();
			applyFormData.put("reason", l.getReason());
			// 提交任务表单数据，结束该任务
			formService.submitTaskFormData(taskApply.getId(), applyFormData);
		} else {
			// 根据流程实例ID获取任务
			Task taskApply = taskService.createTaskQuery().processInstanceId(l.getActProcInstId()).singleResult();
			// 设置任务的执行人
			taskService.setAssignee(taskApply.getId(), u.getStaffIds());
			// 设置任务表单数据
			Map<String, String> applyFormData = new HashMap<String, String>();
			applyFormData.put("reason", l.getReason());
			// 提交任务表单数据，结束该任务
			formService.submitTaskFormData(taskApply.getId(), applyFormData);
		}
	}

	@Override
	public void review(UserDto u, LeaveDto l) {
		if (WoUtil.isEmpty(u.getStaffIds())) {
			throw new BzException(BzConstant.ERR_STAFF);
		}
		// 获取当前人员的任务
		Task taskReview = taskService.createTaskQuery().processInstanceId(l.getActProcInstId()).singleResult();
		// 设置任务执行人
		taskService.setAssignee(taskReview.getId(), u.getStaffIds());
		// 构造任务表单数据
		Map<String, String> data = new HashMap<String, String>();
		data.put("result", l.getReviewResult().toString());
		data.put("remark", l.getReviewRemark());
		// 提交任务数据，结束任务
		formService.submitTaskFormData(taskReview.getId(), data);
	}

	@Override
	public InputStream getDiagram(String id) {
		// 根据流程实例id查询
		HistoricProcessInstance hpi = this.historyService.createHistoricProcessInstanceQuery().processInstanceId(id)
				.singleResult();
		// 得到流程执行对象
		List<Execution> executions = runtimeService.createExecutionQuery().processInstanceId(hpi.getId()).list();
		// 得到正在执行的Activity的Id
		List<String> activityIds = new ArrayList<String>();
		for (Execution exe : executions) {
			List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
			activityIds.addAll(ids);
		}
		// 获取流程定义数据，例如流程图
		BpmnModel bpmnModel = repositoryService.getBpmnModel(hpi.getProcessDefinitionId());
		// 创建流程图
		InputStream in = processEngineConfiguration.getProcessDiagramGenerator().generateDiagram(bpmnModel, "png",
				activityIds, new ArrayList<String>(), "宋体", "微软雅黑", "宋体",
				Thread.currentThread().getContextClassLoader(), 1.0);
		return in;
	}
}
