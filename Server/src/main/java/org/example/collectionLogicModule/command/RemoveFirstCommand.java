package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;
import org.example.collectionLogicModule.util.Exception.CollectionEmptyException;

@AllArgsConstructor
public class RemoveFirstCommand implements Command {
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        try {
            musicBandService.removeFirst();
        } catch (CollectionEmptyException e) {
            return "You cant remove first element in empty collection";
        }
        return "First element was successfully removed!";
    }
}
