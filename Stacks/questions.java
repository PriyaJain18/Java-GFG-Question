import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

class TwoStacksin1Arr{
    int top1,top2,cap;
    int arr[];
    TwoStacksin1Arr(int n){
        cap = n;
        top1 = -1;
        top2 = cap;
        arr = new int[n];
    }
    void push1(int x){
        if(top1 == (top2-1)){
            System.out.println("cannot insert in full stack");
            return;
        }
        top1++;
        arr[top1] = x;  
        return;
    }
    int peek1(){
        if(top1 == -1) return Integer.MAX_VALUE;  //stack underflow
        return arr[top1];
    }  
    int pop1(){
        if(top1 == -1) return Integer.MAX_VALUE;   //stack underflow
        int res = arr[top1];
        top1--;
        return res;
    }

    void push2(int x){
        if(top1 == (top2-1)){
            System.out.println("cannot insert in full stack");
            return;
        }
        top2--;
        arr[top2] = x;
        return;
    }
    int peek2(){
        if(top2 == arr.length) return Integer.MAX_VALUE;        //stack underflow //System.exit()
        return arr[top2];
    }
    int pop2(){
        if(top2 == arr.length) return Integer.MAX_VALUE;        //stack underflow
        int res = arr[top2];
        top2++;
        return res;
    }
    void printArr(){
        for(int i=0;i<cap;i++){
            System.out.print(arr[i]);
            // arr1[i]
        }

    }
}
public class questions {

    private static boolean balancedBrackets(String st){
        Stack<Character> stack = new Stack<>();
       
        for(int i=0;i<st.length();i++){
            if(i==0){
                if(st.charAt(0)=='[' || st.charAt(0)=='{' || st.charAt(0)=='('){
                    stack.push(st.charAt(0));
                    continue;
                }else{
                    return false; //handles case when 1st char is closing bracket 
                } 
            }
            if(st.charAt(i)=='[' || st.charAt(i)=='{' || st.charAt(i)=='('){
                stack.push(st.charAt(i));
            }
            if(st.charAt(i)==')'){
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
            if(st.charAt(i)=='}'){
                if(stack.peek() == '{') stack.pop();
                else return false;
            }
            if(st.charAt(i)==']'){            
                if(stack.peek() == '[') stack.pop();
                else return false;
            }
            
        }
        return (stack.isEmpty());
    }

    private static boolean balanced(char a,char b){
        if(a=='[' && b==']') return true;
        else if (a=='(' && b==')') return true;
        else if (a=='{' && b=='}') return true;
        else return false;
    }
    private static boolean balancedBrackets2(String st){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<st.length();i++){
            char x = st.charAt(i);
            
            if(x=='[' || x=='{' || x=='('){
                stack.push(x);
            }else{      //closing bracket 
                if(stack.isEmpty()) return false; //first-current char is a closing bracket 
                if(balanced(stack.peek(),x) == true){
                    stack.pop();
                }else{
                    return false;         //([}  where } is current element
                }
            }

        }

        return (stack.isEmpty());           
    }
  
  
    public static void main(String[] args) {
        //Check if brackets are Balanced : O(N) -> Time and space 
        System.out.println(balancedBrackets("[{}]"));
        System.out.println(balancedBrackets("}{][]})"));

        System.out.println(balancedBrackets2("[{}]"));
        System.out.println(balancedBrackets2("}{][]})"));
        TwoStacksin1Arr arr1 = new TwoStacksin1Arr(6);
        arr1.push1(10);
        arr1.push1(25);
        arr1.push2(65);
        // System.out.println(Arrays.toString(arr1));  //10 25 ----65
        System.out.println(arr1.pop2());  //65
        arr1.push2(60);
        arr1.push2(50);
        arr1.push2(40);
        System.out.println(arr1.pop1());  //25
       
        // System.out.println(Arrays.toString(arr1));     //10 - - 40 50 60 
        arr1.push1(20);
        arr1.push1(30);
        arr1.printArr();  //10 20 30 40 50 60
       



    }
    
}
