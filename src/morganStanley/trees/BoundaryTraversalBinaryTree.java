package morganStanley.trees;

public class BoundaryTraversalBinaryTree {

    public static void main(String[] args) {

        //tree
        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(3);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(-5);
        Tree.Node n6 = new Tree.Node(-6);
        Tree.Node n7 = new Tree.Node(7);
        Tree.Node n8 = new Tree.Node(8);
        Tree.Node n9 = new Tree.Node(9);


        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n4, n5, "left");
        Tree.constructBinaryTree(n5, n6, "left");
        Tree.constructBinaryTree(n3, n7, "right");
        Tree.constructBinaryTree(n7, n8, "right");
        Tree.constructBinaryTree(n8, n9, "right");

        boundaryTraversal(n1);
    }

    private static void boundaryTraversal(Tree.Node root) {

        System.out.print(root.data + " ");
        //print the left boundary - top-down
        printLeftBoundary(root.left);
        //print the leaf nodes - inorder traversal
        printLeaves(root.left);
        printLeaves(root.right);
        //print the right - bottom up
        printRightBoundary(root.right);
    }

    private static void printRightBoundary(Tree.Node root) {

        if(root == null)
            return;

        if(root.right != null){
            printRightBoundary(root.right);
            System.out.print(root.data + " ");
        }else if(root.left != null){
            printRightBoundary(root.left);
            System.out.print(root.data + " ");
        }
    }

    private static void printLeaves(Tree.Node root) {

        if(root == null)
            return;

        printLeaves(root.left);
        if (root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeaves(root.right);
    }

    private static void printLeftBoundary(Tree.Node root) {

        if(root == null)
            return;

        if(root.left != null){
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);
        }else if(root.right != null){
            System.out.print(root.data + " ");
            printLeftBoundary(root.right);
        }

    }
}
