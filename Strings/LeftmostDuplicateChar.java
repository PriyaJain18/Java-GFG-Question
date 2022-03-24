import java.util.Arrays;

public class LeftmostDuplicateChar {
    private static int NaiveSol(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j)){
                    return i;
                }
            }
        }
        return -1;
            
    }
    private static int BetterSol(String str){
        int[] fIndex = new int[256];

        Arrays.fill(fIndex, -1); //filling array with indexes as characters with -1 
        int res = Integer.MAX_VALUE;

        for(int i=0;i<str.length();i++){
            if(fIndex[str.charAt(i)] == -1){
                fIndex[str.charAt(i)] = i;        //adding string-indexes of the characters in the respective fIndex's indexes 
            }else{
                res = Math.min(res, fIndex[str.charAt(i)]);    //res contains first occurence of every repeated element and gets min of it; as min index means the leftmost index wala elment
            }
        }
        return (res == Integer.MAX_VALUE ) ? -1 : res;

    }
    private static int BestSol(String str){

        boolean[] isVisited = new boolean[256];
       // Arrays.fill(isVisited,false); -> no need as "Default value of the boolean array is false"
        int res = -1;
        
        for(int i=str.length()-1;i>=0;i--){
            if(isVisited[str.charAt(i)]){    //= true i.e. visited hai already 
                res = i;  //as we are moving from right to left, so current wala phle wale res se already min hi hoga ,so no need for Min  function
            }else{ //first occurence from RHS
                isVisited[str.charAt(i)] = true; 
            }
        }
        return res; //if no duplicates exist -> res remains -1 
    }

    public static int BetterNonDup(String str){  //previousCount+1 -> for every repitition
        int[] isVisited = new int[256];
        Arrays.fill(isVisited,0);

        int res = 0; //index 0 of isVisited

        for(int i=0;i<str.length();i++){  //traversal through str length
            isVisited[str.charAt(i)]++; 
        }
        while(res < str.length()){  //traversal of res through str length
            if((res == str.length()-1) && (str.charAt(res)!=1)){
                return -1;
            }
            if(isVisited[str.charAt(res)] != 1){
                res++;
            }else{
                return res;
            }
        } 
        return res;
    }

  public static int BestNonDup(String str){  //-1 -> notvisited , -2 -> duplicate ,no. >=0 -> index of its first & only occurence till now
        int[] isVisited = new int[256];
        Arrays.fill(isVisited,-1);

        for(int i=0;i<str.length();i++){   //traversal througyh str length
            if(isVisited[str.charAt(i)] == -1){
                isVisited[str.charAt(i)] = i;      
            }else{    //when any positive-str-index is present already 
                isVisited[str.charAt(i)] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){ //traversing isVisited[256] from LHS to RHS ,Considering minimum(leftmost index) of the ones containing index values >=0
            if(isVisited[i] >=0 ){
                res = Math.min(res,isVisited[i]);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
    public static void main(String[] args) {
        String str = "kslsrkgrg";

        //LEFT MOST DUPLICATE CHAR :  k -> 0 index
        int index = NaiveSol(str); //return index 0 for 'g'  // O(n^2) -> time //logic: 2 loop and return if duplicate for leftmost found
        System.out.println(index);

        index = BetterSol(str);  //O(N+CHAR) -> time , O(CHAR) -> Space
        System.out.println(index);

        index = BestSol(str);  //logic -> traverse from back to front and mark as visited/true for characters we have visited in boolean array  
        System.out.println(index); //O(N+CHAR) -> time , O(CHAR) -> Space

        //  LEFT MOST NON-DUPLICATE CHAR : f -> 2 index

        // NaiveNonDuplicate(str); -> O(n^2)
        index = BetterNonDup(str);   //O(N)-> time , O(256)           -> TWO TRAVERSAL (of string)
        System.out.println(index);
        index = BestNonDup(str);     //O(N)-> time , O(256)           -> ONE TRAVERSAL (of string)
        System.out.println(index);

        
    }
    
}
