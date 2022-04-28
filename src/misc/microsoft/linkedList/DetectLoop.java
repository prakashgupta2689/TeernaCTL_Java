package misc.microsoft.linkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectLoop {

    public static void main(String[] args) {

        Linked linkedList = new Linked();
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(2);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(6);
        linkedList.insertAtHead(7);

       // linkedList.makeLoop(linkedList.head, 3);

        boolean hasLoop = detectLoop(linkedList.head);
        System.out.println("hasLoop: "+ hasLoop);

        //if the list contains duplicate elements
        boolean isLoop = checkLoop(linkedList.head);
        System.out.println("isLoop: "+ isLoop);
    }

    private static boolean checkLoop(Linked.Node head) {

        if(head == null || head.link == null)
            return false;

        Linked.Node slow = head;
        Linked.Node fast = head;

        while(fast.link != null && fast.link.link != null){

            slow = slow.link;
            fast = fast.link.link;

            if(slow == fast)
                return true;
        }
        return false;
    }

    //if the list does not contain any duplicate elements
    private static boolean detectLoop(Linked.Node head) {

        Set<Integer> set = new HashSet<>();
        Linked.Node temp = head;
        while(temp != null){

            if(!set.add(temp.data))
                return true;

            temp = temp.link;
        }
        return false;
    }
}
