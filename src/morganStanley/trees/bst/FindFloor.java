package morganStanley.trees.bst;

import morganStanley.trees.Tree;

public class FindFloor {

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

        int target = 11;
        int[] floor = new int[1];
        floor[0] = -1;
        Tree.Node node = findCeil(n1, target, floor);
        System.out.println(floor[0]);


    }

    private static Tree.Node findCeil(Tree.Node root, int target, int[] floor) {

        if(root == null)
            return null;

        if(target == root.data){
            floor[0] = root.data;
            return root;
        }

        if(target < root.data){
            return findCeil(root.left, target, floor);
        }else {
            floor[0] = root.data;
            return findCeil(root.right, target, floor);
        }
    }
}
