package org.example.communicationModule;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ResponseReader {
    public static String readResponse(String jsonResponse){
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonResponseObject = (JSONObject) parser.parse(jsonResponse);
            return (String) jsonResponseObject.get("response");
        } catch (ParseException e) {
            return "Something went wrong while parsing response!";
        }
    }
}
