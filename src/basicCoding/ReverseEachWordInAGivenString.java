package basicCoding;

import java.util.Stack;

/**
 * Input: java code
 * Output: avaj edoc
 * 1. Generate all words separated by space. One by one reverse words and print them separated by space
 * 2. We use a stack to push all words before space. As soon as we encounter a space, we empty the stack
 * */
public class ReverseEachWordInAGivenString {

    public static void main(String[] args) {

        String str = "java code to reverse each word in a string";

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) != ' ') {
                stack.push(str.charAt(i));
            }else{

                //empty the stack
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }
}
