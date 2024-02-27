package com.example.tcp_ip_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TcpIpTestApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpIpTestApplication.class, args);
        SimpleServer.serverForTCPIP();
    }
}
