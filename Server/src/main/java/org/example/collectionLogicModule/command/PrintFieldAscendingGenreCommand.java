package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.entity.MusicGenre;
import org.example.collectionLogicModule.service.MusicBandService;

import java.util.List;

@AllArgsConstructor
public class PrintFieldAscendingGenreCommand implements Command{
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        List<MusicGenre> genreList = musicBandService.getFieldAscendingGenre();
        for (MusicGenre musicGenre : genreList) {
            stringBuilder.append(musicGenre.name()).append("\n");
        }
        return stringBuilder.toString();
    }
}
