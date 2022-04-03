class Node{
    int data;
    Node next;
    Node prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

public class doublyLL {
    private static Node DLLtraversal(Node head){
        if(head == null){
            System.out.println("empty Doubly LL");
            return head;
        }
        Node current = head;
        while(current != null){ //printing to last of DLL
            System.out.print(current.data + " ");
            current = current.next;
        }
        return head;
    }
    

    private static Node InsertAtStart(Node head,int data){

        Node firstNode = new Node(data);
        // 10 20 30 40 

        if(head == null){
            head = firstNode;
            return firstNode;        //this node becomes head as 'InsertAtStart' returns latest-head 
        }
        head.prev = firstNode;
        firstNode.next = head;
        return firstNode;

    }
    private static Node InsertAtStart2(Node head,int data){
        Node firstNode = new Node(data);
        firstNode.next = head;
        if(head != null){
            head.prev = firstNode;
        }
        return firstNode;
    }


    private static Node InsertAtEnd(Node head,int data){

        Node temp = new Node(data);
        if(head == null){
            // head = temp; //optional to write as Returned value would be considered as 'head'
            return head;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = temp;
        temp.prev = current;
        return head;
    }

    private static Node reverseDll(Node head){      //logic -> for all elements , exchange prev and next of current element
        //initial : 10[h]  <-p 20 n-> 30 
        //final   : 30[h]  <-p 20 n-> 10
        if(head == null || head.next == null){      //DLL with 0 or 1 element
            System.out.println("empty Doubly LinkedList !");
            return head;
        }
        Node current = head; 
        while(current != null){
//swapping current.next & current.previous: //let current = 20, prev/10 ko khali temp var me dal dia -> cur.prev[empty rn] points to cur.next[30] -> cur.next[which is also 30 rn] points to temp var[i.e. 10]

            Node temp = current.prev;      //note: temp is also a node
            current.prev  = current.next;    //current.prev now points to current.next
            current.next = temp;

            if(current.prev == null){
                head = current;
            }
            //30 20 10 
            current = current.prev;       //using we shift current forward while traversal but we exchanged prev and next of current so we travesing using 'prev'
        }
        return head;

    }
  
    private static Node deleteAtStart(Node head){
        if(head == null || head.next == null){   //DLL contains 0 or 1 element
            return null;
        }
        Node current = head;
        //head = head.next; -> head.prev = null; -> return head;  //but 20.previous still point to 10 [no way we can reach to 10 ;thus considered unattached to DLL] which doesnot matter in JAVA as memory deallocation takes place automatically
        // OR 
        current.next.prev = null;
        head = current.next;
        current.next = null;
        return head;

    }

    private static Node deleteAtEnd(Node head){
        if(head == null || head.next == null){
            System.out.println("cannot delete from empty DLL .");
            return null;
        }
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }
        
        //current.next = null; -> return head          //NOTE: 50.prev still points to 40 but doesnt matter in JAVA
        //OR
        current.next.prev = null;
        current.next = null;
        return head;
    }
  
    public static void main(String[] args) {

        Node head = new Node(10);
        Node dn1 = new Node(20);
        Node dn2 = new Node(30);
        Node dn3 = new Node(40);

        //dhead.prev would be null by default 
        head.next = dn1;
        dn1.prev = head;
        dn1.next = dn2;
        dn2.prev = dn1;
        dn2.next = dn3;
        dn3.prev = dn2;


        DLLtraversal(head);

        // head = InsertAtStart(head,5);
        // DLLtraversal(head);
        // System.out.println();
        // head = InsertAtStart2(head,2);    //easier code 
        // DLLtraversal(head);
        // head = InsertAtEnd(head, 50);
        // DLLtraversal(head);

        // head = deleteAtStart(head);
        // DLLtraversal(head);
        // System.out.println("current head is : " +head.data);
        
        // head = deleteAtEnd(head);
        // DLLtraversal(head);
        // System.out.println("current head is : " + head.data); 

        // head = reverseDll(head);
        // System.out.println("current head after reversing DLL is : " +head.data);
        // DLLtraversal(head);

        
    }
}


