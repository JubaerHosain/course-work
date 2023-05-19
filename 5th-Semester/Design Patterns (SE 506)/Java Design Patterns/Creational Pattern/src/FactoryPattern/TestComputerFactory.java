package FactoryPattern;

/**
 * Factory Design Pattern Super Class
 */
abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}

/**
 * Factory Design Pattern Sub Classes
 */
class PC extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public PC(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}

class Server extends Computer {

    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}

/**
 * Factory Class
 */
class ComputerFactory {

    // Approach: 1
    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);

        return null;
    }

    // Approach: 2
    public static Computer getPC( String ram, String hdd, String cpu) {
        return new PC(ram, hdd, cpu);
    }

    public static Computer getServer( String ram, String hdd, String cpu) {
        return new Server(ram, hdd, cpu);
    }

    // both have advantages and disadvantages
}

class ComputerType {
    public static String PC = "pc";
    public static String SERVER = "server";
}

public class TestComputerFactory {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(ComputerType.PC,"2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer(ComputerType.SERVER,"16 GB","1 TB","2.9 GHz");

        Computer pc1 = ComputerFactory.getPC("2 GB","500 GB","2.4 GHz");
        Computer server1 = ComputerFactory.getServer("16 GB","1 TB","2.9 GHz");

        System.out.println("Factory PC Config::"+pc1);
        System.out.println("Factory Server Config::"+server1);
    }
}
