package com.sirun.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 描述： 学生表Mongodb映射实体类
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年2月28日 下午4:00:42
 */
@Document(collection="student")
public class Student {
	
	//@Indexed - 声明该字段需要索引，建索引可以大大的提高查询效率。
	
}
