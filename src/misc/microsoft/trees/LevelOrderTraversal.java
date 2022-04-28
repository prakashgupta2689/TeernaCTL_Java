package misc.microsoft.trees;

import java.util.*;

import static misc.microsoft.trees.Tree.constructBinaryTree;

public class LevelOrderTraversal {

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

        List<List<Integer>> res = levelOrderTraversal(n1);
        System.out.println(res);

    }

    private static List<List<Integer>> levelOrderTraversal(Tree.Node node) {

        Queue<Tree.Node> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(node);
        int sz = q.size();

        while(!q.isEmpty()){

            int level = 0;

            //add to the level arraylist
            List<Integer> lres = new ArrayList<>();

            while(level < sz){

                Tree.Node temp = q.remove();
                lres.add(temp.data);

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }

                level++;
            }
            sz = q.size();
            res.add(lres);
        }
        return res;
    }
}
