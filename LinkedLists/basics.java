class Node{
    int data;
    Node next;                  //'next' is of type 'node' [ i.e of it's class ] ->Linked List K/A Self-referential structure
    Node(int x){
        data = x;       //decides the datatype of Whole LinkedList
        next = null;      //initially        //optional code line as automatically anything initialized in java is 'Null'
    }
}

class dNode{
    int data;
    dNode next;
    dNode prev;
    dNode(int x){
        data = x;
        next = null;  //optional to write in java
        prev = null;
    }
}

class cirNode{
    int data;
    cirNode next;
    cirNode(int x){
        data = x;
        next = null;
    }
}

public class basics {
    public static void main(String[] args) {
        //Singly LinkedList : 
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;

        //Doubly LinkedList : 
        dNode dhead = new dNode(10);
        dNode dn1 = new dNode(20);
        dNode dn2 = new dNode(30);
        dNode dn3 = new dNode(40);

        //dhead.prev would be null by default 
        dhead.next = dn1;
        dn1.prev = dhead;
        dn1.next = dn2;
        dn2.prev = dn1;
        dn2.next = dn3;
        dn3.prev = dn2;
        //dn3.next would be null by default

        //NOTE : //if 'head' is null => head.data -> gives NullPointerException

        //Circular Singly LinkedList : 
        cirNode chead = new cirNode(10);
        chead.next = new cirNode(20);
        chead.next.next = new cirNode(30);
        chead.next.next.next = chead;

    }
}


/*
Problems with arrays : 1)either fixed sized or pre-allocated 2) Insertion/deletion in the beginning/middle is costly 3) Implementation of queue & dequeue is hard with arrays

Problems which is solved using LinkedLis > Arrays ->  1)Round Robin scheduling [if kisi process ka time baki h ,shift the remaining to the end of queue]      
 2) Givrn a sequence, we need to repace every 'x' with 'yyyyy'    3) Merge sort {requires extra space to merge one array with other}

Advantages of using LINKED LIST-> No preallocation of memory[no extra nodes] , insertion and deletion easily (less complex)

*/