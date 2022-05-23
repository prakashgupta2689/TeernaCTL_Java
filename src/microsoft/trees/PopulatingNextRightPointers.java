package microsoft.trees;

//this is for a perfect binary tree
//do it with queue
public class PopulatingNextRightPointers {

    public static class Node {
         int val;
         Node left;
         Node right;
         Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        populateNextRightPointers(n1);
    }

    private static void populateNextRightPointers(Node node) {

        Node temp = node;
        while(temp != null && temp.left != null) {

            Node n = temp;

            while (true) {

                n.left.next = n.right;
                if(n.next == null)
                    break;
                n.right.next = n.next.left;
                n = n.next;
            }
            temp = temp.left;
        }
    }

}
