package com.sirun.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sirun.common.utils.LoginEnum;

public class LoginInterceptor implements HandlerInterceptor{

	private String[] inCludeUrls;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		boolean flag = false;
		String url = request.getRequestURI().toString();
//		url = /sirunMongodb-web/js/jquery-1.9.0.min.js
		for(String s : inCludeUrls){
			//判断是否包含，如果包含指定字符串就返回true 否则 false
			if(url.contains(s)){
				flag = true;
				break;
			}
		}
		if(!flag){
			String username = (String) request.getSession().getAttribute(LoginEnum.LONGIN_USER_NAME.getloginInfo());
//			isNotEmpty将空格也作为参数，isNotBlank则排除空格参数
			if(StringUtils.isNotBlank(username)){
				flag = true;
			}else{
				response.sendRedirect(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/index.jsp");
				//request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		return flag;
	}

	public void setInCludeUrls(String[] inCludeUrls) {
		this.inCludeUrls = inCludeUrls;
	}
}
