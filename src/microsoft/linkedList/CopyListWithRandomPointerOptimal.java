package microsoft.linkedList;

public class CopyListWithRandomPointerOptimal {

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

        ListNode temp = node;

        while(temp != null){

            ListNode tempNode = new ListNode(temp.val, null, null);
            tempNode.next = temp.next;
            temp.next = tempNode;

            temp = temp.next.next;
        }

//        //print the list
//        temp = node;
//        while(temp != null){
//
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }

        //assign the random pointers
        temp = node;
        while(temp != null){
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }

        ListNode newNode = new ListNode(-1, null, null);
        ListNode head = newNode;
        temp = node;

        //create the cloned list
        while(temp != null){

            newNode.next = temp.next;
            temp = temp.next.next;
            newNode = newNode.next;
        }
        return head.next;
    }
}
