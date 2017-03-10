package com.sirun.common.scheduler.timer;

import hoperun.util.SelfLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sirun.common.db.mongodb.MongoTemp;

@Component("statisticsTimerService")
public class StatisticsTimerService {
	@Autowired
	private MongoTemp mongoTemp;
	
	/**
	 * 统计在线车辆
	 */
	public void statisticsOnlineNum(){
		SelfLogger.debug("定时统计车辆在线数 : 50辆！");
		System.out.println("定时统计车辆在线数 : 50辆！");
	}

	/**
	 * 统计车辆告警数
	 */
	public void statisticsAlertNum(){
		SelfLogger.debug("定时统计车辆告警数： 50个高危告警！");
		System.out.println("定时统计车辆告警数： 50个高危告警！");
	}

	/**
	 * 统计总车辆数
	 */
	public void statisticsTotalNum(){
		SelfLogger.debug("定时统计总车辆数： 50辆！");
		System.out.println("定时统计总车辆数： 50辆！");
	}
	
}
