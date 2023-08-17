package org.example;

import org.example.clientConnectionModule.ServerConnectionHandler;
import org.example.collectionLogicModule.command.CommandExecutorHandler;
import org.example.collectionLogicModule.service.MusicBandService;
import org.example.requestReaderModule.RequestReader;
import org.example.responseBuilderModule.ResponseBuilder;

import java.io.IOException;
import java.net.DatagramSocket;

public class ServerMain
{
    public static void main( String[] args ){
        MusicBandService musicBandService = new MusicBandService();
        musicBandService.uploadMusicBands("C:\\Users\\andye\\IdeaProjects\\testclientserver\\TestMultimodule\\Server\\src\\main\\resources\\input.xml");
        CommandExecutorHandler commandExecutorHandler = new CommandExecutorHandler(musicBandService);
        try (DatagramSocket socket = new DatagramSocket(8082)){
            ServerConnectionHandler serverConnectionHandler = new ServerConnectionHandler(socket);
            while(true) {
                String request = serverConnectionHandler.getRequest();
                String responseNoJson = RequestReader.executeRequest(request, commandExecutorHandler);
                String responseJson = ResponseBuilder.buildResponse(responseNoJson);
                serverConnectionHandler.sendResponse(responseJson);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
