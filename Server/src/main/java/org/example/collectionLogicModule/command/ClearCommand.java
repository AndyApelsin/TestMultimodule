package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;

@AllArgsConstructor
public class ClearCommand implements Command{
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        musicBandService.clear();
        return "Collection successfully cleared!";
    }
}
