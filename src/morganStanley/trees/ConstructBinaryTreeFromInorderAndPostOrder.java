package morganStanley.trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostOrder {

    public static void main(String[] args) {

        int[] inorder = new int[]{40, 20, 50, 10, 60, 30};
        int[] postorder = new int[]{40, 50, 20, 60, 30, 10};

        Tree.Node root = buildUniqueTree(inorder, postorder);
        TreeTraversalsUsingRecursion.postOrder(root);
    }

    private static Tree.Node buildUniqueTree(int[] inorder, int[] postorder) {

        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        Tree.Node root = buildTreeWithInPost(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        return  root;
    }

    private static Tree.Node buildTreeWithInPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inMap) {

        if(postEnd < postStart || inEnd < inStart)
            return null;

        Tree.Node root = new Tree.Node(postorder[postEnd]);

        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeWithInPost(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, inMap);

        root.right = buildTreeWithInPost(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);

        return root;
    }
}
