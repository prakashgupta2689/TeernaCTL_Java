package microsoft.linkedList;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        Linked linkedList1 = new Linked();
        linkedList1.insertAtHead(3);
        linkedList1.insertAtHead(4);
        linkedList1.insertAtHead(2);
        linkedList1.insertAtHead(7);
        //linkedList1.insertAtHead(0);

        Linked linkedList2 = new Linked();
        linkedList2.insertAtHead(4);
        linkedList2.insertAtHead(6);
        linkedList2.insertAtHead(5);
        //linkedList2.insertAtHead(0);

        Linked.Node resultList = addNumbers(linkedList1.head, linkedList2.head);
        Linked linkedList3 = new Linked();
        linkedList3.printLinkedList(resultList);
    }

    private static Linked.Node addNumbers(Linked.Node head1, Linked.Node head2) {

        //reverse the two lists
        head1 = reverse(head1);
        head2 = reverse(head2);

        if(head1 == null || head2 == null)
            return null;

        Linked.Node result = new Linked.Node();
        Linked.Node head = null;

        Linked.Node temp1 = head1;
        Linked.Node temp2 = head2;
        Linked.Node tempNode;

        int carry = 0;

        while(temp1 != null || temp2 != null){

            tempNode = new Linked.Node();
            if(temp1 != null){
                tempNode.data = tempNode.data + temp1.data;
            }

            if(temp2 != null){
                tempNode.data = tempNode.data + temp2.data;
            }
            tempNode.data = tempNode.data + carry;
            tempNode.link = null;

            if(tempNode.data >= 10){
                carry = tempNode.data / 10;
                tempNode.data = tempNode.data % 10 ;
            }else{
                carry = 0;
            }

            if(head == null){

                result = tempNode;
                head = tempNode;
            }else {
                result.link = tempNode;
                result = tempNode;
            }

            if(temp1 != null) {
                temp1 = temp1.link;
            }

            if(temp2 != null) {
                temp2 = temp2.link;
            }
        }

        if(carry != 0){
            tempNode = new Linked.Node(carry);
            result.link = tempNode;
        }

        head = reverse(head);
        return head;
    }

    private static Linked.Node reverse(Linked.Node head) {

        Linked.Node dummy = null;

        while(head != null){

            Linked.Node nextNode = head.link;
            head.link = dummy;
            dummy = head;
            head = nextNode;
        }

        return dummy;
    }
}
