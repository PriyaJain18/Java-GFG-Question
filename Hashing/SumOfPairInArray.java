import java.util.HashMap;
import java.util.HashSet;

public class SumOfPairInArray {
    public static boolean SumOfPairExists(int[] arr,int sumRequired){
        int n = arr.length;
        HashSet<Integer> hashset = new HashSet<>();
        boolean pairFound = false;
        for(int i=0;i<n;i++){
            if(hashset.isEmpty()){
                hashset.add(arr[i]);
            }
            if(!(hashset.contains(sumRequired-arr[i]))){
                hashset.add(arr[i]);
            }else{
                pairFound = true;
                return pairFound;
            }
        }
        return false;
    }
    //  ->

    public static int CountPairs(int[] arr,int sum){
        int n = arr.length;
        int pairCount = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hashmap.isEmpty()){
                hashmap.put(arr[i],null);
            }
            if(!(hashmap.containsKey(sum-arr[i]))){
                hashmap.put(arr[i],null);
            }else{    //contains sum-arr[i]
                System.out.println( arr[i] +" - "+ (sum-arr[i]));
                hashmap.remove(arr[i]);
                pairCount++;
            }
        }
        return pairCount;
    }
    public static void main(String[] args) {
    //Naive  : traverse array while checking pair with every element in RHS ..[2-loops]
    //Better approach : 2 pointer approach 
    //Best Approach : Hashing : we will add arr[i] in hashset if sum-arr[i] is not already present in hashset; so that next time if a sum-arr[i] is present means they make the pair required !
        int[] arr = { 2,4,5,9,3,1,7,6};
        
        boolean containsPair = SumOfPairExists(arr,11);
        System.out.println(containsPair);    

        int pairs = CountPairs(arr,11);
        System.out.println(pairs+ " pairs exist with sum "+11);
        
    }
}