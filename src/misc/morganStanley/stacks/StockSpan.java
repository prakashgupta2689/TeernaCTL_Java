package misc.morganStanley.stacks;

import java.util.Stack;

//consecutive numbers smaller than or equal to itself
public class StockSpan {

    public static void main(String[] args) {

        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};

        int[] result = findStockSpan(arr);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    private static int[] findStockSpan(int[] arr) {

        int[] result = new int[arr.length];
        //this stack will contain the index of the element - a difference from the NGL problem where we store the element
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++){

            if(st.isEmpty()) {
                result[i] = 1;
            }
            else if(arr[st.peek()] > arr[i]){
                result[i] = i - st.peek();
            }
            else if(!st.isEmpty() && arr[st.peek()] <= arr[i]){

                while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    result[i] = 1;
                }else{
                    result[i] = i - st.peek();
                }
            }
            st.push(i);
        }
        return result;
    }
}

