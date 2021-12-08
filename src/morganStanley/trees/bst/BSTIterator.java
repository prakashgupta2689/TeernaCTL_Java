package morganStanley.trees.bst;

import morganStanley.trees.Tree;

import java.util.Stack;

public class BSTIterator {

    static Stack<Tree.Node> st = new Stack<>();

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(8);
        Tree.Node n2 = new Tree.Node(6);
        Tree.Node n3 = new Tree.Node(12);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(7);
        Tree.Node n6 = new Tree.Node(13);
        Tree.Node n7 = new Tree.Node(10);

        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n2, n5, "right");
        Tree.constructBinaryTree(n3, n6, "right");
        Tree.constructBinaryTree(n3, n7, "left");

        //this will print the elements in ascending order
        constructBSTIterator(n1);
        while (hasNext()) {
            int nextNodeValue = next();
            System.out.println(nextNodeValue);
        }

        //this will print the element in descending order
        constructBSTIteratorBefore(n1);
        while (hasNext()) {
            int beforeNodeValue = before();
            System.out.println(beforeNodeValue);
        }


    }

    public static void constructBSTIteratorBefore(Tree.Node root) {
        pushAllBefore(root);
    }

    public static int before() {

        Tree.Node tempNode = st.pop();
        pushAllBefore(tempNode.left);
        return tempNode.data;
    }

    public static void pushAllBefore(Tree.Node root) {
        while (root != null){
            st.push(root);
            root = root.right;
        }
    }

    public static boolean hasNext() {
        return !st.isEmpty();
    }

    public  static int next() {
        Tree.Node tempNode = st.pop();
        pushAllNext(tempNode.right);
        return tempNode.data;
    }

    public static void constructBSTIterator(Tree.Node root) {
        pushAllNext(root);
    }

    private static void pushAllNext(Tree.Node root) {
        while (root != null){
            st.push(root);
            root = root.left;
        }
    }
}
