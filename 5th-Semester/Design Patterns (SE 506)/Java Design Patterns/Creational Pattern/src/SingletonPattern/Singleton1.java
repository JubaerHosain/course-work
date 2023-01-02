package SingletonPattern;

// this is not thread safe

public class Singleton1 {
    private static Singleton1 obj = null;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Singleton1() {}


    // Lazy Instantiation:
    public static Singleton1 getInstance()
    {
        if (obj == null)
            obj = new Singleton1();
        return obj;
    }

    public void showMessage() {
        System.out.println("Hello singleton1");
    }
}

