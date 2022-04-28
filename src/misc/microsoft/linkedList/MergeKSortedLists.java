package misc.microsoft.linkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair>{

        int listIndex;
        //int dataIndex;
        int data;

        public Pair(int listIndex,  int data) {
            this.listIndex = listIndex;
          //  this.dataIndex = dataIndex;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return this.data - o.data;
        }
    }
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

        Linked linkedList3 = new Linked();
        linkedList3.insertAtHead(8);
        linkedList3.insertAtHead(5);
        linkedList3.insertAtHead(3);

        Linked.Node[] lists = new Linked.Node[]{linkedList1.head, linkedList2.head, linkedList3.head};
        Linked.Node result = mergeKListsHash(lists);
        Linked linkedList4 = new Linked();
        linkedList4.printLinkedList(result);
    }

    private static Linked.Node mergeKListsHash(Linked.Node[] lists) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Linked.Node result = new Linked.Node();
        Linked.Node head = null;

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) {
                pq.add(new Pair(i, lists[i].data));
            }
           // lists[i] = lists[i].link;
        }

        while(pq.size() > 0){

            Pair p = pq.remove();
            Linked.Node tempNode = new Linked.Node(p.data);
            if(head == null){
                result = tempNode;
                head = tempNode;
            }else{
                result.link = tempNode;
                result = tempNode;
            }
            if(lists[p.listIndex].link != null) {
                lists[p.listIndex] = lists[p.listIndex].link;
                pq.add(new Pair(p.listIndex, lists[p.listIndex].data));
            }
        }
        return head;
    }

}
