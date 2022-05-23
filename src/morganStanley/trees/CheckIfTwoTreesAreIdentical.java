package morganStanley.trees;

public class CheckIfTwoTreesAreIdentical {

    public static void main(String[] args) {

        //tree1
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

        //tree2
        Tree.Node n12 = new Tree.Node(-10);
        Tree.Node n22 = new Tree.Node(2);
        Tree.Node n32 = new Tree.Node(3);
        Tree.Node n42 = new Tree.Node(4);
        Tree.Node n52 = new Tree.Node(-5);
        Tree.Node n62 = new Tree.Node(-6);
        Tree.Node n72 = new Tree.Node(7);
        Tree.Node n82 = new Tree.Node(8);
        Tree.Node n92 = new Tree.Node(9);


        Tree.constructBinaryTree(n12,n22,"left");
        Tree.constructBinaryTree(n12,n32,"right");
        Tree.constructBinaryTree(n32,n42,"left");
        Tree.constructBinaryTree(n42, n52, "left");
        Tree.constructBinaryTree(n52, n62, "left");
        Tree.constructBinaryTree(n32, n72, "right");
        Tree.constructBinaryTree(n72, n82, "right");
        Tree.constructBinaryTree(n82, n92, "right");

        boolean isIdentical = checkIfIdentical(n1, n12);
        System.out.println("isIdentical: "+isIdentical);

    }

    private static boolean checkIfIdentical(Tree.Node root1, Tree.Node root2) {

        if(root1 == null || root2 == null) {
            return (root1 == root2);
        }

        return (root1.data == root2.data) && (checkIfIdentical(root1.left, root2.left)) && (checkIfIdentical(root1.right, root2.right));

    }
}
