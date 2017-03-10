package com.sirun.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sirun.utility.log.SelfLogger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;
import com.sirun.common.base.BaseController;
import com.sirun.common.base.BaseQuery;
import com.sirun.entity.AlartStatistics;
import com.sirun.entity.VehicleAlert;
import com.sirun.service.IVehicleAlertService;

/**
 * 报警信息业务
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年3月1日 下午6:33:44
 */
@RestController
@RequestMapping("/vehiclealert")
public class VehicleAlertController extends BaseController {
	
	@Autowired
	private IVehicleAlertService vehicleAlertService;
	
	/**
	 * 报警信息列表【首页数据】
	 * @param baseQuery
	 * type : index
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllVehicleAlert",produces="application/json;charset=UTF-8")
	@SuppressWarnings("rawtypes")
	public Map getAllVehicleAlert(@RequestBody BaseQuery baseQuery){
		String carVin = "SIRUNTEST09210001";
		SelfLogger.debug("分页查询报警信息列表展示接口。");
		try {
			Preconditions.checkNotNull(baseQuery.getCurrentIndex(), "currentIndex参数必填");
			Preconditions.checkNotNull(baseQuery.getPageSize(), "pageSize参数必填");
			Map srresult = vehicleAlertService.getAllAlarmInfo(carVin, baseQuery, "index");
			return super.returnSuccessInfo(srresult);
		} catch (Exception e) {
			SelfLogger.error("获取分页查询报警信息列表展示接口异常！"+"异常消息："+e.getMessage());
			return super.returnFailtrueInfo(e);
		}
	}
	
	/**
	 * 根据车辆VIN查询车辆告警信息 的【详情页面】
	 * @param vin   @PathVariable 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryVehicleAlert",produces="application/json;charset=UTF-8")
	@SuppressWarnings("rawtypes")
	public Map queryVehicleAlertByVin(HttpServletRequest req){
		String vin =req.getParameter("vin");
		String currentIndex =req.getParameter("currentIndex");
		String pageSize =req.getParameter("pageSize");
		SelfLogger.debug("根据车辆VIN查询车辆告警信息接口"+vin);
		try {
			BaseQuery baseQuery=new BaseQuery();
			baseQuery.setCurrentIndex(Integer.parseInt(currentIndex));
			baseQuery.setPageSize(Integer.parseInt(pageSize));
			if(StringUtils.isNotBlank(vin)){
				Map srresult = vehicleAlertService.queryVehicleAlertByVin(vin,baseQuery);
				return super.returnSuccessInfo(srresult);
			}else{
				throw new RuntimeException("车辆VIN不能为空！");
			}
		} catch (Exception e) {
			SelfLogger.error("根据车辆VIN查询车辆告警信息异常"+vin);
			return super.returnFailtrueInfo(e);
		}
	}
	/**
	 * 跳转到【修改页面】
	 * type : update
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/toUpdate/{vin}")
	public ModelAndView toUpdate(@PathVariable String vin,Model model){
		SelfLogger.debug("根据车辆VIN【修改】："+vin);
		ModelAndView mav = new ModelAndView();
		try {
			Preconditions.checkNotNull(vin,"没有获取到vin号");
			Map map = vehicleAlertService.getAllAlarmInfo(vin, null, "update");
			System.out.println(map.get("alarmInfo"));
//[AlartStatistics [id=58b9074911fea7509fca3d6a, vin=mm, alerts={0=22, 1=22, 2=22, 3=22, 4=22, 5=13, 6=13}]]

			model.addAttribute("list", map.get("alarmInfo"));
			
			mav.setViewName("alertUpdate");
			return mav;
		} catch (Exception e) {
			SelfLogger.error("异常消息,返回首页："+e.getMessage());
			mav.setViewName("alertInfoIndex");
			return mav;
		}
	}
	
	/**
	 * 报警信息----【修改】
	 * @param info
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value = "/update")
	public Map doUpdate(HttpServletRequest req){
		String vin=req.getParameter("vin");
		String[] alerts=req.getParameterValues("alerts");
		
		System.out.println(123);
		return null;
		
	}
}
