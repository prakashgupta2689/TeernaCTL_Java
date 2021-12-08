import java.io.*;
import java.util.*;

public class FATExam {

    public static void main(String[] args) {

        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: ");
        n=sc.nextInt();
        int[] Input_array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++)
        {
            Input_array[i]=sc.nextInt();
        }

        int[] Unique_array = removeDuplicates(Input_array);

        //print unique_array
        for(int i = 0; i < Unique_array.length; i++){
            System.out.print(Unique_array[i] + " ");
        }

        String pathName = "C:\\Users\\teern\\Documents\\GCP\\numbers.txt";
        String outputPathName = "C:\\Users\\teern\\Documents\\GCP\\Number_count.txt";
        checkOccurancesInFile(pathName, outputPathName, Unique_array);
    }

    public static void checkOccurancesInFile(String pathName, String outputPathName, int[] unique_array) {

        File file = new File("C:\\Users\\teern\\Documents\\GCP\\numbers.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> nums = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        while (sc.hasNextLine()) {
            nums.add(sc.nextInt());
        }

        //putting the contents of Unique_array in a map
        for(Integer num: unique_array){
            hm.put(num, 0);
        }

        //increase the freq of the num if the nums contains the element in the unique_array
        for(Integer num: nums){
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num)+1);
            }
        }

//        //print the map
//        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        addCountOfElementsInNumberCountFile(hm, outputPathName);
    }

    public static void addCountOfElementsInNumberCountFile(HashMap<Integer, Integer> hm, String outputPathName) {
        File file = new File(outputPathName);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {

            for (Map.Entry<Integer, Integer> entry :
                    hm.entrySet()) {

                bf.write(entry.getKey() + ":"
                        + entry.getValue());
                bf.newLine();
            }

            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] removeDuplicates(int[] input_array) {

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < input_array.length; i++){
            hs.add(input_array[i]);
        }

        int[] a = new int[hs.size()];
        int i = 0;
        for (Integer val : hs)
            a[i++] = val;
        return a;
    }
}
