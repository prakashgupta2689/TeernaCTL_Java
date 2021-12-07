package morganStanley.linkedLists;

public class DetectLoop {

    public static void main(String[] args) {

        //insert data in linked list
        Linked linkedList = new Linked();
        linkedList.insertAtHead(5);
        linkedList.insertAtHead(4);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(2);

        linkedList.printLinkedList(linkedList.head);

        //create a loop in the linked list
        Linked.Node head = linkedList.makeLoop(linkedList.head, 2);

        //detect loop
        System.out.println(detectLoop(linkedList.head));

        //remove loop
        Linked.Node removedLoopsHead = removeLoop(linkedList.head);
        System.out.println(detectLoop(removedLoopsHead));
        linkedList.printLinkedList(removedLoopsHead);
    }

    private static Linked.Node removeLoop(Linked.Node head) {

        Linked.Node slow = head;
        Linked.Node fast = head;
        boolean flag = false;

        while(fast.link != null && fast.link.link != null){

            slow = slow.link;
            fast = fast.link.link;

            if(slow == fast){
                flag = true;
                break;
            }
        }

        if(flag){

            slow = head;
            //move both slow and fast by one step and check if slow.link == fast.link.
            while(slow.link != fast.link){
                slow = slow.link;
                fast = fast.link;
            }

            fast.link = null;
        }
        return head;
    }

    private static boolean detectLoop(Linked.Node head) {

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
}
