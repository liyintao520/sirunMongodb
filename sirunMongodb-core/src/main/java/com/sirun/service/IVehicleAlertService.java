package com.sirun.service;

import java.util.Map;

import com.sirun.common.base.BaseQuery;


public interface IVehicleAlertService {
	/**
	 * 报警信息首页：
	 * pageSize: 分页查询，显示10条数据；
	 * carVin: 根据车辆VIN去重显示车辆报警信息；
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getAllAlarmInfo(String carVin, BaseQuery baseQuery, String type);
	
	/**
	 * 根据车辆VIN查询车辆告警信息  page:当前页  rows：没页的行数
	 * @param vin
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map queryVehicleAlertByVin(String vin, BaseQuery baseQuery);
}
