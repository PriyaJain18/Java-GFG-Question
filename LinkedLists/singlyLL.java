import java.time.temporal.Temporal;
import java.util.ArrayList;
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
        System.out.print(head.data+" ");
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


    //QUESTION : 
    private static Node insertInSortedLL(Node head,int data){
        Node temp = new Node(data);
        if(head == null){
            return temp;
        }
        if(head.data  > data ){
            temp.next = head;
            return temp;
        }

            Node current = head;
            //inserting 35 => 10 20 30.c 40 
            while( current.next!=null && data > current.next.data){ //NOTE : Write 1st condition 1st as if current.next would be null and if we write 2nd condition first, it would check for null's data n would give NullPointerException
                current = current.next;
            }
            // if(current.next == null){  //inserting element at end of a LL
            //     current.next = temp;
            //     return head;
            // }
            temp.next = current.next;
            current.next = temp;
            return head;
    
    }
  
    private static int middleElement(Node head){
        if(head == null) return 0;
 
        int count = 0;
        Node current = head;
        while(current != null){    //to count every element from starting till end-> use 'current' instead of 'current.next'
            count++;
            current = current.next;
        }
        current = head;
        for(int i=0;i<(count/2);i++){        //loop runs (count/2) times from starting/head
            current = current.next;
        }
        return current.data;

    }
  
    private static int middleElement2(Node head){
        if(head == null){
            return 0;
        }else if(head.next == null){
            return head.data;
        }else{
            Node slow = head,fast = head;
            while( fast!=null && fast.next!=null ){     //dono me se ek bhi cheez hote h then we need to move otta while-loop
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;       //logic : if fast-node reaches the end of LL, slow node walking at half it's pace would reach the middle of LL
        }
    }

    private static int kthFromEnd(Node head,int pos){
        if(head == null) return 0;
        Node current = head;
        int count = 0;           //gives size Of LL
        while(current!=null){
            count++;
            current = current.next;
        } 
        if(count < pos){return 0;}

        int kFromStart = (count - pos + 1); 
        current = head;
        for(int i=1;i<=kFromStart;i++){
            if(i == kFromStart){      //"=" case considered incase LL has only 1 element 
                return current.data;   //reached element at position : kFromStart
            }
            current = current.next;
        }
        return 0;  //NOT SURE OF THIS @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    }

    private static int kthFromEnd2(Node head,int pos){ //Logic: 2 reference nodes used,  maintain distance bt them such that if fast_node reach null, slow node reach the pos required
       //eg : pos 2 from end -> 10.h.s 20 30.f 40 => 10.h 20.s 30 40.f  => 10.h 20 30.s 40 [null].f => fast node has null , return slow node 
       
        if(head == null){
            return 0;
        }

        //set up fast-Node at correct distance : 
        Node fast = head;
        for(int i=1;i<=pos;i++){   //if pos = 2 , initial setup => head.fastBefore n1 n2.fastAfter n3 ...  
            // if(fast == null){
            //     return 0;    //1.s 2 .f  // ???????@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            // }
            fast = fast.next;
        }
        
        //set up slow-Node at pos=1 of LL always on head: 
        Node slow = head;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;       
    }
   
   
    private static Node reverseLL(Node head){

        if(head == null) return null;
        ArrayList<Integer> arr= new ArrayList<>();
        Node current = head;
        while(current!=null){
            arr.add(current.data);
            current = current.next;
        }
        current = head;
        for(int i=arr.size()-1;i>=0;i--){
            if(i == arr.size()-1){
                head = current;
            }
            current.data = arr.get(i);
            current = current.next;
        }
        return head;
    }
   
    private static Node reverseLL2(Node head){   //Logic :  reverse Links :after reversing: null <-10 <- temp[20] <- t[30] <- 40 <- 50.p  null.c
        if(head == null) return null;
        Node current = head;
        Node prev = null,cNext = null;     //'prev' is previous of current , detached from current ; 'cNext' is next of current which we save so we wouldnot lost current's next 's datas' 
        while(current!=null){  //example: // null <-1.head <- 2.p   3.c -> 4.cn -> 5 -> 6 
            cNext = current.next;
            current.next = prev;
            prev = current;        //current ko previous bana dia 
            current = cNext;       //cNext ko current bana dia         
        }

        return prev;     //note : for clarification : check logic above 
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

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

        // insert in a already sorted singly linkedList such that it remains sorted after insertion : 

        // System.out.println();
        // head = insertInSortedLL(head,35);
        // traversal2(head);

        //MIDDLE ELEMENT Of LinkedList :   [ if 2 middle elements , return 2nd one]
       
        // System.out.println();
        // int midd1 = middleElement(head);       //naive method
        // int midd2 = middleElement2(head);     //efficient method -> using 2 references/nodes -> slow and fast(*2 pace of slow)
        // System.out.println("middle element of LL is: "+midd1 + " i.e. "+midd2 );
        // traversal2(head);
        
        //Q: Finding k-th node from end of a LL ,if k is beyound len/positions -> print 0 
        
        // int nodeData1 = kthFromEnd(head,2); //O(n)   //3 -> position from end ,NOTE : Positions in LL numbered as 1,2,3,4... ,so from back also ..4,3,2,1
        // int nodeData2 = kthFromEnd2(head, 2); //O(n) //logic -> uses 2 references[slow and fast]
        // System.out.println(nodeData1 + " " + nodeData2);
        // traversal2(head);

        // traversal2(head);
        // head = reverseLL(head);    //naive sol
        // head = reverseLL2(head);  //O(N) time , O(1) space  //logic : reversing links 
        // System.out.println(head.data);
        // traversal2(head);

        //REVERSE RECURSIVELY : PART 1 AND PART 2 -> START @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
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