<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
	String url = "bz/leave/" + type;
%>
<div style="padding:5px 5px">
	<!-- 1.列表 http://www.jeasyui.com/documentation/index.php# datagrid -->
	<table id="dg-leave-<%=type%>" class="easyui-datagrid" style="width: 700px; height: 500px"
		url="<%=url%>" toolbar="#toolbar-leave-<%=type%>" pagination="true" rownumbers="true"
		fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="staffName" width="20">申请人</th>
				<th field="reason" width="50">原因</th>
				<th field="managerName" width="20">审批人</th>
				<th field="reviewResult" width="20">结果</th>
				<th field="actTaskName" width="20">当前任务</th>
			</tr>
		</thead>
	</table>
	<!-- 列表上的按钮 linkbutton -->
	<div id="toolbar-leave-<%=type%>">
	<form id="fm-search-leave-<%=type%>">
	<table><tr>
		<a id="btn-leave-apply-<%=type%>" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="loadLeaveApplyFormBy<%=type%>()">申请</a>
		<a id="btn-leave-approve-<%=type%>" class="easyui-linkbutton" iconCls="icon-ok" plain="true" disabled="true" onclick="loadLeaveReviewFormBy<%=type%>(true);">同意</a>
		<a id="btn-leave-refuse-<%=type%>" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" disabled="true" onclick="loadLeaveReviewFormBy<%=type%>(false);">拒绝</a>
		<a id="btn-leave-diagram-<%=type%>" class="easyui-linkbutton" iconCls="icon-more" plain="true" onclick="loadLeaveDiagramBy<%=type%>();">流程图</a>
		<input name="searchContent" class="easyui-textbox" iconCls='icon-search'/>
	</tr></table>
	</form>
	</div>
	
	<!-- 2.加载申请表单的对话框 dialog -->
	<div id="dlg-leave-apply-<%=type%>" class="easyui-dialog" title="申请"
		style="width: 450px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-leave-apply-<%=type%>">
		<div class="ftitle">请输入申请信息</div>
		<form id="fm-leave-apply-<%=type%>" method="post">
			<input name="actProcInstId" type="hidden"/>
			<div class="fitem">
				<label>原因:</label>
				<input name="reason" class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<!-- 创建表单的按钮 linkbutton -->
	<div id="dlg-buttons-leave-apply-<%=type%>">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" 
			onclick="applyLeaveBy<%=type%>()" style="width: 90px">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg-leave-apply-<%=type%>').dialog('close')" style="width: 90px">取消</a>
	</div>
	
	<!-- 3.加载审批表单的对话框 dialog -->
	<div id="dlg-leave-review-<%=type%>" class="easyui-dialog" title="审批"
		style="width: 450px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-leave-review-<%=type%>">
		<div class="ftitle">请输入审核信息</div>
		<form id="fm-leave-review-<%=type%>" method="post">
			<input name="reviewResult" type="hidden"/>
			<input name="actProcInstId" type="hidden"/>
			<div class="fitem">
				<label>审核意见:</label>
				<input name="reviewRemark" class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<!-- 创建表单的按钮 linkbutton -->
	<div id="dlg-buttons-leave-review-<%=type%>">
		<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" 
			onclick="reviewLeaveBy<%=type%>()" style="width: 90px">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#dlg-leave-review-<%=type%>').dialog('close')" style="width: 90px">取消</a>
	</div>
	
	<!-- 4.加载流程图的对话框 dialog -->
	<div id="dlg-leave-diagram-<%=type%>" class="easyui-dialog" title="审批"
		style="width: 700px; height: 500px; padding: 10px 20px" closed="true">
		<img id="img-leave-diagram-<%=type%>"/>
	</div>
