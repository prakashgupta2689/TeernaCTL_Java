package morganStanley.trees.bst;

import morganStanley.trees.Tree;
import morganStanley.trees.TreeTraversalsUsingRecursion;

public class RecoverBSTBySwappingTwoNodes {

    static Tree.Node first;
    static Tree.Node prev;
    static Tree.Node middle;
    static Tree.Node last;

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(8);
        Tree.Node n2 = new Tree.Node(6);
        Tree.Node n3 = new Tree.Node(14);
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

        System.out.println("before recovery");
        TreeTraversalsUsingRecursion.levelOrder(n1);
        recoverBST(n1);
        System.out.println("after recovery");
        TreeTraversalsUsingRecursion.levelOrder(n1);
    }

    public static void recoverBST(Tree.Node root) {

        first = last = middle = null;
        prev = new Tree.Node(Integer.MIN_VALUE);

        inorder(root);
        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    public static void inorder(Tree.Node root) {

        if(root == null)
            return;

        inorder(root.left);

        if(prev != null && prev.data > root.data){

            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}
