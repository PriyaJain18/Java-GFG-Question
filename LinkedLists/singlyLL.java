import java.time.temporal.Temporal;
import java.util.LinkedList;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}

public class singlyLL {

    private static void traversal(Node head){
        Node current  = head;
        if(current == null){
            return; //for empty LL
        }
        
        while(current != null){      //current the node itself is null , that means previous element was the last element of linked list
            System.out.println(current.data);
            current = current.next;
        }
        return;
    }
    private static void traversal2(Node head){
    
        if(head == null){
            return;   //for empty LL
        }
        System.out.println(head.data);
        traversal2(head.next);   //4th node returned call NACK to here [as this function led to the 4th function execution]
      //NOTHING AFTER HERE, SO CALLBACK FROM 4TH NODE ENDS HERE
    }

    private static Node addAtStart(int insertEle,Node head){
        Node newHead = new Node(insertEle);
        newHead.next = head;
        head = newHead;    //optional when returning head to be assigned to variable 'head' outside this function
        // traversal(head);
        return head;

    }

    private static Node addAtEnd(int insertEle, Node head){
        Node newEnd = new Node(insertEle);
        if(head == null){
            return newEnd;           //if LL is empty , lastElement inserted becomes head of the linked list 
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newEnd;

        // traversal(head);
        return head;
    }

    private static Node removeAtStart(Node head){
        if(head == null){
            return null;         //case when LL is empty
        }
        else{
            return head.next;
        }
        //setting head as current , moving head to next node and freeing current i.e. most-starting wala node
    }
    private static Node removeAtEnd(Node head){
        if(head == null){
            return null;    //case when LL is empty
        }
        if(head.next == null){         //handled cuurent ka next 
            // head = null;           //JAVA TAKES CARE OF MEMORY DEALLOCATION (GARBAGE) BY ITSELF
            return null;
        }

        Node current = head;
        while(current.next.next != null){   //handling current ke next ka next 
            current = current.next;
        }
        current.next = null;         //deleting current ka next as current ke next ka next is NULL   //  n -> n -> n,cur -> n,nextOfCur -> []
        return head;
    }
    
    
    private static Node insertAtPos(Node head,int pos,int data){ //solving accor to pos starting from -> 1 2 3 4 ... of LL  //pos = ArrayIndex+1
        
        Node temp = new Node(data);
        if(pos == 1){
            temp.next = head;
            return temp;
        }
        Node current = head;
        for(int i=1;(i<=pos-2) && (current!=null) ;i++){  // inserting 40->  10 20 30.c 50/pos 60 ->comming out of loop BEFORE 'current' reaches pos[where 50 is currently placed]
            current = current.next; //if current == null encountered means we can insert the element at current pos only not beyond that
        }
        if(current == null){
            System.out.println("Sorry ,element cannot be inserted !");
            return head;
        }
        temp.next = current.next;
        current.next = temp;
        return head;
    }


    private static int searchKey1(Node head,int key){
        if(head == null){ //when LL is empty
            return -1;
        }

        Node current = head;
        for(int i=1;current!=null;i++){
            if(current.data == key){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    private static int searchKey2(Node head,int key){
        if(head == null){      //if current head is null return -1 
            return -1;
        }
// to search = 40 => 10.h[return x+1=3+1=4 final_POS]    20.h1[return x+1=2+1=3]   30.h2[return x+1 = 1+1=2]   40.h3[matched , return x=1]    50  60
        if(head.data == key){   
            return 1;
        }else{
            int res = searchKey2(head.next, key);
            if(res == -1){       //only in case nothing was present [null node] in the previous node , so current node also must be null
                return -1;
            }else{
                return res+1;       //returns 4 at end of callback stack 
            }
        }
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(50);
        head.next.next.next.next = new Node(60);

        // traversal(head);  //O(n) time, O(1) auxiliary space 
        // traversal2(head);    //O(n) time, O(n) auxiliary space [space for recursive call stack]

        //Insertion at beginning :  O(1) Time
        
        // head =addAtStart(5,head);
        // head =addAtStart(4,head);
        // head =addAtStart(2,head);
       
        // System.out.println();
        // traversal(head);

        //Insert at End :  O(N) time due to traversal 
        // head = addAtEnd(45,head);
        // head = addAtEnd(55,head);
        // head = addAtEnd(65,head);
        
        // System.out.println();
        // traversal(head);

        // head = removeAtStart(head);    //O(1) TIME
        // head = removeAtStart(head); 
        // head = removeAtStart(head);
       
        // System.out.println();
        // traversal(head);
        
        // head = removeAtEnd(head);    //O(N) TIME
        // head = removeAtEnd(head);
        // head = removeAtEnd(head);

        // System.out.println();
        // traversal(head);
        
        // head = insertAtPos(head,4,40);  //insert 40 at position=4 [means index=3] //note : we cannot insert elements after currentsize+1
        // System.out.println();
        // traversal(head);

        // int pos = searchKey1(head,30); //iterative sol  //O(n) time and O(1) space
        // System.out.println(pos);

        // pos = searchKey2(head, 30);  //recursive sol    //O(n) time and O(n) space
        // System.out.println(pos);
    }
    
}


//ADVANCE LINKED LIST [SORTING PURPOSES] -> SKIP LIST 
//ALLOCATIONS : 
// int a =10 i.e. [ 10 ] b=20 , a = b; => means b=20 but also a=20 now  [ 20 ]
                   //a                                                   //a
// Node current = head             => [head | *]
                                      //current, head 
                                     
// insertHead.next = head         => [insertHead | * --]-----> [Head | *]
// current = current.next          => [  A | * --]-----------> [B | * ]
                                     //current earlier=A
                                                           //current now=B