package org.example.entity;

import org.json.simple.JSONObject;

public class PersonDTO implements Transferable{
    private String name;

    private Float height;

    private float weight;

    private String passportID;

    private LocationDTO location;

    public PersonDTO(String name, Float height, float weight, String passportID, LocationDTO location) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.location = location;
    }

    public JSONObject toJsonObj() {
        JSONObject personJson = new JSONObject();
        personJson.put("personName", this.name);
        personJson.put("height", this.height.toString());
        personJson.put("weight", String.valueOf(this.weight));
        personJson.put("passportId", this.passportID);
        personJson.put("location", this.location.toJsonObj());
        return personJson;
    }
}
