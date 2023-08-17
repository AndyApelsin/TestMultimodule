package org.example.collectionLogicModule.entity;

import lombok.*;
import org.example.collectionLogicModule.util.dto.LocationDTO;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Location {
    private Float x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private double z;
    private String name; //Длина строки не должна быть больше 629, Поле может быть null

    public Location(LocationDTO dto) {
        XmlValidationHelper.checkNotNullXml(dto.getX(), "x coord in location is null in xml");
        this.x = dto.getX();
        XmlValidationHelper.checkNotNullXml(dto.getY(), "y coord in location is null in xml");
        this.y = dto.getY();
        this.z = dto.getZ();
        if (!dto.getName().equals("")) {
            XmlValidationHelper.checkStringSizeXml(dto.getName(), 629, "Location name is too long in xml");
            this.name = dto.getName();
        } else {
            this.name = null;
        }
    }
    LocationDTO getLocationDTO(){
        return new LocationDTO(x, y, z, name);
    }
}
