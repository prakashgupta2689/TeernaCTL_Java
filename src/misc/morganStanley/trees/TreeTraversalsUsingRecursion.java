package misc.morganStanley.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTraversalsUsingRecursion {

    public static void main(String[] args) {

        int[] arr = new int[]{ 1, 2, 4, 3, 5, 6, 7, 9, 8};
        Tree tree = new Tree();
        tree.root = Tree.insertLevelOrder(arr, tree.root,0);

        System.out.println("preorder");
        preOrder(tree.root);
        System.out.println("postorder");
        postOrder(tree.root);
        System.out.println("inorder");
        inOrder(tree.root);
        System.out.println("level order");
        levelOrder(tree.root);

    }

    public static void inOrder(Tree.Node root) {

        if(root != null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public static void postOrder(Tree.Node root) {

        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public static void preOrder(Tree.Node root) {

        if(root != null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void levelOrder(Tree.Node root){

        Queue<Tree.Node> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0) {
            Tree.Node node = q.remove();
            System.out.println(node.data + " ");

            if (node.left != null) {
                q.add(node.left);
            }

            if(node.right != null){
                q.add(node.right);
            }
        }
    }
}
