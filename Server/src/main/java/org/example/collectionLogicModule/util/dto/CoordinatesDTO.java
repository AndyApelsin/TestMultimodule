package org.example.collectionLogicModule.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class CoordinatesDTO {
    @XmlElement(name = "x")
    private Integer x;
    @XmlElement(name = "y")
    private Long y;
}
