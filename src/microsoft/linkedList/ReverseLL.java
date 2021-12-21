package microsoft.linkedList;

public class ReverseLL {

    public static void main(String[] args) {

        Linked linkedList = new Linked();
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(6);

        linkedList.printLinkedList(linkedList.head);

        Linked.Node head = reverse(linkedList.head);
        linkedList.printLinkedList(head);
    }

    private static Linked.Node reverse(Linked.Node head) {

        Linked.Node dummy = null;

        while(head != null){

            Linked.Node next = head.link;
            head.link = dummy;
            dummy = head;
            head = next;

        }
        return dummy;
    }
}
