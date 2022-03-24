public class SubsequenceOfStr {

  
    public static boolean BetterSol(String s1,String s2,int n1,int n2){       //recursive sol
        
        if(n2 == 0){   //s2 whole covered 
            return true;
        }
        if(n1 == 0){      //s1 covered whole but s2 not covered whole otherwise would have returned from above statement 
            return false;   //subseq. not found
        }

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return BetterSol(s1,s2,n1-1,n2-1);
        }else{
            return BetterSol(s1,s2,n1-1,n2);
        }
    }

    public static boolean BestSol(String s1, String s2) {   //Iterative sol

        if(s1.length() < s2.length()){
            return false;
        }
        int j = 0;
        for (int i = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        return j == (s2.length());
    }

    public static void main(String[] args) {
        
        
        String s1 = "GeeksForGeeks";
        String s2 = "Fks";
    
        //SUB STRING / SUBARRAY : 
        boolean isSubstring = (s1.contains(s2)) ? true : false;
        System.out.println(isSubstring);

        //SUB SEQUENCE / SUBSETS : 
        boolean isSubsequence = BetterSol(s1,s2,s1.length(),s2.length()); //recursive  //O(m+n) -> time, O(m+n) -> space(recusive call stack)
        System.out.println(isSubsequence);
        isSubsequence = BestSol(s1,s2);    //iterative  //O(m+n) -> time, O(1) -> space
        System.out.println(isSubsequence);
    }

}
