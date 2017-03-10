package com.sirun.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
/**
 * 参考文档： http://www.runoob.com/redis/redis-java.html
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年3月9日 下午3:22:44
 */
public class RedisClient {

	private static Jedis jedis;
	
	public static void main(String[] args) {
		connectionRedis();
//		redisString(jedis);
//		redisList(jedis);
//		redisMap(jedis);
//		redisSet(jedis);
		testRedisPool();
	}
	/**
	 * 连接Redis
	 */
	public static void connectionRedis() {
		//TODO 运行连接操作的时候 Redis服务一定要启动，否则连接报错
		// 连接 Redis 服务 参考 Jedis , IP,Prot
//		Jedis jedis = new Jedis("192.168.9.51", 6379);
//		jedis.auth("sirun123");//权限认证  进去看你发现实际上就是 密码password
		jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// 查看服务是否运行
		System.out.println("Server is running: " + jedis.ping());
	}
	/**
	 * redis存储字符串
	 * @param jedis
	 */
	public static void redisString(Jedis jedis) {
		//-----添加数据----------  
		jedis.set("name","dandan");//向key-->name中放入了value-->xinxin  
		System.out.println(jedis.get("name"));//执行结果：xinxin  
		jedis.append("name", " is my lover"); //拼接
		System.out.println(jedis.get("name")); 
		jedis.del("name");  //删除某个键
		System.out.println(jedis.get("name"));
		//设置多个键值对
		jedis.mset("name","liyintao","age","27","qq","657380530");
		jedis.incr("age"); //进行加1操作
		System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	}

	/**
	 * Redis Java List(列表) 实例
	 * 
	 * @param jedis
	 */
	public static void redisList(Jedis jedis) {
		jedis.del("dataBaseList");//开始前，先移除所有的内容
		System.out.println(jedis.lrange("dataBaseList",0,-1));
		// 存储数据到列表中	先向key dataBaseList 中存放三条数据  
		jedis.lpush("dataBaseList", "Redis");
		jedis.lpush("dataBaseList", "Mongodb");
		jedis.lpush("dataBaseList", "Mysql");
		jedis.lpush("dataBaseList", "Oracle");
		jedis.lpush("dataBaseList", "Server 2008");
		jedis.lpush("dataBaseList", "Access");
		// 获取存储的数据并输出	jedis.lrange是按范围取出，
		//第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		List<String> list = jedis.lrange("dataBaseList", 0, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}
	}

	/**
	 * Redis Java Map 实例
	 * 
	 * @param jedis
	 */
	public static void redisMap(Jedis jedis) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "liyintao");
		map.put("age", "27");
		map.put("qq","657380530");
		map.put("birth",new Date().toString());
		jedis.hmset("user", map);
		//取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List  
		//第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
		List<String> rsmap = jedis.hmget("user", "name", "age", "qq", "birth");
		System.out.println("rsmap : " + rsmap);
		/***********************删除map中的某个键值 ***************************/
		//TODO hdel  删除指定的字段从一个散列存储键。
		jedis.hdel("user","age");
		System.out.println(jedis.hmget("user", "age"));//因为删除了，返回值 null
		System.out.println(jedis.hlen("user"));//返回key为user的键中存放的值的个数2
		System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true  
		System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  
		System.out.println(jedis.hvals("user"));//返回map对象中的所有value 
		System.out.println("********************************");
		
		Iterator<String> iter = jedis.hkeys("user").iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " : " + jedis.hmget("user", key));
		}
		
	}

	/**
	 * Redis Java Set 实例
	 * 
	 * @param jedis
	 */
	public static void redisSet(Jedis jedis){
		jedis.del("user");//开始前，先移除所有的内容【因为上面用到过user这个key，为了保证程序正常运行需要删除key】
		//添加  
		jedis.sadd("user","liyintao");  
		jedis.sadd("user","dandan");  
		jedis.sadd("user","Lucy");  
		jedis.sadd("user","Jack");
		jedis.sadd("user","Mamasang");  
		jedis.sadd("user","what");  
		//移除noname 
		jedis.srem("user", "what");
		System.out.println("获取所有加入的value-->" + jedis.smembers("user"));
		System.out.println("判断 who 是否是user集合的-->" + jedis.sismember("user", "who"));
		System.out.println(jedis.srandmember("user")); 
		System.out.println("返回集合的元素个数  -->" + jedis.scard("user"));
	}
	
	
	
	public static void testRedisPool() {
		RedisUtil.getJedis().set("newname", "中文测试");
		System.out.println(RedisUtil.getJedis().get("newname"));
	}
}
