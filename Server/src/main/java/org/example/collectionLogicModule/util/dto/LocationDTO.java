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
public class LocationDTO {
    @XmlElement(name = "x")
    private Float x;
    @XmlElement(name = "y")
    private Integer y;
    @XmlElement(name = "z")
    private double z;
    @XmlElement(name = "name")
    private String name; //Длина строки не должна быть больше 629, Поле может быть null
}
