package com.sirun.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>Title: 众泰电动车监控系统</p>
 * <p>Description: 车辆报警信息mongodb映射实体类</p>
 * <p>Company: 斯润天朗（北京）科技有限公司</p> 
 * @author liyintao
 * @date 2017年2月23日下午19:12:11
 */
@Document(collection="alartstatistics")
public class AlartStatistics {
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	private String vin; //车辆VIN
	
	private Map<String, Integer> alerts = new HashMap<String,Integer>();

	
	@Override
	public String toString() {
		return "AlartStatistics [id=" + id + ", vin=" + vin + ", alerts="
				+ alerts + "]";
	}

	public Integer getAlertNum(String alertType){
		return alerts.get("alertType");
	}
	
	public void putAlertNum(String alertType,Integer num){
		alerts.put(alertType, num);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Map<String, Integer> getAlerts() {
		return alerts;
	}

	public void setAlerts(Map<String, Integer> alerts2) {
		this.alerts = alerts2;
	}
	
}
