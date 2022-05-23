package microsoft.linkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedListsHashing {

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

        Set<Linked.Node> set = new HashSet<>();

        while(head1 != null){

            set.add(head1);
            head1 = head1.link;
        }

        while(head2 != null){

            if(!set.add(head2))
                return head2;

            head2 = head2.link;
        }
        return null;
    }
}
