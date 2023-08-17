package org.example.collectionLogicModule.command;

import lombok.AllArgsConstructor;
import org.example.collectionLogicModule.entity.MusicBand;
import org.example.collectionLogicModule.entity.Person;
import org.example.collectionLogicModule.service.MusicBandService;
import org.example.collectionLogicModule.util.Generator.IdGenerator;
import org.example.collectionLogicModule.util.requestUtil.*;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CommandExecutorHandler {
    private MusicBandService service;
    private static final String INFO_COMMAND_CODE = "2";
    private static final String SHOW_COMMAND_CODE = "3";
    private static final String ADD_COMMAND_CODE = "4";
    private static final String UPDATE_BY_ID_COMMAND_CODE = "5";
    private static final String REMOVE_BY_ID_COMMAND_CODE = "6";
    private static final String CLEAR_COMMAND_CODE = "7";
    private static final String EXECUTE_SCRIPT_COMMAND_CODE = "8";
    private static final String EXIT_COMMAND_CODE = "9";
    private static final String REMOVE_FIRST_COMMAND_CODE = "10";
    private static final String REMOVE_HEAD_COMMAND_CODE = "11";
    private static final String MIN_BY_CREATION_DATE_COMMAND_CODE = "13";
    private static final String FILTER_LESS_THAN_FRONT_MAN_COMMAND_CODE = "14";
    private static final String PRINT_FIELD_ASCENDING_GENRE_COMMAND_CODE = "15";

    public String executeCommandByCommandCode(String commandCode, RequestDataObject requestDataObject){
        switch (commandCode){
            case INFO_COMMAND_CODE -> {
                return executeInfoCommand();
            }
            case SHOW_COMMAND_CODE -> {
                return executeShowCommand();
            }
            case ADD_COMMAND_CODE -> {
                RequestMusicBandObject requestMusicBandObject = (RequestMusicBandObject) requestDataObject;
                MusicBand musicBand = requestMusicBandObject.getMusicBand();
                musicBand.setId(IdGenerator.generateId());
                musicBand.setCreationDate(LocalDateTime.now());
                return executeAddCommand(musicBand);
            }
            case UPDATE_BY_ID_COMMAND_CODE -> {
                RequestMusicBandAndIdObject requestMusicBandAndIdObject = (RequestMusicBandAndIdObject) requestDataObject;
                return executeUpdateByIdCommand(requestMusicBandAndIdObject.getId(), requestMusicBandAndIdObject.getMusicBand());
            }
            case REMOVE_BY_ID_COMMAND_CODE -> {
                RequestIdObject requestIdObject = (RequestIdObject) requestDataObject;
                return executeRemoveByIdCommand(requestIdObject.getId());
            }
            case CLEAR_COMMAND_CODE -> {
                return executeClearCommand();
            }
            case EXECUTE_SCRIPT_COMMAND_CODE -> {
                RequestFileNameObject requestFileNameObject = (RequestFileNameObject) requestDataObject;
                return executeExecuteScriptByFileNameCommand(requestFileNameObject.getFileName());
            }
            case EXIT_COMMAND_CODE -> {
                return executeExitCommand();
            }
            case REMOVE_FIRST_COMMAND_CODE -> {
                return executeRemoveFirstCommand();
            }
            case REMOVE_HEAD_COMMAND_CODE -> {
                return executeRemoveHeadCommand();
            }
            case MIN_BY_CREATION_DATE_COMMAND_CODE -> {
                return executeMinByCreationDateCommand();
            }
            case FILTER_LESS_THAN_FRONT_MAN_COMMAND_CODE -> {
                RequestPersonObject requestPersonObject = (RequestPersonObject) requestDataObject;
                return executeFilterLessThanFrontMan(requestPersonObject.getFrontMan());
            }
            case PRINT_FIELD_ASCENDING_GENRE_COMMAND_CODE -> {
                return executePrintFieldAscendingGenre();
            }
            default -> {
                return "There's no command with this command code: " + commandCode;
            }
        }
    }
    private String executeInfoCommand() {
        return CommandExecutor.executeCommand(new InfoCommand(service));
    }

    private String executeShowCommand() {
        return CommandExecutor.executeCommand(new ShowCommand(service));
    }

    private String executeAddCommand(MusicBand musicBand) {
        return CommandExecutor.executeCommand(new AddCommand(service, musicBand));
    }

    private String executeUpdateByIdCommand(Integer id, MusicBand musicBand) {
        return CommandExecutor.executeCommand(new UpdateByIdCommand(service, id, musicBand));
    }

    private String executeRemoveByIdCommand(Integer id) {
        return CommandExecutor.executeCommand(new RemoveByIdCommand(service, id));
    }

    private String executeClearCommand() {
        return CommandExecutor.executeCommand(new ClearCommand(service));
    }

    private String executeExecuteScriptByFileNameCommand(String fileName) {
        return CommandExecutor.executeCommand(new ExecuteScriptByFileNameCommand(service, fileName));
    }

    private String executeExitCommand() {
        return CommandExecutor.executeCommand(new ExitCommand(service));
    }

    private String executeRemoveFirstCommand() {
        return CommandExecutor.executeCommand(new RemoveFirstCommand(service));
    }

    private String executeRemoveHeadCommand() {
        return CommandExecutor.executeCommand(new RemoveHeadCommand(service));
    }

    private String executeMinByCreationDateCommand() {
        return CommandExecutor.executeCommand(new MinByCreationDateCommand(service));
    }

    private String executeFilterLessThanFrontMan(Person frontMan) {
        return CommandExecutor.executeCommand(new FilterLessThanFrontManCommand(service, frontMan));
    }

    private String executePrintFieldAscendingGenre(){
        return CommandExecutor.executeCommand(new PrintFieldAscendingGenreCommand(service));
    }
}
