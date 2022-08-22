package app1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);

        System.out.println("Server is started...");

        // server in listen mode
        while(true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected...(server)");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                // read from client
                Object clientMessage = ois.readObject();
                System.out.println("Client Message: " + (String) clientMessage);

                String serverMessage = (String) clientMessage;
                serverMessage = serverMessage.toUpperCase();

                // send to client
                oos.writeObject(serverMessage);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
