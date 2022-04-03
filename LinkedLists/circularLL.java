
class Node{
    int data;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}

public class circularLL {
    private static void traversalCLL(Node head){
        if(head == null){
            System.out.println("empty Circular LL");
            return;
        }
        if(head.next == null){            //FOR SLIGHT OPTIMIZATION , But is OPTIONAL as below code can also HANDLE THIS CASE  
            System.out.println(head.data);
            return;
        }
        
        System.out.print(head.data+" ");  //printing 1st element 
        
        //Way1 : for(Node r=head.next ; r != head ; r = r.next){  System.out.print(current.data);  }  -> return;
        //OR 
        //Way2 : [note :extra 'current' Node is formed]

        Node current = head;    

        current = current.next;
        while(current != head){      //printing next elements
            System.out.print(current.data+ " ");
            current = current.next;
        }
        System.out.println("Traversed!");
        return;
    }

    private static void traversalCLL2(Node head){
        if(head == null) return;
        Node current = head;

        do{  //handles the case even if CLL contains only 1 element
            System.out.print(current.data+ " ");         
            current = current.next;
        }while(current != head);

    }
   
    private static Node insertAtStart(Node head,int data){
        Node newStart = new Node(data);
        if(head == null){
            //AS WE are inserting 1st element in circular LL here , we need to take responsibilty to make it 'circular'
            newStart.next = newStart;
        }else{            
            Node current = head;
            while( current.next != head){
                current=current.next;
            } 
            current.next = newStart;
            newStart.next = head;
        }
        return newStart;
    }
    
    private static Node insertAtStart2(Node head,int data){
        Node temp = new Node(data);
        if(head == null){
            temp.next = temp;
            return temp;
        }else{   // 10.h -> 5.t -> 20   => swap => 5.h -> 10.t -> 20 
            temp.next = head.next;
            head.next = temp;
            //swap data of head[10] and temp/OR/head.next[5]
            int x = head.data;
            head.data  = temp.data;
            temp.data = x;
            return head;    // return head[5]
        }
        //note: no need of creating 'current' Node here ; we are traversing using head 
    }
    private static Node insertAtEnd(Node head,int data){
        Node temp = new Node(data);
        if(head == null){
            temp.next = temp;
            return temp;       //as single element present
        }else{
            Node current = head;
            while(current.next != head){
                current = current.next;
            }
            current.next = temp;
            temp.next = head;
            return head;
        }
    }

    private static Node insertAtEnd2(Node head,int data){

        Node temp = new Node(data); 
        if(head == null){
            temp.next = temp;
            return temp;
        }else{
            //right now:  10.h 20 30 40
            temp.next = head.next;
            head.next = temp;
            //right now: 10.h [50.t] 20 30 40

            //swapping head and temp's data:
            int d = head.data;
            head.data  = temp.data;
            temp.data = d; 
            //right now: 50.h 10.t 20 30 40

            return temp;     //head's position remains same but data swapped so we need to return temp
        }

    }
    
    private static Node deleteStart(Node head){
        if(head == null || head.next == null){
            return null;
        }else{
            Node current = head;
            while(current.next != head){ 
                current = current.next; 
            }
            //20 30.c -> 10.h 20 
            current.next = head.next;
            //20 30.c -> 20  //no need to free head[10] explicitly as is unattached to CLL
            return current.next;  //returning 20[as new head]
        }

    }
    
    private static Node deleteStart2(Node head){
        if(head == null || head.next == null){    //CLL contains 0 or 1 Element
            return null;
        }else{
            // 10.h  20.newHeadRequired  30 40 
            head.data  = head.next.data;
            // 20.h  20.newHeadRequired  30 40  
            //deleting 2nd position element as it is repititive  
            head.next = head.next.next;  
            //Now , 2nd-pos[20] -> 30 -> 40 -> 10 but as 2nd-pos[20] is unreachable by CLL , Does'nt matter if we free memory in java [OPTIONAL]   
            return head;
        }
    }

    private static Node deleteEnd(Node head){
        if(head == null || head.next == null){
            return null;
        }else{
            Node current = head.next;
            while(current.next.next != head){
                current = current.next;
            }
            // 10.h 20 30.c 40 -> 10.h 20
            current.next = head;    //Remaining [40]-> 10 -> 20 , 40 will automatically be freed by java
            return head;
        }
    }

    private static Node deleteEnd2(Node head){
        if(head == null || head.next == null){
            return null;
        }else{
            // 10.h 20 30 [40] -> 10.h 20 
            ///////////////////LEFT @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ CONTINUE FROM HERE

            return head;
        }
    }
   
    public static void main(String[] args) {

        //Circular Singly LinkedList : 
        
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;

        // traversalCLL(head);
        // traversalCLL2(head);
        // System.out.println();

        // head = insertAtStart(head,5);  //O(n)
        // head = insertAtStart2(head, 2);  //O(1)  //logic : insert btw pos 1 and 2 [last_node.next will point to 1pos_node as usual ] ->swap data of pos1 and pos2 ;
        // traversalCLL(head);
        // System.out.println(head.data);

        // head = insertAtEnd(head,40);   //Theta(n)
        // head = insertAtEnd2(head, 50); //Theta(1)
        // traversalCLL(head);
        // System.out.println(head.data);

        // head = deleteStart(head);    //O(N)
        // head = deleteStart2(head);  //O(1)
        // traversalCLL(head);
        // System.out.println(head.data);

        // head = deleteEnd(head);
        head = deleteEnd2(head);             ///@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@CONTINUE 
        traversalCLL(head);
        System.out.println(head.data);

        head = deleteKpos(head,3);        //delete k-th position element 
        traversalCLL(head);
        System.out.println(head.data);
        

    }
    
}
