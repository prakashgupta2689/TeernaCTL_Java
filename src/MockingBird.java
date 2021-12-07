public class MockingBird extends Bird{

    int wings;
    static int numOfMockingBirds;

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public void fly(){
        System.out.println("I am mockingBird. I fly!");
    }

    MockingBird(){
        super();
    }
    MockingBird(int legs, int wings){
        this.wings = wings;
        this.legs = legs;
        numOfMockingBirds++;
    }

    public void poop(){
        System.out.println("I am mockingBird. I poop!");
    }
}
