package org.example.collectionLogicModule.entity;

import lombok.*;
import org.example.collectionLogicModule.util.dto.CoordinatesDTO;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    private Integer x; //Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates(CoordinatesDTO dto){
        XmlValidationHelper.checkNotNullXml(dto.getX(), "x coord is null in location in xml");
        this.x = dto.getX();
        XmlValidationHelper.checkNotNullXml(dto.getY(), "y coord is null in location in xml");
        this.y = dto.getY();
    }
    CoordinatesDTO getCoordinatesDTO(){
        return new CoordinatesDTO(x, y);
    }

}
