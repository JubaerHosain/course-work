package app3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);

        System.out.println("Server is started...");

        // server in listen mode
        // this loop for accepting multiple socket
        while(true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected...(server)");

            // create a new thread for current client
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }

    }
}
