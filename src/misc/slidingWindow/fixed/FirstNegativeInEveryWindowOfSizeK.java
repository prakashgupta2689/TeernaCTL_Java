package misc.slidingWindow.fixed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {

    public static void main(String[] args) {

        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        List<Integer> res = findFirstNegativeNumber(arr, k);
        System.out.println(res);
    }

    private static List<Integer> findFirstNegativeNumber(int[] arr, int k) {

        int start = 0;
        int end = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        while(end < arr.length){

            if(arr[end] < 0)
                //store the index in the queue
                queue.add(end);

            if(end - start + 1 == k){

                if(!queue.isEmpty()) {
                    list.add(arr[queue.peek()]);
                }else{
                    list.add(0);
                }
                end++;
                start++;

            }else if(end - start + 1 < k){

                end++;
            }
            //remove the elements from the queue which are not in the window
            while(!queue.isEmpty() && queue.peek() < start){
                queue.remove();
            }

        }
        return list;
    }
}
