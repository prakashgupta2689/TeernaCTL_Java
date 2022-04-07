package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaFiles {

    public static void main(String[] args) {

        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the any number: ");
        n = sc.nextInt();

        String pathName = "misc.C:\\Users\\teern\\Documents\\GCP\\numbers.txt";
        boolean isNumberFound = findNumberInFile(pathName, n);
        
        if(isNumberFound){
            System.out.println("Number matched in numbers.tx: displaying armstrong numbers");
            printArmstrong(n);
        }else{
            String newFilePath = "misc.C:\\Users\\teern\\Documents\\GCP\\new_numbers.txt";
            boolean isMatched = findNumberInFile(newFilePath, n);

            if(isMatched){
                System.out.println("Number matched in new_numbers.txt: displaying difference");
                displayDifference(n, newFilePath);
            }else{
                System.out.println("Number matched in neither numbers.txt or new_numbers.txt");
            }
        }
    }

    private static void displayDifference(int n, String pathname) {

        File file = new File(pathname);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(sc.hasNextLine()){
            int num = sc.nextInt();
            int diff = n - num;
            System.out.print(diff + ", ");
        }
    }

    private static void printArmstrong(int n) {

        for(int i = 1; i < n; i++){

            if(isArmstrong(i))
                System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static boolean isArmstrong(int num) {

        int sum = 0, rem, temp;
        temp = num;
        while (temp != 0) {
            rem = temp % 10;
            sum = sum + (rem * rem * rem);
            temp = temp / 10;
        }
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean findNumberInFile(String pathName, int n) {

        File file = new File(pathName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        while(sc.hasNextLine()){
            int num = sc.nextInt();
            if(n == num){
                return true;
            }
        }
        return false;
    }
}
