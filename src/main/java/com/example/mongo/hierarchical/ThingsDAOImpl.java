package com.example.mongo.hierarchical;

/**
 * Created by rchirinos on 4/5/16.
 */

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.WriteResult;

public class ThingsDAOImpl implements ThingsDAO {

    private MongoOperations mongoOps;
    private static final String THINGS_COLLECTION = "path_things";

    public ThingsDAOImpl(MongoOperations mongoOps){
        this.mongoOps=mongoOps;
    }

    @Override
    public void create(Things p) {
        this.mongoOps.insert(p, THINGS_COLLECTION);
    }

    @Override
    public Things readById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoOps.findOne(query, Things.class, THINGS_COLLECTION);
    }

    @Override
    public void update(Things p) {
        this.mongoOps.save(p, THINGS_COLLECTION);
    }

    @Override
    public int deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoOps.remove(query, Things.class, THINGS_COLLECTION);
        return result.getN();
    }

}
