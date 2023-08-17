package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.entity.MusicBand;
import org.example.collectionLogicModule.service.MusicBandService;
import org.example.collectionLogicModule.util.helper.PassportIdHelper;

@AllArgsConstructor
public class AddCommand implements Command{
    private MusicBandService musicBandService;
    private MusicBand musicBand;
    @Override
    public String execute() {
        if(!PassportIdHelper.addPassportId(musicBand.getFrontMan().getPassportID())){
            return "You can't add music band, where front man's passport ID is not unique";
        }
        musicBandService.add(musicBand);
        return "Added successfully";
    }
}
