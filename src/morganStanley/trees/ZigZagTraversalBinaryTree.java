package morganStanley.trees;

import java.util.Stack;

public class ZigZagTraversalBinaryTree {

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
        Tree.constructBinaryTree(n3,n4,"left");
        Tree.constructBinaryTree(n4, n5, "left");
        Tree.constructBinaryTree(n5, n6, "left");
        Tree.constructBinaryTree(n3, n7, "right");
        Tree.constructBinaryTree(n7, n8, "right");
        Tree.constructBinaryTree(n8, n9, "right");

        printZigZag(n1);
    }

    private static void printZigZag(Tree.Node root) {

        if(root == null)
            return;

        Stack<Tree.Node> currentLevel = new Stack<>();
        Stack<Tree.Node> nextLevel = new Stack<>();
        boolean leftToRight = true;

        currentLevel.push(root);
        while(!currentLevel.isEmpty()){

            Tree.Node node = currentLevel.pop();
            System.out.print(node.data + " ");

            //push the children of node into the next stack
            if(leftToRight){
                if(node.left != null)
                    nextLevel.push(node.left);
                if(node.right != null)
                    nextLevel.push(node.right);
            }else{
                if(node.right != null)
                    nextLevel.push(node.right);
                if(node.left != null)
                    nextLevel.push(node.left);
            }

            if(currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Tree.Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                System.out.println(" ");
            }
        }
    }
}
