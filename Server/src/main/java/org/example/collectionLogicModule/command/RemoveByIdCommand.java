package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;
@AllArgsConstructor
public class RemoveByIdCommand implements Command{
    private MusicBandService service;
    private Integer id;
    @Override
    public String execute() {
        service.removeById(id);
        return "Removed successfully!";
    }
}
