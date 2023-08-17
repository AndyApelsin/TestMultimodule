package org.example.clientConnectionModule;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.InetAddress;
@AllArgsConstructor
@Getter
public class CallerCredits {
    private final InetAddress address;
    private final int port;
}
