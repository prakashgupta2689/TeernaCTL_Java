package design.factory;

public class OperatingSystemFactory {

    public static OS getOSFactoryInstance(String name){

        if(name.equals("Secure"))
            return new IOS(name);
        else if(name.equals("Powerful"))
            return new Android("Powerful");
        else
            return new Windows("Closed");
    }
}
