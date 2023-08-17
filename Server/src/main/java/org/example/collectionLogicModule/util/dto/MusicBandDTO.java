package org.example.collectionLogicModule.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.collectionLogicModule.entity.MusicGenre;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "musicbanddto")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandDTO {
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "coordinates")
    private CoordinatesDTO coordinates; //Поле не может быть null
    @XmlElement(name = "numberofparticipants")
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement(name = "genre", nillable = true)
    private MusicGenre genre; //Поле может быть null
    @XmlElement(name = "frontman")
    private PersonDTO frontMan; //Поле не может быть null
}
