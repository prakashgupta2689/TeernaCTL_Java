package morganStanley.trees;

public class CheckIfABinaryTreeIsSymmetrical {

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(2);
        Tree.Node n4 = new Tree.Node(3);
        Tree.Node n5 = new Tree.Node(-4);
        Tree.Node n6 = new Tree.Node(3);
        Tree.Node n7 = new Tree.Node(-4);

        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n2, n5, "right");
        Tree.constructBinaryTree(n3, n6, "right");
        Tree.constructBinaryTree(n3, n7, "left");

        boolean isSymmetrical = checkSymmetrical(n1.left, n1.right);
        System.out.println("isSymmetrical: "+ isSymmetrical);
    }

    private static boolean checkSymmetrical(Tree.Node leftNode, Tree.Node rightNode) {

        if(leftNode == null || rightNode == null)
            return (leftNode == rightNode);

        boolean isLeftSymmetrical = checkSymmetrical(leftNode.left, rightNode.right);
        boolean isRightSymmetrical = checkSymmetrical(leftNode.right, rightNode.left);

        return (leftNode.data == rightNode.data) && isLeftSymmetrical && isRightSymmetrical;

    }
}
