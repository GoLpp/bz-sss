package com.qfedu.bz.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.qfedu.common.util.WoConstant;
import com.qfedu.esys.entity.Staff;

/**
 * 地理位置信息
 * @author cailei
 *
 */
@Entity
@Table(name = "bz_gis")
public class GisInfo {
    @SuppressWarnings("unused")
    private final static Logger LOG = LogManager.getLogger(GisInfo.class);

    @Id
    @Column(length = 50)
    private String id;

    /**
     * 经度
     */
    @Column
    private Double longitude;
    
    /**
     * 纬度
     */
    @Column
    private Double latitude;
    
    /**
     * 海拔
     */
    @Column
    private Double altitude;

    /**
     * 采集时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = WoConstant.FORMAT_DATETIME)
    private Date collectedTime;


    /**
     * 关联网关
     */
    @ManyToOne
    @JoinColumn(name = "gateway_id")
    private Gateway gateway;

    /**
     * 关联人员
     */
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    /**
     * 关联任务
     */
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public GisInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Date getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(Date collectedTime) {
        this.collectedTime = collectedTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
