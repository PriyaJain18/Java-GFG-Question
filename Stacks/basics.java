import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class StackArr{
    int arr[];
    int cap;  //capacity : Maximum no. of elements this stack can hold
    int top;
    StackArr(int cap){
        this.cap = cap;
        arr = new int[cap];
        top = -1;
    }

    void push(int item){
        if(top == cap){
            System.out.println("Full stack;Stack-Overflow condition");   //HANDLE ERROR 
            return;
        }
        top++;
        arr[top] = item;
    }

    int peek(){
        if(top == -1){
            System.out.println("empty stack;Stack-Underflow condition");   //HANDLE ERROR 
            return 0;
        }
        return arr[top];
    }
    int pop(){
        if(top == -1){
            System.out.println("empty stack;Stack-Underflow condition");   //HANDLE ERROR 
            return 0;
        }
        int res = arr[top];
        top--;
        return res;
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        if(arr.length == 0) return true;
        else return false;
        //or// return(top==-1);
    }

}
class StackAL{
    ArrayList<Integer> arr = new ArrayList<>();
    void push(int x){ 
        arr.add(x);
    }
    int pop(){
        if(arr.isEmpty()) return 0;    //HANDLE ERROR
        int res= arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return res;
    }
    int peek(){
        if(arr.isEmpty()) return 0;     //HANDLE ERROR
        return arr.get(arr.size()-1);
    }
    boolean isEmpty(){
        return (arr.size() == 0);       //or//return arr.isEmpty();
    }
    int size(){
        return arr.size();
    }
}

class LLNode{
    int data;
    LLNode next;
    LLNode(int x){
        data = x;
        next = null;
    }
}
class StackLL{   //  ->30
    LLNode head;
    int count;
    StackLL(){  //generally considered 
        head = null;
        count = 0;
    }
    StackLL(int headData){
        head = new LLNode(headData);
        count = 1;
    }

    void push(int x){
        LLNode res = new LLNode(x);
        res.next = head;
        count++;
        head = res;  //returns new/updated head
    }

    int pop(){
        if(head == null) return Integer.MAX_VALUE; //Special value for us to identify if stack underflow
        int res = head.data;
        head = head.next;
        count--;
        return res;
    }

    int peek(){
        if(head == null) return Integer.MAX_VALUE;   //Special value for us to identify if stack underflow
        return head.data;
    }
    boolean isEmpty(){
        return (head == null);
    }

    int size(){
        return count;
    }
}

public class basics {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        //OR//
        // ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(10);
        st.push(20);
        System.out.println(st.peek()); //20
        System.out.println(st.pop());  //20 deletes and also outputs 20 cuz of syso
        System.out.println(st.isEmpty());
        System.out.println(st.size());

        /*
        VECTOR: thread safe thus in singlr threaded env. causes more overhead as compared to ARRAYDEQUE .Thus, in a single threaded environment -> use ARRAYDEQUE > STACK
        STACK and ARRAYDEQUE -> dynamic-size array implemented structures with functions/operations having AMORTIZED TIME COMPLEXITY= O(1)
        AMORTIZED COMPLEXITY -> push() generally cost -> O(1) but due to resizing of array, push operation can cost O(N) once in a while ,so AMORTIZED (overall) compl. considered is O(1)
        */

        //FIXED SIZE ARRAY IMPLEMENTATION OF STACK : 

        StackArr st1 = new StackArr(5); //no dynamic resizing //worst case :O(1)
        st1.push(20);
        st1.push(30);
        System.out.println(st1.peek()); //30
        st1.push(40);
        System.out.println(st1.pop());  //40
        System.out.println(st1.isEmpty());
        System.out.println(st1.size());

        //DYNAMIC SIZE ARRAY IMPLEMENTATION OF STACK : 

        StackAL st2 = new StackAL(); //dynamic resizing   //O(1)
        st2.push(20);
        st2.push(30);
        System.out.println(st2.peek()); //30
        st2.push(40);
        System.out.println(st2.pop());  //40
        System.out.println(st2.isEmpty());
        System.out.println(st2.size());

        //LINKEDLIST IMPLEMENTATION OF STACK : 

        StackLL st3 = new StackLL(10); //dynamic resizing   //worst case: O(1)
        //OR//
        // StackLL st3 = new StackLL(); 
        st3.push(20);
        st3.push(30);
        System.out.println(st3.peek()); //30
        st3.push(40);
        System.out.println(st3.pop());  //40
        System.out.println(st3.isEmpty());
        System.out.println(st3.size());
    }
    
}
