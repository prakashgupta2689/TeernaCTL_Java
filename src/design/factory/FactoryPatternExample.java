package design.factory;

public class FactoryPatternExample {

    public static void main(String[] args) {

        OS os = OperatingSystemFactory.getOSFactoryInstance("Secure");
        os.spec();
    }
}
