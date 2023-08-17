package org.example;

import org.example.communicationModule.ConnectionHandler;
import org.example.communicationModule.RequestBuilder;
import org.example.communicationModule.ResponseReader;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientMain
{
    public static void main( String[] args ) {
        boolean workState = true;
        int port = 8082;
        InetAddress address = null;
        try (DatagramSocket socket = new DatagramSocket()){
            address = InetAddress.getByName("localhost");
            ConnectionHandler connectionHandler = new ConnectionHandler(socket, address, port);
            Scanner scanner = new Scanner(System.in);
            while(workState){
                System.out.println("""
                    What do you want to do?
                    1. help
                    2. info
                    3. show
                    4. add element
                    5. update element by id
                    6. remove by id
                    7. clear collection
                    8. execute script by filename
                    9. exit
                    10. remove first element
                    11. print and remove first element
                    12. command history
                    13. min by creation date
                    14. filter less than front man
                    15. print genre of sorted elements
                    """);;
                String commandCode = scanner.nextLine();
                if(commandCode.equals("9")){
                    workState = false;
                } else {
                    String jsonRequest = RequestBuilder.buildRequestByCommandCode(commandCode);
                    connectionHandler.sendRequest(jsonRequest);
                    String jsonResponse = connectionHandler.getResponse();
                    String response = ResponseReader.readResponse(jsonResponse);
                    System.out.println(response);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
