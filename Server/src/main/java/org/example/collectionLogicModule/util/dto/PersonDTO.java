package org.example.collectionLogicModule.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDTO {
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "height")
    private Float height; //Значение поля должно быть больше 0
    @XmlElement(name = "weight")
    private float weight; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement(name = "passportid")
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле может быть null
    @XmlElement(name = "location")
    private LocationDTO location; //Поле может быть null
}
