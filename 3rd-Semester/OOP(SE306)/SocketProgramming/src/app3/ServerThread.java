package app3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket clientSocket;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            // multiple message for same client
            while(true) {
                // reader and writer is dependent here that's why we don't used thread here


                // read from client
                Object clientMessage = ois.readObject();
                System.out.println("Client Message: " + (String) clientMessage);

                String serverMessage = (String) clientMessage;
                serverMessage = serverMessage.toUpperCase();

                // send to client
                oos.writeObject(serverMessage);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        // close client socket if client connection is broken
        try {
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
