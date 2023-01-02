package SingletonPattern;

// see gfg, it has good solution

public class Demo {
    public static void main(String[] args) {

        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();

        Demo demo = new Demo();
        demo.singleTone();
        demo.singleTone1();
        demo.singleTone2();
        demo.singleTone3();
    }


    public void singleTone() {
        //Get the only object available
        Singleton singleton = Singleton.getInstance();

        //show the message
        singleton.showMessage();
    }


    public void singleTone1() {
        //Get the only object available
        Singleton1 singleton1 = Singleton1.getInstance();

        //show the message
        singleton1.showMessage();
    }

    public void singleTone2() {
        //Get the only object available
        Singleton2 singleton2 = Singleton2.getInstance();

        //show the message
        singleton2.showMessage();
    }
    public void singleTone3() {
        //Get the only object available
        Singleton3 singleton3 = Singleton3.getInstance();

        //show the message
        singleton3.showMessage();
    }

}