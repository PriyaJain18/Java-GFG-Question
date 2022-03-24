public class Palindrome {
    public static boolean naiveSol(String str){
        
        StringBuilder rev = new StringBuilder(str);   //Theta(n) -> space
        rev.reverse(); //Theta(n) ->time
        return (str.equals(rev.toString()));
    }
    public static boolean betterSol(String st){
        int n = st.length();
        boolean isPalindrome = false;
        int i=0,j=n-1;
        while(i<j){          //= not used as when
            if ( st.charAt(i) == st.charAt(j) ) {
                i++;
                j--;
            }else{
                isPalindrome = false;
                return isPalindrome;
            }
            isPalindrome = true;
        }
        return isPalindrome;
    }
    public static void main(String[] args) {

        String str = "aba";
        boolean isPalindrome = naiveSol(str);  //Theta(n) -> space n time
        System.out.println(isPalindrome);

        isPalindrome = betterSol(str);   //O(N)->time,O(1) -> space
        System.out.println(isPalindrome);
    }
    
}
