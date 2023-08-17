package org.example.entity;

import org.json.simple.JSONObject;

public class LocationDTO implements Transferable{
    private Float x;

    private Integer y;

    private double z;

    private String name;

    public LocationDTO(Float x, Integer y, double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public JSONObject toJsonObj() {
        JSONObject locationJson = new JSONObject();
        locationJson.put("locX", this.x.toString());
        locationJson.put("locY", this.y.toString());
        locationJson.put("locZ", String.valueOf(this.z));
        locationJson.put("locName", this.name);
        return locationJson;
    }
}
