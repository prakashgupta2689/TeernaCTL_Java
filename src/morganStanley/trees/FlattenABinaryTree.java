package morganStanley.trees;

public class FlattenABinaryTree {

    static Tree.Node prev = null;

    public static void main(String[] args) {

        Tree.Node n1 = new Tree.Node(-10);
        Tree.Node n2 = new Tree.Node(2);
        Tree.Node n3 = new Tree.Node(3);
        Tree.Node n4 = new Tree.Node(4);
        Tree.Node n5 = new Tree.Node(5);
        Tree.Node n6 = new Tree.Node(6);
        Tree.Node n7 = new Tree.Node(7);

        Tree.constructBinaryTree(n1,n2,"left");
        Tree.constructBinaryTree(n1,n3,"right");
        Tree.constructBinaryTree(n2,n4,"left");
        Tree.constructBinaryTree(n2, n5, "right");
        Tree.constructBinaryTree(n3, n6, "right");
        Tree.constructBinaryTree(n3, n7, "left");

        //method 1
        //convert the binary tree to preorder and then create a new tree with that keeping the left null

        //method 2 - time = O(N), space = O(N)
        flatten(n1);
        TreeTraversalsUsingRecursion.levelOrder(n1);

        //method 3 - time = O(N), space = O(1)
        flattenWithNoExtraSpace(n1);
        TreeTraversalsUsingRecursion.levelOrder(n1);

    }

    private static void flattenWithNoExtraSpace(Tree.Node node) {

        Tree.Node current = node;
        while (current != null){

            if(current.left != null){

                Tree.Node previous = current.left;
                while (previous.right != null){
                    previous = previous.right;
                }

                previous.right = current.right;
                current.right = current.left;
            }
            current = current.right;
        }
    }

    private static void flatten(Tree.Node node) {

        if(node == null)
            return;

        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
