import java.util.Arrays;

public class Anagram {

    public static boolean naiveSol(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        s1 = new String(a1); 
        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);
        // s2 = a2.toString();   //why not ?
        s2 = new String(a2); 

        if(s1.equals(s2)){   //equals() used cuz we wanna compare data ONLY as we have alotted s1 and s2 to new(and different) String-objects 
            return true;
        }
        return false;
    }

    public static boolean BetterSol(String s1,String s2){
        final int CHARACTERS = 256;
        int[] count = new int[CHARACTERS];
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(int i=0;i<256;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String s1 = "abccab";
        String s2 = "bcabca";

        boolean isAnagram = naiveSol(s1,s2);//logic -> sorting and matching //O(nlogN) -> Time as sorting is thereS
        System.out.println(isAnagram); 

        isAnagram = BetterSol(s1, s2); //logic -> characters as array index //O(n+CHARACTERS) -> time,O(CHARACTERS) -> Space
        System.out.println(isAnagram);

    }
    
}
