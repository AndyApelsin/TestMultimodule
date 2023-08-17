package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;

@AllArgsConstructor
public class SaveCommand implements Command{
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        musicBandService.save();
        return "Saved successfully!";
    }
}
