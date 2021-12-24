package microsoft.trees;

import static microsoft.trees.Tree.constructBinaryTree;

public class ValidateBST {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(8);
        Tree.Node n2 = new Tree.Node(6);
        Tree.Node n3 = new Tree.Node(12);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(7);
        Tree.Node n6 = new Tree.Node(13);
        Tree.Node n7 = new Tree.Node(14);

        constructBinaryTree(n1,n2,"left");
        constructBinaryTree(n1,n3,"right");
        constructBinaryTree(n2,n4,"left");
        constructBinaryTree(n2, n5, "right");
        constructBinaryTree(n3, n6, "right");
        constructBinaryTree(n3, n7, "left");

        boolean isValid = checkValidBST(n1, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println("isValid: " + isValid);
    }

    private static boolean checkValidBST(Tree.Node node, int maxValue, int minValue) {

        if(node == null)
            return true;

        if(node.data <= maxValue && node.data >= minValue){

            //left subtree
            boolean left = checkValidBST(node.left, node.data, minValue);
            //right subtree
            boolean right = checkValidBST(node.right, maxValue, node.data);

            return (left && right);
        }
        return false;
    }
}
