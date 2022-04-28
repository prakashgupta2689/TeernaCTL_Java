package misc.morganStanley.recursion;

public class Factorial {

    public static void main(String[] args) {

        int n = 6;
        int factUsingRecursion = factorialUsingRecursion(n);
        System.out.println(factUsingRecursion);

        int factUsingIteration = factorialUsingIteration(n);
        System.out.println(factUsingIteration);
    }

    private static int factorialUsingIteration(int n) {

        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact = fact * i;
        }
        return fact;
    }

    private static int factorialUsingRecursion(int n) {
        if(n == 0 || n == 1){
            return 1;
        }

        int factnm1 = factorialUsingRecursion(n-1);
        return n * factnm1;

    }
}
