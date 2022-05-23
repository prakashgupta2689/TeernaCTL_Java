package morganStanley.stacks;

import java.util.Stack;

public class MaximumAreaOfHistogram {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 2, 5, 4, 5, 1, 6};

        int maxArea = findMaximumAreaOfHistogram(arr);
        System.out.println("maxArea: "+ maxArea);
    }

    public static int findMaximumAreaOfHistogram(int[] arr) {

        //find the NSL - return left
        int[] leftWidth = findLeftWidth(arr);
        //find the NSR - return right
        int[] rightWidth = findRightWidth(arr);
        //get the width array - right - left - 1
        int[] width = new int[arr.length];
        for(int i = 0; i < width.length; i++){
            width[i] = rightWidth[i] - leftWidth[i] -1;
        }
        //compute the area array
        int[] area = new int[arr.length];
        for(int i = 0; i < area.length; i++){
            area[i] = arr[i] * width[i];
        }
        //find the maximum element in the area array
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < area.length; i++){
            if(max < area[i]){
                max = area[i];
            }
        }
        return max;
    }

    private static int[] findRightWidth(int[] arr) {

        //the result array stores the index of the next smaller element to the current element
        int[] result = new int[arr.length];
        //this stack stores the index of the next smaller element -- like the stock span problem
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){

            if(st.isEmpty())
                result[i] = arr.length;
            else if(arr[st.peek()] < arr[i])
                result[i] = st.peek();
            else if(!st.isEmpty() && arr[st.peek()] >= arr[i]){

                while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    result[i] = arr.length;
                }else{
                    result[i] = st.peek();
                }
            }
            st.push(i);
        }
        return result;
    }

    private static int[] findLeftWidth(int[] arr) {

        //the result array stores the index of the element which is next smaller to the current element
        int[] result = new int[arr.length];
        //this stack stores the index of the next smaller element - like the stock span problem
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++){

            if(st.isEmpty())
                result[i] = -1;
            else if(arr[st.peek()] < arr[i])
                result[i] = st.peek();
            else if(!st.isEmpty() && arr[st.peek()] >= arr[i]){

                while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = st.peek();
                }
            }
            st.push(i);
        }
        return result;
    }
}
