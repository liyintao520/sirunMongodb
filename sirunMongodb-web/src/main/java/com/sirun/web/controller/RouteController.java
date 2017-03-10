package com.sirun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试Mongodb平台的中专路由器
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年3月1日 下午6:14:34
 */
@Controller
@RequestMapping("/web")
public class RouteController {
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String toLoginPage(){
		return "login";
	}
	/**
	 * 报警信息页面
	 * @return
	 */
	@RequestMapping("/alertInfoIndex")
	public String toAlertManagePage(){
		return "alertInfoIndex";
	}
	/**
	 * 报警信息详情页面
	 * @param vin
	 * @param model
	 * @return
	 */
	@RequestMapping("/alertInfoDetail")
	public String toAlertInfoPage(String vin,Model model){
		model.addAttribute("vin", vin);
		return "alertInfoDetail";
	}
	
	@RequestMapping("/stuIndex")
	public String getStuIndex(){
		return "stuIndex";
	}
	/**
	 * 所有404错误页面
	 * @return
	 */
	@RequestMapping("/error")
	public String toErrorPage(){
		return "404";
	}
}
