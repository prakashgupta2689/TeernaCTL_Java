package misc;

import java.io.*;

public class FileOperationWithoutScanner {

    public static void main(String[] args) throws FileNotFoundException {

        int count = 0;

        File file = new File(
                "misc.C:\\Users\\teern\\Documents\\GCP\\numbers.txt");

        BufferedReader br
                = new BufferedReader(new FileReader(file));


        String st = null;
        while (true)
        {
            try {
                if ((st = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(st != null) {
                int num = Integer.parseInt(st);
                if(checkPalindrome(num)){
                    System.out.println(num);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean checkPalindrome(int num) {
        int rem,sum=0,temp;

        temp=num;
        while(num>0){
            rem=num%10;
            sum=(sum*10)+rem;
            num=num/10;
        }
        return temp == sum;
    }
}
