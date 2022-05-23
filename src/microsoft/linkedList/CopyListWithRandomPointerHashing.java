package microsoft.linkedList;

import java.util.HashMap;

public class CopyListWithRandomPointerHashing {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val, ListNode next, ListNode random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
    public static void main(String[] args) {

        //create a linked list
        ListNode node1 = new ListNode(1, null, null);
        ListNode node2 = new ListNode(2, null, null);
        ListNode node3 = new ListNode(3, null, null);
        ListNode node4 = new ListNode(4, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.random = node2;
        node1.random = node4;
        node2.random = node1;

        ListNode clone = cloneList(node1);

        while(clone != null){
            System.out.println(clone.val + " " + clone.next + " " + clone.random);
            clone = clone.next;
        }
    }

    private static ListNode cloneList(ListNode node) {

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode temp = node;

        //put the nodes and copies in a map
        while(temp != null){

            ListNode tempNode = new ListNode(temp.val, null, null);
            map.put(temp, tempNode);
            temp = temp.next;

        }

        //create the clone
        temp = node;
        ListNode head = null;

        while(temp != null){

            if(head == null){
                head = map.get(temp);
            }
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;

        }
        return head;
    }
}
