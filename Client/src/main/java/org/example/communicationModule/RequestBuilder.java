package org.example.communicationModule;

import org.example.entity.MusicBandDTO;
import org.example.entity.PersonDTO;
import org.example.helper.InputHelper;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RequestBuilder {
    private static final Set<String> COMMAND_CODES_WITHOUT_DATA = new HashSet<>(
            Arrays.asList("2", "3", "7", "9", "10", "11", "13", "15")
    );
    private static final Set<String> COMMAND_CODES_WITH_MUSIC_BAND_DATA = new HashSet<>(
            Arrays.asList("4")
    );
    private static final Set<String> COMMAND_CODES_WITH_FRONT_MAN_DATA = new HashSet<>(
            Arrays.asList("14")
    );
    private static final Set<String> COMMAND_CODES_WITH_ID_DATA = new HashSet<>(
            Arrays.asList("6")
    );
    private static final Set<String> COMMAND_CODES_WITH_MUSIC_BAND_AND_ID_DATA = new HashSet<>(
            Arrays.asList("5")
    );
    private static final Set<String> COMMAND_CODES_WITH_FILE_NAME_DATA = new HashSet<>(
            Arrays.asList("8")
    );
    public static String buildRequestByCommandCode(String commandCode){
        if(COMMAND_CODES_WITHOUT_DATA.contains(commandCode)){
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("commandCode",commandCode);
            return jsonRequest.toJSONString();
        }
        if(COMMAND_CODES_WITH_MUSIC_BAND_DATA.contains(commandCode)){
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("commandCode",commandCode);
            JSONObject jsonRequestDataObject = new JSONObject();
            MusicBandDTO musicBandDTO = InputHelper.bandInput();
            jsonRequestDataObject.put("musicBand", musicBandDTO.toJsonObj());
            jsonRequest.put("data", jsonRequestDataObject);
            return jsonRequest.toJSONString();
        }
        if(COMMAND_CODES_WITH_FRONT_MAN_DATA.contains(commandCode)){
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("commandCode",commandCode);
            JSONObject jsonRequestDataObject = new JSONObject();
            PersonDTO personDTO = InputHelper.personInput();
            jsonRequestDataObject.put("frontMan", personDTO.toJsonObj());
            jsonRequest.put("data", jsonRequestDataObject);
            return jsonRequest.toJSONString();
        }
        if(COMMAND_CODES_WITH_ID_DATA.contains(commandCode)){
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("commandCode",commandCode);
            JSONObject jsonRequestDataObject = new JSONObject();
            String id = InputHelper.idInput();
            jsonRequestDataObject.put("id", id);
            jsonRequest.put("data", jsonRequestDataObject);
            return jsonRequest.toJSONString();
        }
        if(COMMAND_CODES_WITH_MUSIC_BAND_AND_ID_DATA.contains(commandCode)){
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("commandCode",commandCode);
            JSONObject jsonRequestDataObject = new JSONObject();
            MusicBandDTO musicBandDTO = InputHelper.bandInput();
            String id = InputHelper.idInput();
            jsonRequestDataObject.put("musicBand", musicBandDTO.toJsonObj());
            jsonRequestDataObject.put("id", id);
            jsonRequest.put("data", jsonRequestDataObject);
            return jsonRequest.toJSONString();
        }
        if(COMMAND_CODES_WITH_FILE_NAME_DATA.contains(commandCode)){
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("commandCode",commandCode);
            JSONObject jsonRequestDataObject = new JSONObject();
            String fileName = InputHelper.filenameInput();
            jsonRequestDataObject.put("fileName", fileName);
            jsonRequest.put("data", jsonRequestDataObject);
            return jsonRequest.toJSONString();
        }
        return "There is no command with this command code";
    }
}
