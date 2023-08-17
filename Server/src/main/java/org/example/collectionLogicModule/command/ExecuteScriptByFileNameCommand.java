package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.service.MusicBandService;

@AllArgsConstructor
public class ExecuteScriptByFileNameCommand implements Command{
    private MusicBandService service;
    private String fileName;
    //TODO executeScriptCommand Execute
    @Override
    public String execute() {
        service.executeScriptByFilename(fileName);
        return null;
    }
}
