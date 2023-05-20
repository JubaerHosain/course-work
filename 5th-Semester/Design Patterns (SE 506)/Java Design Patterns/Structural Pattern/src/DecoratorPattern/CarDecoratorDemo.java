package DecoratorPattern;


/**
 * Decorator design pattern is used to modify the functionality of an object at runtime.
 * At the same time, other instances of the same class will not be affected by this, so
 * an individual object gets the modified behavior. Decorator design pattern is one of the
 * structural design patterns (such as Adapter Pattern, Bridge Pattern, Composite Pattern)
 * and uses abstract classes or interface with composition to implement.
 * */

// Component Interface
interface Car {
    public void assemble();
}

// Component Implementation
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }

}

// Decorator
class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}

// Concrete Decorators
class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

public class CarDecoratorDemo {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        // sport and luxury car extends car through CarDecorator

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        Car doubleSport = new SportsCar(sportsLuxuryCar);

        sportsLuxuryCar.assemble();
        System.out.println();
        doubleSport.assemble();
    }
}
