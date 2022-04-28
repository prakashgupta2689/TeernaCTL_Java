package misc.morganStanley.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreOrder {

    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] preorder = new int[]{3, 9, 20, 15, 7};

        Tree.Node root = buildUniqueTree(inorder, preorder);
        TreeTraversalsUsingRecursion.postOrder(root);

    }

    private static Tree.Node buildUniqueTree(int[] inorder, int[] preorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        Tree.Node root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }

    private static Tree.Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        Tree.Node root = new Tree.Node(preorder[preStart]);

        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);

        return root;
    }
}
