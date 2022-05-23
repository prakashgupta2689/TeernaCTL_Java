package microsoft.linkedList;

public class MergeTwoSortedLists {

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

        Linked.Node result = mergeTwoLists(linkedList1.head, linkedList2.head);
        Linked linkedList3 = new Linked();
        linkedList3.printLinkedList(result);
    }

    private static Linked.Node mergeTwoLists(Linked.Node head1, Linked.Node head2) {

        Linked.Node temp1 = head1;
        Linked.Node temp2 = head2;

        Linked.Node res = new Linked.Node();
        Linked.Node head = null;

        while(temp1 != null && temp2 != null){

            if(temp1.data <= temp2.data){
                Linked.Node tempNode = new Linked.Node(temp1.data);
                if(head == null){
                    res = tempNode;
                    head = tempNode;
                }else{
                    res.link = tempNode;
                    res = tempNode;
                }
                temp1 = temp1.link;
            }else{
                Linked.Node tempNode = new Linked.Node(temp2.data);
                if(head == null){
                    res = tempNode;
                    head = tempNode;
                }else{
                    res.link = tempNode;
                    res = tempNode;
                }
                temp2 = temp2.link;
            }
        }

        while(temp1 != null){
            Linked.Node tempNode = new Linked.Node(temp1.data);
            if(head == null){
                res = tempNode;
                head = tempNode;
            }else{
                res.link = tempNode;
                res = tempNode;
            }
            temp1 = temp1.link;
        }

        while(temp2 != null){
            Linked.Node tempNode = new Linked.Node(temp2.data);
            if(head == null){
                res = tempNode;
                head = tempNode;
            }else{
                res.link = tempNode;
                res = tempNode;
            }
            temp2 = temp2.link;
        }

        return head;
    }
}
