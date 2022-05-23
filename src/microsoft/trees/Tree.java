package microsoft.trees;

public class Tree {

    Node root;

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {

        Tree t2 = new Tree();
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        t2.root = insertLevelOrder(arr, t2.root, 0);
    }

    public static Node insertLevelOrder(int[] arr, Node root, int i) {

        if(i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void constructBinaryTree(Node parent, Node child, String orientation){

        if(orientation.equals("left")){
            parent.left = child;
        }else if(orientation.equals("right")){
            parent.right = child;
        }
    }
}
