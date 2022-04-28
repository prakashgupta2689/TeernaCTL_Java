package misc.morganStanley.trees;

public class ChildrenSumPropertyOfBinaryTree {

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

        childrenSumProperty(n1);
    }

    private static void childrenSumProperty(Tree.Node node) {

        //before going down
        if(node == null)
            return;

        int childValue = 0;
        if(node.left != null){
            childValue+= node.left.data;
        }
        if(node.right != null){
            childValue+= node.right.data;
        }

        if(childValue >= node.data){
            node.data = childValue;
        }else{
            if(node.left != null)
                node.left.data = node.data;
            if(node.right != null)
                node.right.data = node.data;
        }

        //recursive calls - going down
        childrenSumProperty(node.left);
        childrenSumProperty(node.right);

        //while returning or while coming up

        int tot = 0;
        if(node.left != null){ //store the value of left child node in tot
            tot+= node.left.data;
        }
        if(node.right != null) { //store the value of the right child node in tot
            tot += node.right.data;
        }
        if(node.left != null || node.right != null) //i.e. if not a leaf node -> store the value of tot in node
            node.data = tot;
    }
}
