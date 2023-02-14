package ObserverPattern;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Implemented by FileData to communicate with observers
interface FileSubject {
    public void registerFileObserver(FileObserver o);
    public void unregisterFileObserver(FileObserver o);
    public void notifyFileObservers(String fileName, String type, String time);
    public void monitor();
}

class FileMonitor implements FileSubject {
    private String fileName, filePath;
    private List<FileObserver> observers;


    public FileMonitor(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerFileObserver(FileObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterFileObserver(FileObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyFileObservers(String fileName, String type, String time) {
        for (FileObserver observer : observers) {
            observer.update(fileName, type, time);
        }
    }

    // Monitor changes in file
    @Override
    public void monitor() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(filePath).getParent();
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {
                WatchKey key = watchService.poll(1, TimeUnit.SECONDS);
                if (key != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        String type = event.kind().toString();
                        String time = String.valueOf(System.currentTimeMillis());
                        notifyFileObservers(fileName, type, time);
                    }
                    key.reset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// This interface is implemented by all those
// classes that are to be updated whenever there is an update from FileData
interface FileObserver {
    public void update(String fileName, String type, String date);
}

class FileChangeLogger implements FileObserver {
    private String name;

    public FileChangeLogger(String name) {
        this.name = name;
    }

    @Override
    public void update(String fileName, String type, String time) {
        System.out.println(name + " - File " + fileName + " " + type + " at " + time);
    }
}

public class FileMonitoringSystem {
    public static void main(String[] args) {
        String root_directory = System.getProperty("user.dir");
        String sub_directory = "Behavioral Pattern";

        String fileName = "monitor.txt";
        String filePath = root_directory + "/" + sub_directory + "/" + fileName;
        System.out.println(filePath);


        FileSubject fileSubject = new FileMonitor(fileName, filePath);

        FileObserver observer1 = new FileChangeLogger("Observer 1");
        FileObserver observer2 = new FileChangeLogger("Observer 2");

        fileSubject.registerFileObserver(observer1);
        fileSubject.registerFileObserver(observer2);

        fileSubject.monitor();
    }
}
