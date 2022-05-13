package misc.binarySearch;

import java.util.*;

public class FirstAndLastOccuranceOfElement {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 10, 10, 10, 18, 20};
        int element = 10;

        Queue<Integer> firstOccurrence = findFirstOccurrence(arr, element);
        System.out.println(firstOccurrence.peek());

        Queue<Integer> lastOccurrence = findLastOccurrence(arr, element);
        System.out.println(lastOccurrence.peek());
    }

    private static Queue<Integer> findLastOccurrence(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        while(start <= end){

            int mid = start + (end - start)/2;

            if(element == arr[mid]){
                queue.add(mid);
                start = mid + 1;
            }else if(element < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return queue;
    }

    private static Queue<Integer> findFirstOccurrence(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;
        Queue<Integer> queue = new PriorityQueue<>();

        while(start <= end){

            int mid = start + (end - start)/2;

            if(element == arr[mid]){
                queue.add(mid);
                end = mid - 1;
            }else if(element < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return queue;
    }
}
