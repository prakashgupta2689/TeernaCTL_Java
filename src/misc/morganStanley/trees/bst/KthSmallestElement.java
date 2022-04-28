package misc.morganStanley.trees.bst;

import misc.morganStanley.trees.Tree;

public class KthSmallestElement {

    static int count = 0;

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

        int k = 2;
        Tree.Node kthSmallestElement = findKthSmallestElement(n1, k);
        System.out.println(kthSmallestElement.data);

    }

    public static Tree.Node findKthSmallestElement(Tree.Node root, int k) {

        if(root == null)
            return null;

        Tree.Node left = findKthSmallestElement(root.left, k);

        if(left != null)
            return left;

        count++;
        if(count == k) {
            return root;
        }

        return findKthSmallestElement(root.right, k);
    }
}
