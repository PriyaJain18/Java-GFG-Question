import java.util.Stack;

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
        
        
    }
    
}
