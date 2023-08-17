package org.example.collectionLogicModule.util.requestUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.collectionLogicModule.entity.MusicBand;
@AllArgsConstructor
@Getter
public class RequestMusicBandAndIdObject implements RequestDataObject{
    private MusicBand musicBand;
    private Integer id;
}
