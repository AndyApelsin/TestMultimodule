package org.example.collectionLogicModule.entity;

import lombok.*;
import org.example.collectionLogicModule.util.dto.PersonDTO;
import org.example.collectionLogicModule.util.helper.PassportIdHelper;
import org.example.collectionLogicModule.util.helper.XmlValidationHelper;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person implements Comparable<Person>{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Float height; //Поле не может быть null, Значение поля должно быть больше 0
    private float weight; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле может быть null
    private Location location; //Поле может быть null

    public Person(PersonDTO dto){
        XmlValidationHelper.checkNotNullXml(dto.getName(), "Front man name is null in xml");
        XmlValidationHelper.checkStringNotEmptyXml(dto.getName(), "Front man name is empty in xml");
        this.name = dto.getName();
        XmlValidationHelper.checkNotNullXml(dto.getHeight(), "Height is null in xml");
        XmlValidationHelper.checkNumberPositivityXml(dto.getHeight(), "Height is negative in xml");
        this.height = dto.getHeight();
        XmlValidationHelper.checkNotNullXml(dto.getWeight(), "Weight is negative in xml");
        this.weight = dto.getWeight();
        if (!dto.getPassportID().equals("")) {
            PassportIdHelper.checkPassportIdLengthXml(dto.getPassportID(), "Passport ID is too short in xml");
            PassportIdHelper.addPassportIdXml(dto.getPassportID(), "Passport ID is not unique in xml");
            this.passportID = dto.getPassportID();
        }
        if(passportID.equals("")){
            passportID = null;
        }
        this.location = new Location(dto.getLocation());
    }
    PersonDTO getPersonDTO (){
        return new PersonDTO(name, height, weight, passportID, location.getLocationDTO());
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }
}
