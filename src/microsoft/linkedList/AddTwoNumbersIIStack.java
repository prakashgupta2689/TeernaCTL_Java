package microsoft.linkedList;

import java.util.Stack;

public class AddTwoNumbersIIStack {

    public static void main(String[] args) {

        Linked linkedList1 = new Linked();
        linkedList1.insertAtHead(9);
        linkedList1.insertAtHead(7);
        linkedList1.insertAtHead(7);
        //linkedList1.insertAtHead(0);

        Linked linkedList2 = new Linked();
        linkedList2.insertAtHead(4);
        linkedList2.insertAtHead(2);
        linkedList2.insertAtHead(6);
        //linkedList2.insertAtHead(0);

        Linked.Node head = addTwoNumbersUsingStack(linkedList1.head, linkedList2.head);
        Linked linkedList3 = new Linked();
        linkedList3.printLinkedList(head);

    }

    private static Linked.Node addTwoNumbersUsingStack(Linked.Node head1, Linked.Node head2) {

        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        Stack<Integer> res = new Stack<>();
        int carry = 0;

        Linked.Node temp1 = head1;
        Linked.Node temp2 = head2;
        Linked.Node head = null;
        Linked.Node result = new Linked.Node();

        //add elements in the stack
        while(temp1 != null){
            stk1.push(temp1.data);
            temp1 = temp1.link;
        }

        while(temp2 != null){
            stk2.push(temp2.data);
            temp2 = temp2.link;
        }

        while(!stk1.isEmpty() || !stk2.isEmpty()){
            int sum = 0;

            if(!stk1.isEmpty()){
                sum+= stk1.pop();
            }
            if(!stk2.isEmpty()){
                sum+= stk2.pop();
            }

            sum+= carry;
            if(sum >= 10){
                carry = sum/10;
                sum = sum%10;
            }else{
                carry = 0;
            }

            res.push(sum);
        }
        if(carry != 0){
            res.push(carry);
        }

        //make the linked list
        while(!res.isEmpty()){

            Linked.Node tempNode = new Linked.Node(res.pop());

            if(head == null){
                result = tempNode;
                head = tempNode;
            }else{
                result.link = tempNode;
                result = tempNode;
            }
        }
        return head;
    }
}
