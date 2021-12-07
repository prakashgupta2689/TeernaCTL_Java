package morganStanley.trees.bst;

import morganStanley.trees.Tree;
import morganStanley.trees.TreeTraversalsUsingRecursion;

public class InsertNode {

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

        int key = 11;

        insertKey(n1, key);
        TreeTraversalsUsingRecursion.levelOrder(n1);
    }

    private static Tree.Node insertKey(Tree.Node root, int key) {

        Tree.Node curr = root;
        if(curr == null)
            return new Tree.Node(key);

        while(true) {
            if (key > curr.data) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new Tree.Node(key);
                    break;
                }
            }else{
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new Tree.Node(key);
                    break;
                }
            }
        }
        return root;
    }
}
