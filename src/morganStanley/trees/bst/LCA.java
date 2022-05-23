package morganStanley.trees.bst;

import morganStanley.trees.Tree;

public class LCA {

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

        int num1 = 8;
        int num2 = 7;
        Tree.Node node = findLongestCommonAncestor(n1, num1, num2);
        System.out.println(node.data);
    }

    private static Tree.Node findLongestCommonAncestor(Tree.Node root, int num1, int num2) {

        if(root.data > num1 && root.data > num2){
            return findLongestCommonAncestor(root.left, num1, num2);
        }

        if(root.data < num1 && root.data < num2){
            return findLongestCommonAncestor(root.right, num1, num2);
        }

        return root;
    }
}
