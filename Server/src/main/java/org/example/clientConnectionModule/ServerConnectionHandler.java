package org.example.clientConnectionModule;

import lombok.Getter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Getter
public class ServerConnectionHandler {
    private CallerCredits callerCredits;
    private DatagramSocket datagramSocket;

    public ServerConnectionHandler(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    public String getRequest() throws IOException {
        byte[] buf = new byte[4096];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(packet);
        this.callerCredits = new CallerCredits(packet.getAddress(), packet.getPort());
        return new String(packet.getData(), 0, packet.getLength());
    }

    public void sendResponse(String jsonResponse) throws IOException {
        byte[] buf = jsonResponse.getBytes();
        DatagramPacket response = new DatagramPacket(buf, buf.length, callerCredits.getAddress(), callerCredits.getPort());
        datagramSocket.send(response);
    }
}
