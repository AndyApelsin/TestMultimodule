package org.example.collectionLogicModule.util.requestUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.collectionLogicModule.entity.Person;

@AllArgsConstructor
@Getter
public class RequestPersonObject implements RequestDataObject{
    private Person frontMan;
}
