package microsoft.linkedList;

public class IntersectionOfTwoLinkedListOptimal1 {

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

        //find the length of the two linked lists
        int length1 = 0;
        int length2 = 0;

        Linked.Node temp1 = head1;
        Linked.Node temp2 = head2;

        while(temp1 != null){

            length1++;
            temp1 = temp1.link;
        }

        while(temp2 != null){

            length2++;
            temp2 = temp2.link;
        }

        int diff = length1 - length2;
        temp1 = head1;
        temp2 = head2;

        if(diff > 0){ // i.e. length1 is greater
            for(int i = 0; i< diff; i++){
                temp1 = temp1.link;
            }
        }else{//i.e. length2 is greater
            for(int i = 0; i < Math.abs(diff); i++){
                temp2 = temp2.link;
            }
        }

        while(temp1 != temp2){

            temp1 = temp1.link;
            temp2 = temp2.link;
        }
        return temp1;
    }
}
