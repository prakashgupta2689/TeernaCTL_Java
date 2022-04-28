package design.factory;

public class IOS implements OS{

    private String name;

    public IOS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void spec() {

        System.out.println("I am the most secure OS");
    }
}
