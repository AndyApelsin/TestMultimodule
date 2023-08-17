package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.entity.MusicBand;
import org.example.collectionLogicModule.entity.Person;
import org.example.collectionLogicModule.service.MusicBandService;

import java.util.List;

@AllArgsConstructor
public class FilterLessThanFrontManCommand implements Command{
    private MusicBandService musicBandService;
    private Person frontMan;
    @Override
    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        List<MusicBand> musicBands = musicBandService.filterLessThanFrontMan(frontMan);
        for (MusicBand musicBand : musicBands) {
            stringBuilder.append(musicBand.toString());
        }
        return stringBuilder.toString();
    }
}
