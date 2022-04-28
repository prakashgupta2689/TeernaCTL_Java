package misc.morganStanley.trees.bst;

import misc.morganStanley.trees.Tree;

public class InorderSuccessor {

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

        int target = 10;

        Tree.Node successor = null;
        Tree.Node result = findInorderSuccessor(n1, target, successor);
        System.out.println(result.data);

        //iterative
        Tree.Node successorIterative = findSuccessor(n1, target);
        System.out.println(successorIterative.data);
    }

    private static Tree.Node findSuccessor(Tree.Node root, int target) {

        Tree.Node successor = null;

        while(root != null){

            if(root.data > target){
                successor = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return successor;
    }

    private static Tree.Node findInorderSuccessor(Tree.Node root, int target, Tree.Node successor) {

        if(root == null)
            return successor;

        if(root.data > target){
            successor = root;
            return findInorderSuccessor(root.left, target, successor);
        }
        return findInorderSuccessor(root.right, target, successor);
    }
}
