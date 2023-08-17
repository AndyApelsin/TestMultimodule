package org.example.requestReaderModule;

import org.example.collectionLogicModule.command.CommandExecutorHandler;
import org.example.collectionLogicModule.entity.*;
import org.example.collectionLogicModule.util.requestUtil.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RequestReader {
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

    public static String executeRequest(String jsonRequest, CommandExecutorHandler commandExecutorHandler) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject requestObject = (JSONObject) parser.parse(jsonRequest);
            String commandCode = (String) requestObject.get("commandCode");
            if (COMMAND_CODES_WITHOUT_DATA.contains(commandCode)) {
                return commandExecutorHandler.executeCommandByCommandCode(commandCode, null);
            }
            if (COMMAND_CODES_WITH_MUSIC_BAND_DATA.contains(commandCode)) {
                JSONObject dataObject = (JSONObject) requestObject.get("data");
                MusicBand musicBand = parseMusicBand((JSONObject) dataObject.get("musicBand"));
                RequestDataObject requestDataObject = new RequestMusicBandObject(musicBand);
                return commandExecutorHandler.executeCommandByCommandCode(commandCode, requestDataObject);
            }
            if (COMMAND_CODES_WITH_FRONT_MAN_DATA.contains(commandCode)) {
                JSONObject dataObject = (JSONObject) requestObject.get("data");
                Person frontMan = parseFrontMan((JSONObject) dataObject.get("frontMan"));
                RequestDataObject requestDataObject = new RequestPersonObject(frontMan);
                return commandExecutorHandler.executeCommandByCommandCode(commandCode, requestDataObject);
            }
            if (COMMAND_CODES_WITH_ID_DATA.contains(commandCode)) {
                JSONObject dataObject = (JSONObject) requestObject.get("data");
                Integer id = Integer.valueOf((String) dataObject.get("id"));
                RequestDataObject requestDataObject = new RequestIdObject(id);
                return commandExecutorHandler.executeCommandByCommandCode(commandCode, requestDataObject);
            }
            if (COMMAND_CODES_WITH_MUSIC_BAND_AND_ID_DATA.contains(commandCode)) {
                JSONObject dataObject = (JSONObject) requestObject.get("data");
                Integer id = Integer.valueOf((String) dataObject.get("id"));
                MusicBand musicBand = parseMusicBand((JSONObject) dataObject.get("musicBand"));
                RequestDataObject requestDataObject = new RequestMusicBandAndIdObject(musicBand, id);
                return commandExecutorHandler.executeCommandByCommandCode(commandCode, requestDataObject);
            }
            if (COMMAND_CODES_WITH_FILE_NAME_DATA.contains(commandCode)) {
                JSONObject dataObject = (JSONObject) requestObject.get("data");
                String fileName = (String) dataObject.get("fileName");
                RequestDataObject requestDataObject = new RequestFileNameObject(fileName);
                return commandExecutorHandler.executeCommandByCommandCode(commandCode, requestDataObject);
            }
            return "There is no requested command code!";
        } catch (ParseException e) {
            return "Something goes wrong while parsing request!";
        }
    }

    private static MusicBand parseMusicBand(JSONObject musicBandJson) {
        String bandName = (String) musicBandJson.get("bandName");
        JSONObject coordinatesObject = (JSONObject) musicBandJson.get("coordinates");
        Coordinates coordinates = parseCoordinates(coordinatesObject);
        Long numberOfParticipants = Long.valueOf((String) musicBandJson.get("numberOfParticipants"));
        MusicGenre musicGenre = MusicGenre.valueOf((String) musicBandJson.get("genre"));
        JSONObject frontManObject = (JSONObject) musicBandJson.get("frontMan");
        Person frontMan = parseFrontMan(frontManObject);
        return new MusicBand(bandName, coordinates, numberOfParticipants, musicGenre, frontMan);
    }

    private static Person parseFrontMan(JSONObject frontManJson) {
        String frontManName = (String) frontManJson.get("personName");
        Float height = Float.valueOf((String) frontManJson.get("height"));
        float weight = Float.parseFloat((String) frontManJson.get("weight"));
        String passportID = (String) frontManJson.get("passportId");
        JSONObject locationObject = (JSONObject) frontManJson.get("location");
        Location location = parseLocation(locationObject);
        return new Person(frontManName, height, weight, passportID, location);
    }

    private static Coordinates parseCoordinates(JSONObject coordinatesJson) {
        Integer coordX = Integer.valueOf((String) coordinatesJson.get("coordX"));
        Long coordY = Long.valueOf((String) coordinatesJson.get("coordY"));
        return new Coordinates(coordX, coordY);
    }

    private static Location parseLocation(JSONObject locationJson) {
        Float locX = Float.valueOf((String) locationJson.get("locX"));
        Integer locY = Integer.valueOf((String) locationJson.get("locY"));
        double locZ = Double.parseDouble((String) locationJson.get("locZ"));
        String locName = (String) locationJson.get("locName");
        return new Location(locX, locY, locZ, locName);
    }
}
