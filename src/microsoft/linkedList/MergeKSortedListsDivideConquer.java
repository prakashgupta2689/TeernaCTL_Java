package microsoft.linkedList;

public class MergeKSortedListsDivideConquer {

    public static void main(String[] args) {

        Linked linkedList1 = new Linked();
        linkedList1.insertAtHead(5);
        linkedList1.insertAtHead(4);
        linkedList1.insertAtHead(1);
        //linkedList1.insertAtHead(0);

        Linked linkedList2 = new Linked();
        linkedList2.insertAtHead(4);
        linkedList2.insertAtHead(3);
        linkedList2.insertAtHead(1);
        //linkedList2.insertAtHead(0);

        Linked linkedList3 = new Linked();
       // linkedList3.insertAtHead(8);
        linkedList3.insertAtHead(6);
        linkedList3.insertAtHead(2);

        Linked.Node[] lists = new Linked.Node[]{linkedList1.head, linkedList2.head, linkedList3.head};
        Linked.Node result = mergeKListsDC(lists);
        Linked linkedList4 = new Linked();
        linkedList4.printLinkedList(result);
    }

    private static Linked.Node mergeKListsDC(Linked.Node[] lists) {

        if(lists == null || lists.length == 0)
            return null;

        return mergeKListsDC(lists, 0, lists.length-1);
    }

    private static Linked.Node mergeKListsDC(Linked.Node[] lists, int start, int end) {

        if(start == end){
            return lists[start];
        }

        int mid = start + (end - start)/2;
        Linked.Node leftPart = mergeKListsDC(lists, start, mid);
        Linked.Node rightPart = mergeKListsDC(lists,mid+1, end);

        return mergeTwoParts(leftPart, rightPart);
    }

    private static Linked.Node mergeTwoParts(Linked.Node head1, Linked.Node head2) {

        Linked.Node result = new Linked.Node();
        Linked.Node head = null;

        while(head1 != null && head2 != null){

            if(head1.data < head2.data){

                Linked.Node tempNode = new Linked.Node(head1.data);
                if(head == null){
                    result = tempNode;
                    head = tempNode;
                }else{
                    result.link = tempNode;
                    result = tempNode;
                }
                head1 = head1.link;
            }else{
                Linked.Node tempNode = new Linked.Node(head2.data);
                if(head == null){
                    result = tempNode;
                    head = tempNode;
                }else{
                    result.link = tempNode;
                    result = tempNode;
                }
                head2 = head2.link;
            }
        }

        while(head1 != null){
            Linked.Node tempNode = new Linked.Node(head1.data);
            if(head == null){
                result = tempNode;
                head = tempNode;
            }else{
                result.link = tempNode;
                result = tempNode;
            }
            head1 = head1.link;
        }

        while(head2 != null){
            Linked.Node tempNode = new Linked.Node(head2.data);
            if(head == null){
                result = tempNode;
                head = tempNode;
            }else{
                result.link = tempNode;
                result = tempNode;
            }
            head2 = head2.link;
        }
        return head;
    }
}
