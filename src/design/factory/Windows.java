package design.factory;

public class Windows implements OS{

    private String name;

    public Windows(String name) {
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

        System.out.println("I exist!");

    }
}
