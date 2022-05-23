package microsoft.linkedList;

public class IntersectionOfTwoLinkedListOptimal2 {

    public static void main(String[] args) {

        Linked linkedList1 = new Linked();
        linkedList1.insertAtHead(4);
        linkedList1.insertAtHead(2);
        linkedList1.insertAtHead(1);
        //linkedList1.insertAtHead(0);

        Linked linkedList2 = new Linked();
        linkedList2.insertAtHead(4);
        linkedList2.insertAtHead(3);
        linkedList2.insertAtHead(1);
        //linkedList2.insertAtHead(0);

        Linked.Node intersection = findIntersection(linkedList1.head, linkedList2.head);
        System.out.println(intersection);

    }

    private static Linked.Node findIntersection(Linked.Node head1, Linked.Node head2) {

        if(head1 == null || head2 == null)
            return null;

        Linked.Node temp1 = head1;
        Linked.Node temp2 = head2;

        while(temp1 != temp2){

            //for the end of a iteration, we just reset the pointer to the head of the other linkedlist
            temp1 = (temp1 == null)? head2 : temp1.link;
            temp2 = (temp2 == null)? head1 : temp2.link;
        }
        return temp1;
    }
}
