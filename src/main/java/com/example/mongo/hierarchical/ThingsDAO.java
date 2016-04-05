package com.example.mongo.hierarchical;

/**
 * Created by rchirinos on 4/5/16.
 */

public interface ThingsDAO {

    public void create(Things p);

    public Things readById(String id);

    public void update(Things p);

    public int deleteById(String id);
}