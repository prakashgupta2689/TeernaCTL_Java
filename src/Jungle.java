public class Jungle {

    public static void main(String[] args) {

        MockingBird mockingBird = new MockingBird();
        System.out.println(mockingBird.getLegs());
        System.out.println("after default constructor "+MockingBird.numOfMockingBirds);

        MockingBird mockingBird1 = new MockingBird(2,2);
        System.out.println("after parameterised constructor "+MockingBird.numOfMockingBirds);

        System.out.println(mockingBird1.getLegs());
        mockingBird1.poop();

        Bird bird = new MockingBird(2,3);
        System.out.println(MockingBird.numOfMockingBirds);
        System.out.println("after mockingBird created of Type Bird with parameterised constructor of MockingBird "+MockingBird.numOfMockingBirds);

        bird.poop();
       // bird.fly(); will give compiler error

        Bird bird1 = new Duck();
        bird1.poop();


    }
}
