package SingletonPattern;

// this is not thread safe

public class Singleton2 {
    private static Singleton2 obj = null;

    // private constructor to force use of
    // getInstance() to create Singleton object
    private Singleton2() {}


    // Lazy Instantiation:
    public static synchronized Singleton2 getInstance()
    {
        if (obj == null)
            obj = new Singleton2();
        return obj;
    }

    public void showMessage() {
        System.out.println("Hello singleton2");
    }
}

