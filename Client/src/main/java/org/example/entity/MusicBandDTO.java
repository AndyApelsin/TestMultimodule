package org.example.entity;

import org.json.simple.JSONObject;

public class MusicBandDTO implements Transferable {
    private String name;

    private CoordinatesDTO coordinates;

    private Long numberOfParticipants;

    private String genre;

    private PersonDTO frontMan;

    public MusicBandDTO(String name, CoordinatesDTO coordinates, Long numberOfParticipants, String genre, PersonDTO frontMan) {
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    public JSONObject toJsonObj() {
        JSONObject musicBandJson = new JSONObject();
        musicBandJson.put("bandName", this.name);
        musicBandJson.put("coordinates", this.coordinates.toJsonObj());
        musicBandJson.put("numberOfParticipants", this.numberOfParticipants.toString());
        musicBandJson.put("genre", this.genre);
        musicBandJson.put("frontMan", this.frontMan.toJsonObj());
        return musicBandJson;
    }
}
