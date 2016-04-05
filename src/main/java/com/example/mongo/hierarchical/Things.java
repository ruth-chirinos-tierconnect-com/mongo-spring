package com.example.mongo.hierarchical;

import org.springframework.data.annotation.Id;

/**
 * Created by rchirinos on 4/5/16.
 */
public class Things {
    @Id
    private String id;

    private String thingTypeCode;
    private String serialNumber;
    private String groupCode;
    private String path;

    public Things() {}

    public Things(String id, String thingTypeCode, String serialNumber, String groupCode, String path) {
        this.id = id;
        this.thingTypeCode = thingTypeCode;
        this.serialNumber  = serialNumber;
        this.groupCode     = groupCode;
        this.path          = path;
    }

    @Override
    public String toString() {
        return String.format(
                "Things[id=%s, thingTypeCode='%s', serialNumber='%s', groupCode='%s', path='%s']",
                id, thingTypeCode, serialNumber, groupCode, path);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThingTypeCode() {
        return thingTypeCode;
    }

    public void setThingTypeCode(String thingTypeCode) {
        this.thingTypeCode = thingTypeCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
