package design.factory;

public class Android implements OS{

    private String name;

    public Android(String name) {
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

        System.out.println("I am the most powerful OS");

    }
}
