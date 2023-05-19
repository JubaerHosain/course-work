package SingletonPattern;

class Singleton {
    // volatile instance variable
    private volatile static Singleton instance = null;

    private Singleton() { }


    // “Double-Checked Locking”
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("This is singleton example");
    }

    // Other methods and variables of the class
}


public class SingletonDemo {
    public static void main(String[] args) {
        // Get the instance of the Singleton class
        Singleton singleton1 = Singleton.getInstance();

        // Perform some operations
        singleton1.showMessage();

        // Get the instance again
        Singleton singleton2 = Singleton.getInstance();

        // Check if both instances are the same
        boolean sameInstance = (singleton1 == singleton2);
        System.out.println("Are the instances the same? " + sameInstance);
    }
}
