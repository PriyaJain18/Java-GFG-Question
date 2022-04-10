import java.security.DrbgParameters.Reseed;

public class questions {
    private static void printNto1(int n){   //tail recursion: 
       //INTERNALLY considered as 'start' point
       //start : 
        if(n<1) return;
        System.out.print(n+" ");
        printNto1(n-1);             //INTERNAL CHANGES -> n = n-1; -> go to start;    //thus recursion doent happen Internally (properly)  
    //recursive call at end of func -> "tail recursive"  [when fun(0) returns control to fun(1) , fun(1) has nothing more to do {n thus immediately returns call back to fun(2)}] 
    }

    //in tail recursion -> compilers donot save state of current fun(parent) before calling next fun (child) as parent fun would have no operations 
    //to perform further , thus TAIL RECURSIONS take less time comparitively than non-tail recursion

    private static void print1ToN(int n){          //non tail recursion: 
        if(n == 0) return;
        print1ToN(n-1);              
        System.out.print(n+ " ");
    }
    /* above code for printing from 1 to n : //recursive call first then print :
        3
          -f(2)
            -f(1)
               -f(0)
                 -return 
               -1
            -2   
          -3
    */
    private static void print1ToNoptimized(int n,int k){       //tail recursion :
    //n -> total no.of times loop/recursion happens  , k-> start from 1 to n : printing purpose
        if(n==0) return;
        System.out.print(k+" ");
        print1ToNoptimized(n-1, k+1);     
    }
    private static int fact(int n){   //non-tail recursion : as fun-call is last thing in fact() but we need to do (last opertion:) *n before returning it 
        if(n==0 || n==1) return 1;
        return n*fact(n-1);        //5 * 4 * 3 * 2 * 1 
    }

    private static int factOptimized(int n,int k){
        if(n==0 || n==1) return k;  //when n==1 -> k= 5*1*4*3*2
        return factOptimized(n-1,n*k);      // [5*1]k * [4]n   similarly->   * 3 * 2 

    }

    private static int fibonnaci(int n){
        if(n==0) return 0;
        if(n==1) return 1;                //f(1) -> f(0)=0 + f(-1)
        // 0,1,1,2,3,5,8,13
        return(fibonnaci(n-2)+fibonnaci(n-1));
    }
    
    private static int naturalNosSum(int n){
        if(n == 0) return 0;
        return n + naturalNosSum(n-1);
    }

    private static boolean palindromeCheck1(String str,int start,int end){ //pass 0 in start and n-1 in end 
        if(start>=end) return true;
        if(str.charAt(start) != str.charAt(end)) return false;  //example chars at : 0,5[same] -> 1,4[same] -> 2,3[not-same]==false
        return palindromeCheck1(str,start+1,end-1);
    }

    private static boolean palindromeCheck2(String str,int start,int end){ //pass 0 in start and n-1 in end 
        if(start>=end) return true;
        //LOGIC:  chars at : { 0,5[same] ,pal(1,4) } -> { 1,4[same] , pal(2,3)} -> {2,3[not-same]==false && pal(3,2)==true}
        return (str.charAt(start) == str.charAt(end)) && palindromeCheck2(str,start+1,end-1);   //&& follows SHORT CIRCUITING -> if condition-1 [before &&] is false -> return it w/o checking condition-2
    }

    private static int sumOfDigits(int n){
        if(n<=9) return n; //when single digit left return that digit AND when whole no. finishes/becomes 0 return 0
        return (n%10+ sumOfDigits(n/10));     // 123 -> {123 se}3+{12 se}2 +{1 se}1 + no digit [{0}returns 0]
    }
    public static void main(String[] args) {
        // printNto1(5);//O(n) space/reccursion stacks  //T(n) = T(n+1) + O(1)    => means total time complex. = n+1[+1 as fun(0) to check] function calls and 1 as each function does O(1) work
        // //tail call elimination -> O(1) space instead of O(N)
        // System.out.println();
        // print1ToN(5);
        // System.out.println();
        // print1ToNoptimized(5, 1);

        //factorial : 
        // fact(5);
        // factOptimized(5,1);
        
        int f = fibonnaci(3);
        System.out.println(f);

        //sum of 1st n natural nos: 
        int sum = naturalNosSum(5); //1+2+3+4+5 = 15    //Theta(n)  => as T(n) = T(n-1) + theta(1)    , space -> theta(n)
        System.out.println(sum);

        //below methods are just written in diff.way ,LOGIC is SAME: //T(n) =T(n-2)+theta(1),space -> n/2 recursive stacks/calls -> Theta(N)
        boolean isPalindrome = palindromeCheck1("aba",0,2);
        System.out.println(isPalindrome);
        isPalindrome = palindromeCheck2("aba",0,2);
        System.out.println(isPalindrome);

        int sum1 = sumOfDigits(52131);     //sum = 6
        System.out.println(sum1);

    }
    
}

 //tail call elimination : optimization  technizque used by modern compilers ,for tail-recursion which is faster than non-tail recursion
//quicksort(tail recursion) is faster than merge sort(non-tail recursion)
//inorder, perorder -> tail  ,postorder -> non-tail