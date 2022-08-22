package app3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriterThread extends Thread{
    private String name;
    private ObjectOutputStream oos;

    public WriterThread(ObjectOutputStream oos, String name) {
        this.oos = oos;
        this.name = name;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String message = scanner.nextLine();
            try {
                this.oos.writeObject(message);
                System.out.println("Message sent...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
