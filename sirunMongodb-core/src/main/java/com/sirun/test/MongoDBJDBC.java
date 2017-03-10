package com.sirun.test;

import java.util.ArrayList;  
import java.util.Date;
import java.util.List;  

import org.bson.Document;

import com.mongodb.MongoClient;  
import com.mongodb.MongoCredential;  
import com.mongodb.ServerAddress;  
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
/**
 * 参考文档：http://www.runoob.com/mongodb/mongodb-java.html  
 * Company: 斯润天朗（北京）科技有限公司
 * @author liyintao
 * @date 2017年3月7日 下午4:04:18
 */
public class MongoDBJDBC {  
    public static void main(String[] args){  
        try {  
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
            //ServerAddress()两个参数分别为 服务器地址 和 端口  
            ServerAddress serverAddress = new ServerAddress("192.168.9.51",27017);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
              
            //MongoCredential.createScramSha1Credential()三个参数分别为【 用户名 】【数据库名称】【 密码】
            MongoCredential credential = MongoCredential.createCredential("dba", "admin", "sirun123".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
              
            //通过连接认证获取MongoDB连接  
            @SuppressWarnings("resource")
			MongoClient mongoClient = new MongoClient(addrs,credentials);  
              
            //连接到数据库  
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin"); 
            System.out.println("Connect to database successfully"); 
            //创建集合  创建完了就注释掉。
            //mongoDatabase.createCollection("testMongoDb");
            //System.out.println("集合创建成功");
            
            // org.bson.Document
            //MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            //System.out.println("集合 test 选择成功");
            //创建文档
            //createDocument(collection);
            //检索所有文档  
            //findAll(collection, "find");
            //updateMany(collection);
            //delete(collection);
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }  
    }
    /**
     * 删除数据
     * @param collection
     */
    private static void delete(MongoCollection<Document> collection){
    	//删除符合条件的第一个文档  
        collection.deleteOne(Filters.eq("likes", 200));  
        //删除所有符合条件的文档  
        collection.deleteMany (Filters.eq("likes", 200)); 
        findAll(collection, "delete");
    }
    /**
     * updateMany
     * 更新集合中的所有文档根据指定的参数。
     * @param collection
     */
    @SuppressWarnings("unused")
	private static void updateMany(MongoCollection<Document> collection){
    	//更新文档   将文档中likes=100的文档修改为likes=200   
        collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
        findAll(collection, "update");
    }
    
    /**
     * 插入文档 
     * @param collection
     */
    @SuppressWarnings("unused")
	private static void createDocument(MongoCollection<Document> collection){
        /** 
        * 1. 创建文档 org.bson.Document 参数为key-value的格式 
        * 2. 创建文档集合List<Document> 
        * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
        * 4. 这些只能算是一个字段对应一个记录 
        * */
        Document document = new Document("title", "MongoDB");
        document.append("description", "database");
        document.append("likes", 100);
        document.append("by", "Fly");
        document.append("lyt", "李银涛");
        document.append("startTime", new Date());
        List<Document> documents = new ArrayList<Document>();  
        documents.add(document);  
        collection.insertMany(documents);  
        System.out.println("文档插入成功");  
    }
    
	@SuppressWarnings("unused")
	private static void findAll(MongoCollection<Document> collection, String type){
    	//检索所有文档  
        /** 
        * 1. 获取迭代器FindIterable<Document> 
        * 2. 获取游标MongoCursor<Document> 
        * 3. 通过游标遍历检索出的文档集合 
        * */  
        FindIterable<Document> findIterable = collection.find();  
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
           System.out.println(mongoCursor.next());  
        }
        if(type.equals("update")){
        	System.out.println("【修改】所有文档 --> 记录总数：" + collection.count());
        }else if(type.equals("find")){
        	System.out.println("【检索】所有文档 --> 记录总数：" + collection.count());
        }else if(type.equals("delete")){
        	System.out.println("【删除】所有文档 --> 记录总数：" + collection.count());
        }else{
        	
        }
        
    }
} 