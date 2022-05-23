package morganStanley.trees;

public class LowestCommonAncestor {

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

        Tree.Node lowestCommonAncestor = findLowestCommonAncestor(n1, 4, 5);
        System.out.println("lowest common ancestor: "+lowestCommonAncestor.data);
    }

    private static Tree.Node findLowestCommonAncestor(Tree.Node node, int num1, int num2) {

        if(node == null || node.data== num1 || node.data == num2)
            return node;

        Tree.Node findLeft = findLowestCommonAncestor(node.left, num1, num2);

        Tree.Node findRight = findLowestCommonAncestor(node.right, num1, num2);

         if(findLeft == null){
             return findRight;
         } else if(findRight == null) {
             return findLeft;
         }else //both left and right are not null, we found our result
             return node;

    }
}
