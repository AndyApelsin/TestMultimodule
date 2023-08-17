package org.example.communicationModule;

import javax.management.InstanceAlreadyExistsException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ConnectionHandler {
    InetAddress address;
    int port;
    DatagramSocket socket;

    public ConnectionHandler(DatagramSocket socket, InetAddress address, int port) {
        this.address = address;
        this.port = port;
        this.socket = socket;
    }

    public void sendRequest(String jsonRequest) throws IOException {
        byte[] buf = jsonRequest.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
    }

    public String getResponse() throws IOException {
        byte[] buf = new byte[4096];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }
}
