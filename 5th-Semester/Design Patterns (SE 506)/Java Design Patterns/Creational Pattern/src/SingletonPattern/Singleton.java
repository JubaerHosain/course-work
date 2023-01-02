package SingletonPattern;

/**
 * There are two forms of singleton design pattern:
 * 1. Early Instantiation: creation of instance at load time.
 * 2. Lazy Instantiation: creation of instance when required.
 */

public class Singleton {

    // Early Instantiation
    // Java static "initializers" are thread safe
    private static Singleton instance = new Singleton();

    //make the constructor private so that this class cannot be instantiated
    private Singleton(){}

    //Get the only object available
    public static Singleton getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello Songleton!");
    }
}