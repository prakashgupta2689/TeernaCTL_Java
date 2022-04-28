package misc.microsoft.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static misc.microsoft.trees.Tree.constructBinaryTree;

public class InorderTraversal {

    static List<Integer> list = new ArrayList<>();

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

        //left - root - right
        List<Integer> res = inorderTraversalRecursive(n1);
        System.out.println("recursive inorder: "+ res);

        List<Integer> result = inorderTraversalIterative(n1);
        System.out.println("iterative inorder: "+ result);
    }

    private static List<Integer> inorderTraversalIterative(Tree.Node node) {

        Stack<Tree.Node> st = new Stack<>();
        List<Integer> result = new ArrayList<>();

        Tree.Node temp = node;

        while(true){

            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }else{
                if(st.isEmpty())
                    break;

                temp = st.pop();
                result.add(temp.data);
                temp = temp.right;
            }
        }
        return result;
    }

    private static List<Integer> inorderTraversalRecursive(Tree.Node node) {

        if(node == null)
            return list;

        inorderTraversalRecursive(node.left);
        list.add(node.data);
        inorderTraversalRecursive(node.right);

        return list;
    }

}
