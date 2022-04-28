package misc.morganStanley.trees;

public class BinaryTreeOpns {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(3);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(-5);
        Tree.Node n6 = new Tree.Node(-6);
        Tree.Node n7 = new Tree.Node(7);
        Tree.Node n8 = new Tree.Node(8);
        Tree.Node n9 = new Tree.Node(9);


        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n3,n4,"left");
        Tree.constructBinaryTree(n4, n5, "left");
        Tree.constructBinaryTree(n5, n6, "left");
        Tree.constructBinaryTree(n3, n7, "right");
        Tree.constructBinaryTree(n7, n8, "right");
        Tree.constructBinaryTree(n8, n9, "right");

        int maxDepth = findMaxDepth(n1);
        System.out.println("Maximum depth of Binary Tree: "+ maxDepth);

        //will print the maxDepth of the tree if tree is balanced else if the tree is not balanced, it will
        //print -1
        int isBalancedBinaryTree = checkBalancedBinaryTree(n1);
        System.out.println("isBalanced: "+isBalancedBinaryTree);

        //check the maximum diameter of a binary tree
        int[] maxDia = new int[1];
        findMaxDiameter(maxDia, n1);
        System.out.println("Maximum Diameter: "+ maxDia[0]);

        //find the maximum path sum
        int[] maxPathSum = new int[1];
        findMaxPathSum(maxPathSum, n1);
        System.out.println("maximum path sum: "+ maxPathSum[0]);

    }

    //dry run it once
    private static int findMaxPathSum(int[] maxPathSum, Tree.Node root) {

        if(root == null)
            return 0;

        int leftMaxPathSum = Math.max(0, findMaxPathSum(maxPathSum,root.left));
        int rightMaxPathSum = Math.max(0, findMaxPathSum(maxPathSum, root.right));

        maxPathSum[0] = Math.max(maxPathSum[0], leftMaxPathSum+rightMaxPathSum+ root.data);

        return root.data + Math.max(leftMaxPathSum, rightMaxPathSum);
    }

    private static int findMaxDiameter(int[] maxDia, Tree.Node root) {

        if(root == null)
            return 0;

        int leftHeight = findMaxDiameter(maxDia,root.left);
        int rightHeight = findMaxDiameter(maxDia, root.right);

        maxDia[0] = Math.max(maxDia[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static int checkBalancedBinaryTree(Tree.Node root) {

        if(root == null)
            return 0;

        int checkLeft = checkBalancedBinaryTree(root.left);
        int checkRight = checkBalancedBinaryTree(root.right);

        if(Math.abs(checkLeft - checkRight) > 1)
            return -1;

        return Math.max(checkLeft,checkRight) + 1;
    }

    private static int findMaxDepth(Tree.Node root) {

        if(root == null)
            return 0;

        int leftDepth = findMaxDepth(root.left);
        int rightDepth = findMaxDepth(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }
}