</div>
<!-- 4.所有按钮的点击响应事件 -->
<script type="text/javascript">
	// 为datagrid增加onBeforeLoad事件
	$('#dg-leave-<%=type%>').datagrid({
		onBeforeLoad : function (param) {// onBeforeLoad在datagrid请求列表数据之前被调用，param是请求的参数对象
			var t = $('#fm-search-leave-<%=type%>').serializeArray();
	        $.each(t, function() {
	        	if (this.value != '' && this.value != undefined) {
	        		// 使用form中的name和value设置param属性值
	        		param[this.name] = this.value;
	        	}
	        });
	        return true;
		},
		onClickRow : function (index, row) {// 实现datagrid行点击事件，对按钮进行权限控制
			if (row.actTaskDefinitionKey == 'taskLeaveApply') {
				$('#btn-leave-apply-<%=type%>').linkbutton('enable');
				$('#btn-leave-approve-<%=type%>').linkbutton('disable');
				$('#btn-leave-refuse-<%=type%>').linkbutton('disable');
			} else if (row.actTaskDefinitionKey == 'taskLeaveReview') {
				$('#btn-leave-apply-<%=type%>').linkbutton('disable');
				$('#btn-leave-approve-<%=type%>').linkbutton('enable');
				$('#btn-leave-refuse-<%=type%>').linkbutton('enable');
			} else {
				$('#btn-leave-apply-<%=type%>').linkbutton('disable');
				$('#btn-leave-approve-<%=type%>').linkbutton('disable');
				$('#btn-leave-refuse-<%=type%>').linkbutton('disable');
			}
		}
	});
	
	// 响应列表上的申请按钮点击事件
	function loadLeaveApplyFormBy<%=type%> () {
		// 弹出修改对话框
		$('#dlg-leave-apply-<%=type%>').dialog('open');
		// 清除form数据
		$('#fm-leave-apply-<%=type%>').form('clear');
		var row = $('#dg-leave-<%=type%>').datagrid('getSelected');
		if (row) {
			// 加载form数据
			$('#fm-leave-apply-<%=type%>').form('load', row);
		}
	}
	
	// 响应申请表单的保存按钮点击事件 form
	function applyLeaveBy<%=type%>() {
		$('#fm-leave-apply-<%=type%>').form('submit', {
			url : 'bz/leave/apply',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success == false) {
					$.messager.alert({ // show error message
						title : '错误',
						icon : 'error',
						msg : result.message
					});
				} else {
					$('#dlg-leave-apply-<%=type%>').dialog('close'); // close the dialog
					$('#dg-leave-<%=type%>').datagrid('reload'); // reload the grid data
				}
			}
		});
	}
	
	// 审核按钮点击事件：同意、拒绝
	function loadLeaveReviewFormBy<%=type%> (result) {
		var row = $('#dg-leave-<%=type%>').datagrid('getSelected');
		console.log ('loadLeaveReviewForm...');
		console.log (row);
		if (row) {
			$('#dlg-leave-review-<%=type%>').dialog('open');
			// 清除form数据
			$('#fm-leave-review-<%=type%>').form('clear');
			// 加载form数据
			$('#fm-leave-review-<%=type%>').form('load', {
				reviewResult : result,
				actProcInstId : row.actProcInstId
			});
		}
	}
	
	// 响应审批表单的保存按钮点击事件 form
	function reviewLeaveBy<%=type%>() {
		$('#fm-leave-review-<%=type%>').form('submit', {
			url : 'bz/leave/review',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = eval('(' + result + ')');
				if (result.success == false) {
					$.messager.alert({ // show error message
						title : '错误',
						icon : 'error',
						msg : result.message
					});
				} else {
					$('#dlg-leave-review-<%=type%>').dialog('close'); // close the dialog
					$('#dg-leave-<%=type%>').datagrid('reload'); // reload the grid data
				}
			}
		});
	}
	
	function loadLeaveDiagramBy<%=type%> () {
		var row = $('#dg-leave-<%=type%>').datagrid('getSelected');
		if (row) {
			$('#dlg-leave-diagram-<%=type%>').dialog('open');
			// 设置对话框中img节点src属性
			$('#img-leave-diagram-<%=type%>').attr ('src', 'bz/leave/diagram?id=' + row.actProcInstId);
		}
	}
</script>