package morganStanley.stacks;

import java.util.Stack;

public class NearestSmallerToRight {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 2, 10, 8};

        int[] result = findNearestSmallerToRight(arr);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    private static int[] findNearestSmallerToRight(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){

            if(st.isEmpty())
                result[i] = -1;
            else if(st.peek() < arr[i])
                result[i] = st.peek();
            else if(!st.isEmpty() && st.peek() >= arr[i]){

                while(!st.isEmpty() && st.peek() >= arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = st.peek();
                }
            }
            st.push(arr[i]);
        }
        return result;
    }
}
