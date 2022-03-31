class node{
    int data;
    node next;                  //'next' is of type 'node' [ i.e of it's class ] ->Linked List K/A Self-referential structure
    public node(int x){
        data = x;       //decides the datatype of Whole LinkedList
        next = null;      //initially        //optional code line as automatically anything initialized in java is 'Null'
    }
}

public class basics {
    public static void main(String[] args) {
        node head = new node(10);
        node n1 = new node(20);
        node n2 = new node(30);

        head.next = n1;
        n1.next = n2;
        
    }
}















/*
Problems with arrays : 1)either fixed sized or pre-allocated 2) Insertion/deletion in the beginning/middle is costly 3) Implementation of queue & dequeue is hard with arrays

Problems which is solved using LinkedLis > Arrays ->  1)Round Robin scheduling [if kisi process ka time baki h ,shift the remaining to the end of queue]      
 2) Givrn a sequence, we need to repace every 'x' with 'yyyyy'    3) Merge sort {requires extra space to merge one array with other}

Advantages of using LINKED LIST-> No preallocation of memory[no extra nodes] , insertion and deletion easily (less complex)

*/