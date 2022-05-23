package morganStanley.trees.bst;

import morganStanley.trees.Tree;

public class CheckValidBst {

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

       int min  = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        boolean isValidBST = checkValidBST(n1, min, max);
        System.out.println(isValidBST);
    }

    public static boolean checkValidBST(Tree.Node root, int min, int max) {

        boolean left;
        boolean right;

        if(root == null){
            return true;
        }

        if(min < root.data && max > root.data){

            left = checkValidBST(root.left, min, root.data);

            right = checkValidBST(root.right, root.data, max);
        }else{
            return false;
        }

        return left && right;
    }
}
