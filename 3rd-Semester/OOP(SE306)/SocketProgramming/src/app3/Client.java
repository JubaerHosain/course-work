package app3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client is started...");

        Socket socket = new Socket("127.0.0.1", 22222);

        System.out.println("Client connected...(Client)");

        // output stream should declare before input stream (otherwise not working)
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        // note: writerThread should run before readerThread

        WriterThread writerThread = new WriterThread(oos, "Client");
        writerThread.start();

        ReaderThread readerThread = new ReaderThread(ois, "Client");
        readerThread.start();


    }
}














