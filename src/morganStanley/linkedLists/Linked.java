package morganStanley.linkedLists;

public class Linked {

    Node head;

    static class Node{
        int data;
        Node link;

        Node(int data){
            this.data = data;
            this.link = null;
        }

        Node(){

        }
    }

    public Node insertAtHead(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }

        newNode.link = head;
        head = newNode;
        return head;
    }

    public void printLinkedList(Node head){

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println(" ");
    }

    //make a loop at the kth node
    public Node makeLoop(Node head, int k){

        Node temp = head;
        int count = 1;

        while(count < k){
            temp = temp.link;
            count++;
        }

        //store the kth node
        Node jointPoint = temp;

        //traverse the remaining nodes
        while(temp.link != null){
            temp = temp.link;
        }

        //join the last node with the jointPoint
        temp.link = jointPoint;
        return head;
    }
}
