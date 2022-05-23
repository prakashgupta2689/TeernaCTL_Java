package morganStanley.linkedLists;

public class DeleteKthNodeFromEnd {

    public static void main(String[] args) {

        Linked linkedList = new Linked();
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(7);

        int k = 5;
        Linked.Node headNode = deleteKthNodeFromEnd(linkedList.head, k);
        linkedList.printLinkedList(headNode);
    }

    private static Linked.Node deleteKthNodeFromEnd(Linked.Node head, int k) {


        Linked.Node start = new Linked.Node();
        start.link = head;
        Linked.Node slow = start;
        Linked.Node fast = start;

        for(int i = 0; i < k; i++){
            fast = fast.link;
        }

        while(fast.link != null){
            slow = slow.link;
            fast = fast.link;
        }

        slow.link = slow.link.link;
        return start.link;

    }

}

