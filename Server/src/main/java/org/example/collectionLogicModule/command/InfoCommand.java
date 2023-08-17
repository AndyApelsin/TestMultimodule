package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;
@AllArgsConstructor
public class InfoCommand implements Command{
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        return musicBandService.info();
    }
}
