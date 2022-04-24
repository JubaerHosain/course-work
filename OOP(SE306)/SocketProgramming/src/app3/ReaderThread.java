package app3;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread extends Thread{
    private String name;
    private ObjectInputStream ois;

    public ReaderThread(ObjectInputStream ois, String name) {
        this.ois = ois;
        this.name = name;
    }

    @Override
    public void run() {
        // wait and read until server/client is running
        while (true) {
            try {
                // receive from server
                Object serverMessage = ois.readObject();
                System.out.println(name + " got: " + (String) serverMessage);
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
