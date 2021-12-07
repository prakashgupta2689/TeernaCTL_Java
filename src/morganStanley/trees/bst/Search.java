package morganStanley.trees.bst;

import morganStanley.trees.Tree;

public class Search {

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

        int target = 6;
        boolean result = searchNode(target, n1);
        System.out.println(result);
    }

    public static boolean searchNode(int target, Tree.Node root) {

        if(root == null)
            return false;

        if(root.data == target)
            return true;

        return (target > root.data ? searchNode(target, root.right) : searchNode(target, root.left));
    }
}
