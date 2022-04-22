package com.bit.mongoDB;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class Ex01 {

	public static void main(String[] args) {
		ServerAddress address = new ServerAddress("localhost", 27017);
		MongoClient client = new MongoClient(address);
		List<String> databases = client.getDatabaseNames();
		
		for(String database : databases) {
			System.out.println(database);
		}
		
		System.out.println("-------------------------------------");
		DB db = client.getDB("testDB");
		Set<String> set = db.getCollectionNames();
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println("-------------------------------------");
		DBCollection collection = db.getCollection("sales");
		
		BasicDBObject query = new BasicDBObject();
		BasicDBObject query2 = new BasicDBObject();
		query.append("price", 10);
		query2.append("$lt", 10);
		
		DBCursor cursor = collection.find(query2);
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
}
