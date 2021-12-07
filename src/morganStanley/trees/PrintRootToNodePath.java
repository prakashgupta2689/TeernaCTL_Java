package morganStanley.trees;

import java.util.Stack;

public class PrintRootToNodePath {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(3);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(5);
        Tree.Node n6 = new Tree.Node(6);
        Tree.Node n7 = new Tree.Node(7);

        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n2, n5, "right");
        Tree.constructBinaryTree(n3, n6, "right");
        Tree.constructBinaryTree(n3, n7, "left");

        int target = 7;
        Stack<Integer> st = new Stack<>();
        printRootToNodePath(n1, st, target);

        //print the elements from root to node path
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }

    }

    private static boolean printRootToNodePath(Tree.Node node, Stack<Integer> st, int target) {

        if(node == null)
            return false;

        st.push(node.data);

        if(node.data == target) {
            return true;
        }
        //left
        boolean ifTargetInLeft = printRootToNodePath(node.left, st, target);
        //right
        boolean ifTargetInRight = printRootToNodePath(node.right, st, target);

        if(ifTargetInLeft || ifTargetInRight)
            return true;

        st.pop();
        return false;
    }
}
