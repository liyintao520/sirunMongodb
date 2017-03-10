package com.sirun.common.db.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.sirun.entity.AlartStatistics;

/**
 * mongodb 模板
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年2月28日 下午5:00:01
 */
@Component
public class MongoTemp {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
     * 查询集合中的对象
     * @param query 查询条件
     * @param entityClass 对象实体类
     * @return
     */
	public <T> List<T> find(Query query, Class<T> entityClass){
		return mongoTemplate.find(query, entityClass);
	}
	/**
     * 查询集合中的对象
     * @param query 查询条件
     * @param entityClass 对象实体类
     * @return
     */
    public <T> List<T> query(Query query, Class<T> entityClass){
    	return mongoTemplate.find(query, entityClass);
    }
	/**
     * 按条件查询总数
	 * @param <T>
     * @param query
     * @param entityClass
     * @return
     */
	public long staticsCount(Query query, Class<?> entityClass){
		return mongoTemplate.count(query, entityClass);
		
	}

}
