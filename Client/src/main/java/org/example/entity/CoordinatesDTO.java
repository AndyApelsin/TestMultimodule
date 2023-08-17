package org.example.entity;

import org.json.simple.JSONObject;

public class CoordinatesDTO implements Transferable{
    private Integer x;

    private Long y;

    public CoordinatesDTO(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }

    public JSONObject toJsonObj() {
        JSONObject coordinatesJson = new JSONObject();
        coordinatesJson.put("coordX", this.x.toString());
        coordinatesJson.put("coordY", this.y.toString());
        return coordinatesJson;
    }
}
