package org.example.collectionLogicModule.command;

public class CommandExecutor {
    public static String executeCommand(Command command){
        return command.execute();
    }
}
