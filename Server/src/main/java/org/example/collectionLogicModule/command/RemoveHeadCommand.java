package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;
import org.example.collectionLogicModule.util.Exception.CollectionEmptyException;

@AllArgsConstructor
public class RemoveHeadCommand implements Command{
    private MusicBandService musicBandService;
    @Override
    public String execute() {
        try {
            return musicBandService.removeHead().toString();
        } catch (CollectionEmptyException e) {
            return "You cant remove head of empty collection!";
        }
    }
}
