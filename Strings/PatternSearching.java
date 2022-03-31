public class PatternSearching {
    private static boolean NaiveSol(String st, String pat) {
        int n = st.length();
        int m = pat.length();
        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (st.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == m) { // whole pattern is traversed i.e. match found
                System.out.println("match found at index of st at : " + i);
                return true;
            }
        }
        return false;
    }

    private static boolean BetterSol(String st, String pattern) {
        int n = st.length();
        int m = pattern.length();
        // ABCABCD
        // ABCD
        for (int i = 0; i < n - m;) {
            int j;
            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != st.charAt(i + j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.println("pattern at : " + i);
                return true;
            }

            //2 CASES  : 
            if (j == 0) {     //If j is still at 0 means we couldnt find starting of pattern at current 'i' so i++
                i++; //HERE INNER ITERATION =0,ONLY OUTER ITERATION COUNTS
            }else{  //j khi bechme atak gaya , means we found match for some characters of pattern
                i = (i + j); // last i = 0,last j=3 -> i=0+3=3 -> we'll start matching from A(at index=3) in
            }   //IN else part -> HERE INNER ITERATIONS (suppose 3 inner j's) BALANCE OUTER ITERATIONS (we skip 3 outer i's)  

            //OVERALL COMPLEXITY -> O(N) -> linear 
        }
        return false;
    }
    private static void RabinKarpSol(String st,String pat){
        int a=1,b=2,c=3,d=4;
        int hashPat = 0;

        for(int i=0;i<pat.length();i++){
            hashPat = hashPat+pat.charAt(i);
        }

        for(int i=0;i<)


    }

    public static void main(String[] args) {

        boolean found = NaiveSol("this is java language", "java"); // O((n-m+1)*m) -> time, O(1) -> space
        System.out.println(found);

        found = BetterSol("abbbgabcde", "abcd"); //O(N) ->time // CASE WE CONSIDER HERE -> Pattern contains all distinct characters
        System.out.println(found); 
//EXPLANATION - (ABCABCD,ABCD): ABC of St == ABC of pattern but 'D' of pattern didnt match , so if we do i++ -> BC of st Obviously
// wont match with AB of pattern , So we skip the matched nos. in st to find next possible complete match


       found = RabinKarpSol("abbbgabcde","abcd");
       System.out.println(found);
    }

}
