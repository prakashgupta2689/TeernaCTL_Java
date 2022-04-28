package misc.morganStanley.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(3);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(5);
        Tree.Node n6 = new Tree.Node(6);
        Tree.Node n7 = new Tree.Node(7);

        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n2, n5, "right");
        Tree.constructBinaryTree(n3, n6, "right");
        Tree.constructBinaryTree(n3, n7, "left");

        findMaximumWidthOfBinaryTree(n1);
    }

    //level order traverse and store the nodes at each level in a queue. The maximum size of the queue is the result
    private static void findMaximumWidthOfBinaryTree(Tree.Node root) {

        Queue<Tree.Node> queue = new ArrayDeque<>();
        queue.add(root);
        int maxWidth = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);

            while(size-- > 0){

                Tree.Node node = queue.remove();

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        System.out.println("maxWidth: " + maxWidth);
    }
}
