package basicCoding;


/**
 * Write a program that prints the numbers from 1 to 100
 * and for multiples of ‘3’ print “Fizz” instead of the number and for the multiples of ‘5’ print “Buzz”
 * for multiples of '15' print "FizzBuzz"
 * */
public class FizzBuzz {

    public static void main(String[] args) {

        for(int i = 1; i <= 100; i++){

            if(i % 15 == 0)
                System.out.println("FizzBuzz");
            else if(i % 3 == 0)
                System.out.println("Fizz");
            else if(i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }

    }
}
