package org.example.collectionLogicModule.entity;

import lombok.*;
import org.example.collectionLogicModule.util.Generator.IdGenerator;
import org.example.collectionLogicModule.util.dto.MusicBandDTO;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MusicBand implements Comparable<MusicBand> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null

    public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants, MusicGenre genre, Person frontMan){
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    public MusicBand(MusicBandDTO dto){
        this.id = IdGenerator.generateId();
        this.creationDate = LocalDateTime.now();
        this.coordinates = new Coordinates(dto.getCoordinates());
        this.frontMan = new Person(dto.getFrontMan());
        XmlValidationHelper.checkNotNullXml(dto.getName(), "Band name in uploaded xml is null");
        XmlValidationHelper.checkStringNotEmptyXml(dto.getName(), "Band name is empty in uploaded xml");
        this.name = dto.getName();
        XmlValidationHelper.checkNotNullXml(dto.getNumberOfParticipants(), "Number of participants is null in uploaded xml");
        XmlValidationHelper.checkNumberPositivityXml(dto.getNumberOfParticipants(), "Number of participants is negative in uploaded xml");
        this.numberOfParticipants = dto.getNumberOfParticipants();
        this.genre = dto.getGenre();

    }
    public MusicBandDTO getMusicBandDTO(){
        return new MusicBandDTO(name, coordinates.getCoordinatesDTO(), numberOfParticipants, genre, frontMan.getPersonDTO());
    }
    @Override
    public int compareTo(MusicBand m) {
        if (this.name.compareTo(m.getName()) > 0) {
            return 1;
        } else if (this.name.compareTo(m.getName()) == 0 && this.frontMan.compareTo(m.getFrontMan()) > 0) {
            return 1;
        } else if (this.name.compareTo(m.getName()) == 0 && this.frontMan.compareTo(m.getFrontMan()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Music band name: " + this.name + "\n"
                + "Front man name: " + this.frontMan.getName() + "\n"
                + "Creation date: " + this.creationDate.toString() + "\n";
    }
}
