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
    private static void reverseStr3(String str){ //REVERSE INDIVIDUAL WORDS AND THEN REVERSE WHOLE SENTENCE/STRING -> Priya here -> ayirP ereh -> here Priya 

        String wordArr[] = str.split(" ");
        StringBuilder revStr = new StringBuilder();
        
        for(String w : wordArr){
            StringBuilder strb = new StringBuilder(w);
            strb.reverse();
            revStr.append(strb.toString()+" ");  //after last word " "
        }

        System.out.println(revStr);
        
        //REVERSE WHOLE STRING : 
        
        for(int i=revStr.length()-1;i>=0;i--){
            if((i==revStr.length()-1) && (revStr.charAt(i)==' ')){    //to remove space before first word [as the unreversed one had space after last word]
                continue;
            }
            System.out.print(revStr.charAt(i));
        }
    }
    public static void main(String[] args) {
        
        //REVERSE WORDS IN A STRING:  str= My name is Priya -> rev_Str = Priya is name My
       
        String str = "My name is Priya";
        String revStr = reverseStr1(str);
        System.out.println(revStr);
        reverseStr2(str);
        reverseStr3(str);
        //try using 2-pointer algo + swap 
    }
    
}
//stb.reverse(); -> reverse function of StringBuilder gives mirror image of original String 
