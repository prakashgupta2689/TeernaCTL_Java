package misc.morganStanley.stacks;

import java.util.Stack;

public class NextGreaterElementToRight {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,2,4};
        int[] result = findNextGreaterElement(arr);

        //print the result
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    private static int[] findNextGreaterElement(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i  = arr.length-1; i>=0; i--){

            //if stack is empty-- return -1
            if(st.isEmpty())
                result[i] = -1;
            //if the top element is greater than the current element, add the top element to result
            else if(st.peek() > arr[i]){
                result[i] = st.peek();
            }
            //if the top element is less than the current element and the stack is not empty
            else if(!st.isEmpty() && st.peek() < arr[i]){

                while(!st.isEmpty() && st.peek() < arr[i]){
                    st.pop();
                }

                //you will exit the loop if either of the condition is false
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
