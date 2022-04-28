package misc.microsoft.string_arrays;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String s = "]";

        boolean isValid = checkValid(s);
        System.out.println("isValid: "+ isValid);
    }

    private static boolean checkValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            if(st.isEmpty() && (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')'))
                return false;

            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(ch == ')' || ch == '}' || ch == ']'  && !st.isEmpty()){

                char top = st.peek();
                if(top == '(' && ch == ')'){
                    st.pop();
                }else if(top == '{' && ch == '}'){
                    st.pop();
                }else if(top == '[' && ch == ']'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
