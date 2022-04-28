package misc.morganStanley.stacks;

import java.util.Stack;

public class MaximumAreaOfRectangleInABinaryMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        int maxArea = findMaximumAreaOfRectangleInABinaryMatrix(arr);
        System.out.println("maxArea: "+ maxArea);
    }

    private static int findMaximumAreaOfRectangleInABinaryMatrix(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;
        int maxArea = 0;

        //convert the 2D array into 1D arrays
        int[] v = new int[cols];

        for(int i = 0; i < cols; i++){
            v[i] = arr[0][i];
        }
        maxArea = maxAreaHistogram(v);
        //call Maximum histogram for each of the 1D arrays

        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(arr[i][j] == 0){
                    v[j] = 0;
                }else{
                    v[j] = v[j] + arr[i][j];
                }
            }
            maxArea = Math.max(maxArea, maxAreaHistogram(v));
        }
        return maxArea;
    }

    private static int maxAreaHistogram(int[] v) {

        //find the NSL array
        int[] leftWidth = findNSL(v);
        //find the NSR array
        int[] rightWidth = findNSR(v);
        //find the width array-- NSR[i] - NSL[i] - 1
        int[] width = new int[v.length];
        for(int i = 0; i < width.length; i++){
            width[i] = rightWidth[i] - leftWidth[i] - 1;
        }
        //find the area array -- v[i] * width[i]
        int[] area = new int[v.length];
        for(int i = 0; i < area.length; i++){
            area[i] = v[i] * width[i];
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

    private static int[] findNSR(int[] v) {

        //this array will store the index of the NSR for each element of v-- similar to the MAH problem
        int[] result = new int[v.length];

        //this stack will store the index of the NSR
        Stack<Integer> st = new Stack<>();

        for (int i = v.length-1; i >= 0; i--){

            if(st.isEmpty())
                result[i] = v.length;
            else if(v[st.peek()] < v[i]){
                result[i] = st.peek();
            }else if(!st.isEmpty() && v[st.peek()] >= v[i]){

                while(!st.isEmpty() && v[st.peek()] >= v[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    result[i] = v.length;
                }else{
                    result[i] = st.peek();
                }
            }
            st.push(i);
        }
        return result;
    }

    private static int[] findNSL(int[] v) {

        //this array will store the index of the NSL for each element of v-- similar to the MAH problem
        int[] result = new int[v.length];

        //this stack will store the index of the NSL
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < v.length; i++){

            if(st.isEmpty())
                result[i] = -1;
            else if(v[st.peek()] < v[i])
                result[i] = st.peek();
            else if(!st.isEmpty() && v[st.peek()] >= v[i]){

                while(!st.isEmpty() && v[st.peek()] >= v[i]){
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
