package com.sirun.service.impl;

import hoperun.util.SelfLogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sirun.common.base.BaseQuery;
import com.sirun.common.db.mongodb.MongoTemp;
import com.sirun.entity.AlartStatistics;
import com.sirun.entity.VehicleAlert;
import com.sirun.service.IVehicleAlertService;

@Service("vehicleAlertService")
public class VehicleAlertServiceImpl implements IVehicleAlertService{

	@Autowired
	private MongoTemp mongoTemp;
	
	/**
	 * 报警信息首页：
	 * pageSize: 分页查询，显示10条数据；
	 * carVin: 根据车辆VIN去重显示；
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getAllAlarmInfo(String vin, BaseQuery baseQuery, String type) {
		SelfLogger.debug("service根据车辆VIN查询车辆告警信息"+vin);
		Map result = new HashMap();
		List<AlartStatistics> alarmInfo = null;
		Long count = (long) 0;
		if(type.equals("index")) {//首页
			Sort sort = new Sort(Sort.Direction.DESC,"id");//queryId
			Query query = new Query();
			query.with(sort).skip(baseQuery.getCurrentNum()).limit(baseQuery.getPageSize());
			alarmInfo = mongoTemp.query(query, AlartStatistics.class);
			count = mongoTemp.staticsCount(query, AlartStatistics.class);
		} if (type.equals("update")) {//修改页面
			Criteria criteria = Criteria.where("vin").is(vin);
			Sort sort = new Sort(Sort.Direction.DESC,"id");
			Query query = new Query(criteria);
			query.with(sort);
			alarmInfo = mongoTemp.query(query, AlartStatistics.class);
			//[AlartStatistics [id=58b9074911fea7509fca3d6a, vin=mm,
			//alerts={0=22, 1=22, 2=22, 3=22, 4=22, 5=13, 6=13}]]
		}
		result.put("alarmInfo", alarmInfo);
		result.put("alarmCount",count);
		return result;
	}
	/**
	 * 根据车辆VIN查询车辆告警信息  currentIndex:当前页  pageSize：每页的行数  vin:车辆vin
	 * @param vin
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map queryVehicleAlertByVin(String vin, BaseQuery baseQuery){
		SelfLogger.debug("service根据车辆VIN查询车辆告警信息分页"+vin);
		Map result = new HashMap();
		Criteria criteria = Criteria.where("vin").is(vin);
		Sort sort = new Sort(Sort.Direction.DESC,"id");
		Query query = new Query(criteria);
		query.with(sort).skip(baseQuery.getCurrentNum()).limit(baseQuery.getPageSize());
		List<VehicleAlert> alerts = mongoTemp.query(query, VehicleAlert.class);
		Long count = mongoTemp.staticsCount(query, VehicleAlert.class);
		result.put("vehicleAlerts", alerts);
		result.put("totalNum",count);
		return result;
	}
}
