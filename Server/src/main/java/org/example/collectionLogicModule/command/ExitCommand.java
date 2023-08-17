package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;

@AllArgsConstructor
public class ExitCommand implements Command{
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        musicBandService.exit();
        return "Service stop working...";
    }
}
