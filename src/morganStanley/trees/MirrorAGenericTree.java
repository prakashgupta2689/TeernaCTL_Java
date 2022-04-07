package morganStanley.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MirrorAGenericTree {
/**
 * We go through 3 steps of High Level Thinking.
 *
 * Set Expectation : We expect that if we input a generic tree, then the output should be its mirror tree as shown in figure 1 .
 *
 * Build Faith : We must have faith that if our code can give us an output for the entire generic tree, then it can definitely give as an output its subtree.Those subtrees of that generic tree are considered where each root of that sub tree is a child of the root of the original generic tree.
 * As shown in figure 2, we have faith that we can make mirror trees for the 3 highlighted sub trees with roots 20, 30 and 40.
 * imgThe output of those sub trees is seen in Figure 2(misc.B).
 * You just need to believe. Don't focus on "HOW" that will happen.
 *
 * Expectation meets Faith : We see that figure 2 is not yet complete. The final output tree must look like Figure 1(misc.B).
 * For that, we need to change the positions of the children of the root node in Figure 2(misc.B).
 * The families of these sub trees should get reversed for getting the desired output.
 * We had already mirrored 20, 30 and 40. By reversing their families, the family of 10 will get mirrored too.
 * https://www.pepcoding.com/resources/online-java-foundation/generic-tree/mirror_of_generic_tree/topic
 * */
    private static class Node {
        int data;
        ArrayList< Node> children = new ArrayList< >();
}
    public static void main(String[] args) {

        int[] arr = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        display(root);
        mirror(root);
        System.out.println("-----------------Mirrored-------------------");
        display(root);

    }

    private static void mirror(Node root) {

        for(Node child: root.children){
            mirror(child);
        }

        Collections.reverse(root.children);
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }
}
