import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    Node head;
    public void printList(){
        if(head==null){
            System.out.println("Linked list is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(" null");
        //System.out.println();
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        Node temp=head;
        int ci=0;
        while(temp!=null && ci<index-1){
            temp=temp.next;
            ci++;
        }
        if(temp==null){
            System.out.println("Index out of bounds");
            return;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head=head.next;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    public void deleteindex(int index){
        if(index==0){
            deleteFirst();
            return;
        }
        Node temp=head;
        int ci=0;
        while(temp!=null && ci<index-1){
            temp=temp.next;
            ci++;
        }
        if(temp==null || temp.next==null){
            System.out.println("Index out of bounds");
            return;
        }
        temp.next=temp.next.next;
    }
    public void deleteValue(int value){
        if(head==null) return;
        if(head.data==value){
            head=head.next;
            return;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.data!=value){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Value not found");
            return;
        }
        temp.next=temp.next.next;
    }
    public void reverseIterative() {
    Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
        next = current.next;  // Store next node
        current.next = prev;  // Reverse the link
        prev = current;       // Move prev forward
        current = next;       // Move current forward
    }

    head = prev; // Update head to new first node
}

}
class prefs{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        LinkedList list=new LinkedList();
        list.addFirst(20);
        list.addLast(30);
        list.addFirst(10);
        list.addIndex(1, 15);
        list.printList();
        list.reverseIterative();
        list.printList();
        

    }
}