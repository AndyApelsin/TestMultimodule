package org.example.responseBuilderModule;

import org.json.simple.JSONObject;

public class ResponseBuilder {
    public static String buildResponse(String noJsonResponse){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("response", noJsonResponse);
        return jsonObject.toJSONString();
    }
}
