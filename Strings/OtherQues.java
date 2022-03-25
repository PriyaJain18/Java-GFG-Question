import java.util.Arrays;
import java.util.Stack;

public class OtherQues {
    private static String reverseStr1(String str){
        String[] arr = str.split(" ");

        System.out.println(Arrays.toString(arr));
        
        StringBuilder rev = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            rev.append(arr[i]+" ");
        }
        System.out.println(rev);
        return rev.toString();
    }
    private static void reverseStr2(String str){
        Stack<String> stack = new Stack<String>();
        String[] strArray = str.split(" ");
        
        for(String e : strArray){
            stack.push(e);
        }
        StringBuilder revf = new StringBuilder();
        int i =0;
        while(i < strArray.length){
            revf.append(stack.pop()+" ");
            i++;
        }
        System.out.println(revf);
    }
    private static void reverseWord(char[] charArr){
        int start = 0;
        for(int end=0;end<charArr.length;end++){
            if(charArr[end] == ' '){
                
               [end-1,start]//////////////////
               //////////////////CONTINUE FROM HERE 
            }

        }

    }
    private static void reverseStr3(String str){

        char[] charArr = str.toCharArray();
        //REVERSE INDIVIDUAL WORDS : 
        reverseWord();
        
        
        //REVERSE WHOLE STRING : 
        
        for(int i=charArr.length;i>=0;i--){
            System.out.print(charArr[i]);
        }
    }
    public static void main(String[] args) {
        
        //REVERSE WORDS IN A STRING:  str= My name is Priya -> rev_Str = Priya is name My
       
        String str = "My name is Priya";
        String revStr = reverseStr1(str);
        System.out.println(revStr);

        reverseStr2(str);
        reverseStr3(str);
    }
    
}
