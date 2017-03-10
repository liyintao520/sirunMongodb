package com.sirun.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sirun.common.autoid.GeneratedValue;

/**
 * <p>Title: 众泰电动车监控系统</p>
 * <p>Description: 车辆在线信息mongodb映射实体类</p>
 * <p>Company: 斯润天朗（北京）科技有限公司</p> 
 * @author xushijie
 * @date 2016年10月19日 下午3:11:57
 */
@Document(collection="vehiclealert")
public class VehicleAlert {
	
	@Id
	private String id;
	
	@GeneratedValue
	@Indexed(unique=true)
	public Long queryId;
	
	@Indexed
	private String vin; //车辆vin
	
//	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date startTime; //告警开始时间
	
	private String alertType; //告警类型
	
	private String alertNo; //报警信号编号
	
	private Integer alertLevel; //报警级别

	private String alertValue;//报警说明
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getAlertNo() {
		return alertNo;
	}

	public void setAlertNo(String alertNo) {
		this.alertNo = alertNo;
	}

	public Integer getAlertLevel() {
		return alertLevel;
	}

	public void setAlertLevel(Integer alertLevel) {
		this.alertLevel = alertLevel;
	}

	public String getAlertValue() {
		return alertValue;
	}

	public void setAlertValue(String alertValue) {
		this.alertValue = alertValue;
	}

}
