package com.sirun.common.base;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseController {

	/**
	 * 
	 * @param linkedHashMap-响应信息
	 * @return 统一返回成功信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map returnSuccessInfo(Object object){
    	Map result = new LinkedHashMap(5);
    	result.put("result", 1);//1成功   
    	result.put("srresult", object);
    	return result;
    }
 
	/**
	 * @param linkedHashMap-响应信息
	 * @return 统一处理失败信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map returnFailtrueInfo(Exception e){
		Map result = new LinkedHashMap(5);
		result.put("result", 2);//系统发生异常
		result.put("srresult",e.getMessage());
		return result;
	}
	
}
