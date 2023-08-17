package org.example.collectionLogicModule.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "musicbandservicedto")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandServiceDTO {
    @XmlElementWrapper(name = "musicbandstorage")
    @XmlElement(name = "musicbanddto")
    private List<MusicBandDTO> musicBandStorage;
}
