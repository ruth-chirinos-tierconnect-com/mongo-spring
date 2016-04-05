package com.example.mongo.hierarchical;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

/**
 * Created by rchirinos on 4/5/16.
 */
public class SpringDataMongoDBMain {
    public static final String DB_NAME = "riot_main";
    public static final String THING_COLLECTION = "spring_things";
    public static final String PATH_COLLECTION = "path_things";
    public static final String PATH_SNAPSHOTS_COLLECTION = "path_thingSnapshots";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;


    public static void main(String[] args) {
        try {
            final long startTime = System.currentTimeMillis();
            MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
            MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
//            List<Things> lst = mongoOps.find(
//                    new Query(Criteria.where("thingTypeCode").is("box_code")),
//                    Things.class, PATH_COLLECTION);


            List<Things> lst = mongoOps.find(
                    new Query(Criteria.where("thingTypeCode").is("box_code")),
                    Things.class, PATH_COLLECTION);

            for(Things things: lst)
            {
                System.out.println("RESULTADO: "+things);
                System.out.println();
            }

            //mongoOps.dropCollection(THING_COLLECTION);
            mongo.close();
            final long endTime = System.currentTimeMillis();
            final long total = endTime-startTime;
            System.out.println("TOTAL(ms)> "+total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        try {
            MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
            MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
            Things p = new Things("113", "PALLETE_CODE", "P1000", "mojix>SM", null);
            mongoOps.insert(p, THING_COLLECTION);

            Things p1 = mongoOps.findOne(
                    new Query(Criteria.where("thingTypeCode").is("PALLETE_CODE")),
                    Things.class, THING_COLLECTION);

            System.out.println("RESULTADO: "+p1);

            mongoOps.dropCollection(THING_COLLECTION);
            mongo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
