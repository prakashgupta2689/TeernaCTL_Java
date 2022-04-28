package misc.morganStanley.linkedLists;

public class DeleteAlternateNodes {

    public static void main(String[] args) {

        Linked linkedList = new Linked();
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(6);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(10);
        Linked.Node head= linkedList.insertAtHead(9);

        linkedList.printLinkedList(head);

        System.out.println("After deleting alternate nodes");
        deleteAltNodes(head);
        linkedList.printLinkedList(head);
    }

    private static void deleteAltNodes(Linked.Node head) {

        if(head == null)
            return;

        Linked.Node prevNode = head;
        Linked.Node currNode = head.link;

        while(prevNode != null && currNode != null){

            prevNode.link = currNode.link;

            currNode = null;

            prevNode = prevNode.link;
            if(prevNode != null)
                currNode = prevNode.link;
        }


    }
}
