package misc.microsoft.trees;

import static misc.microsoft.trees.Tree.constructBinaryTree;

public class LowestCommonAncestor {

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

        Tree.Node res = lowestCommonAncestor(n1, n6, n7);
        System.out.println(res.data);
    }

    private static Tree.Node lowestCommonAncestor(Tree.Node root, Tree.Node p, Tree.Node q) {

        if(root == null)
            return null;

        if(root == p || root == q)
            return root;

        Tree.Node left = lowestCommonAncestor(root.left, p, q);
        Tree.Node right = lowestCommonAncestor(root.right, p, q);

        if(left == null || right == null){
            if(left == null)
                return right;
            else
                return left;
        }
        return root;
    }
}
