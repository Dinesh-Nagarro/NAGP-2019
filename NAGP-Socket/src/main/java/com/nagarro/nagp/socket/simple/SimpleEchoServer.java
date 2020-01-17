package com.nagarro.nagp.socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

/******************************************************************************
 *  Compilation:  javac EchoServer.java
 *  Execution:    java EchoServer port
 *  Dependencies: In.java Out.java
 *  
 *  Runs an echo server which listents for connections on port 4444,
 *  and echoes back whatever is sent to it.
 *
 *
 *  % java EchoServer 4444
 *
 *
 *  Limitations
 *  -----------
 *  The server is not multi-threaded, so at most one client can connect
 *  at a time.
 *
 ******************************************************************************/

import java.net.Socket;

public class SimpleEchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(10007);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("Waiting for connection.....");
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        System.out.println("Connection successful");
        System.out.println("Waiting for input.....");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Server: " + inputLine);
            out.println(inputLine);

            if (inputLine.equals("Bye."))
                break;
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
