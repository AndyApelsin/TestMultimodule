package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.entity.MusicBand;
import org.example.collectionLogicModule.service.MusicBandService;
@AllArgsConstructor
public class UpdateByIdCommand implements Command{
    private MusicBandService musicBandService;
    private Integer id;
    private MusicBand musicBand;
    @Override
    public String execute() {
        if(musicBandService.updateById(id, musicBand)){
            return "Updated successfully!";
        }
        return "There is no band with such id.";
    }
}
