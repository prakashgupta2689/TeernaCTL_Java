package microsoft.linkedList;

public class MergeTwoSortedListsRecursive {

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

        Linked.Node result = mergeTwoListsRec(linkedList1.head, linkedList2.head);
        Linked linkedList3 = new Linked();
        linkedList3.printLinkedList(result);
    }

    private static Linked.Node mergeTwoListsRec(Linked.Node head1, Linked.Node head2) {

        if(head1 == null)
            return head2;

        if(head2 == null)
            return head1;

        if(head1.data < head2.data){
            head1.link = mergeTwoListsRec(head1.link, head2);
            return head1;
        }else{
            head2.link = mergeTwoListsRec(head1, head2.link);
            return head2;
        }
    }
}
