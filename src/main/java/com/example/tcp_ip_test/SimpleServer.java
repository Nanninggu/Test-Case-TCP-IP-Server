package com.example.tcp_ip_test;

import java.io.*;
import java.net.*;

public class SimpleServer {

    public static void serverForTCPIP() throws IOException {
        int portNumber = 5050; // Replace with your desired port number
        // Create server socket
        ServerSocket serverSocket = new ServerSocket(portNumber);

        System.out.println("서버 시작한다. 포트 번호 : " + portNumber);

        // Wait for and accept client connection
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트야 연결 됐다. " + clientSocket.getInetAddress().getHostName());

            // Create input and output streams
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Receive data from client
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);

            System.out.println("받은 메세지는 이거다.: " + message);

            // Send response to client
            String response = "안녕 나는 서버야! 이건 서버에서 보내는 아웃풋 스트림이야.";
            outputStream.write(response.getBytes());

            // Close streams and socket
            outputStream.close();
            inputStream.close();
            clientSocket.close();
        }
    }
}
