package SingletonPattern;

// Method 4 (Best): Use “Double-Checked Locking”

public class Singleton3 {
    private static volatile Singleton3 obj  = null;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton3.class) {
                // check again as multiple threads can reach above step
                if (obj==null)
                    obj = new Singleton3();
            }
        }
        return obj;
    }
    public void showMessage() {
        System.out.println("Hello Singleton3");
    }

}
