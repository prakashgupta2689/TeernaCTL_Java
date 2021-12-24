package microsoft.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static microsoft.trees.Tree.constructBinaryTree;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(8);
        Tree.Node n2 = new Tree.Node(6);
        Tree.Node n3 = new Tree.Node(12);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(7);
        Tree.Node n6 = new Tree.Node(13);
        Tree.Node n7 = new Tree.Node(10);

        constructBinaryTree(n1,n2,"left");
        constructBinaryTree(n1,n3,"right");
        constructBinaryTree(n2,n4,"left");
        constructBinaryTree(n2, n5, "right");
        constructBinaryTree(n3, n6, "right");
        constructBinaryTree(n3, n7, "left");

        List<List<Integer>> res = zigZagLevelOrderTraversal(n1);
        System.out.println(res);
    }

    private static List<List<Integer>> zigZagLevelOrderTraversal(Tree.Node node) {

        Queue<Tree.Node> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean level = true;

        q.add(node);
        int sz = q.size();

        while(!q.isEmpty()){

            List<Integer> lres = new ArrayList<>(sz);
            int count = 0;

            //even -> left to right, odd -> right to left
            while(count < sz){

                //remove element from the queue
                Tree.Node temp = q.remove();
                //add element to the list
                //if level is even -> add element left to right else right to left
                if(level){
                    lres.add(temp.data);
                }else{
                    lres.add(0, temp.data);
                }

                //add the left and right children
                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
                count++;
            }
            sz = q.size();
            level = !level;
            res.add(lres);
        }
        return res;
    }
}
