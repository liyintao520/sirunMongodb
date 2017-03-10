package com.sirun.common.autoid;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.ReflectionUtils;

public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {
	@Resource
	private MongoTemplate mongoTemplate;
	
	public void onBeforeConvert(final Object source) {
		if(source != null){
			ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
				
				@Override
				public void doWith(Field field) throws IllegalArgumentException,
						IllegalAccessException {
					ReflectionUtils.makeAccessible(field);
					if(field.isAnnotationPresent(GeneratedValue.class) && field.get(source) == null) {
						//设置自增加ID
						field.set(source, getNextId(source.getClass().getSimpleName()));
					}
					
				}

				
			});
		}
	}
	/**
	 * 获取下一个自增ID
	 * @author yinjihuan
	 * @param collName  集合名
	 * @return
	 */
	private Long getNextId(String collName) {
		//创建一个查询  表达式 里面where条件 collname 等于你的变量collname的值
		Query query = new Query(Criteria.where("collName").is(collName));
		Update update = new Update();
		update.inc("seqId", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.upsert(true);
		options.returnNew(true);
		SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);
		return seqId.getSeqId();
	}
}
