package morganStanley.linkedLists;

public class MiddleElementInLL {

    public static void main(String[] args) {

        Linked linkedList = new Linked();

        //odd elements
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(1);

        linkedList.printLinkedList(linkedList.head);


        Linked.Node middleNode = findMiddleElement(linkedList.head);
        System.out.println(middleNode.data);

        //even elements
        linkedList.insertAtHead(0);

        linkedList.printLinkedList(linkedList.head);
        Linked.Node middleEvenNode = findMiddleElement(linkedList.head);
        System.out.println(middleEvenNode.data);

    }

    private static Linked.Node findMiddleElement(Linked.Node head) {

        Linked.Node slow = head;
        Linked.Node fast = head;

        while(fast != null && fast.link != null){

            slow = slow.link;
            fast = fast.link.link;
        }
        return slow;
    }
}
