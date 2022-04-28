package misc.morganStanley.trees.bst;

import misc.morganStanley.trees.Tree;
import misc.morganStanley.trees.TreeTraversalsUsingRecursion;

public class ConstructBSTFromPreorder {

    public static void main(String[] args) {

        int[] preorder = new int[]{8, 5, 1, 7, 10, 12,11};
        int upperBound = Integer.MAX_VALUE;
        int[] index = new int[1];


        Tree.Node node = constructBSTFromPreorder(preorder, upperBound, index);
        TreeTraversalsUsingRecursion.levelOrder(node);
    }

    public static Tree.Node constructBSTFromPreorder(int[] preorder, int upperBound, int[] index) {

        if(index[0] == preorder.length || preorder[index[0]] > upperBound)
            return null;

        Tree.Node root = new Tree.Node(preorder[index[0]++]);
        root.left = constructBSTFromPreorder(preorder, root.data, index);
        root.right = constructBSTFromPreorder(preorder, upperBound, index);

        return root;
    }
}
