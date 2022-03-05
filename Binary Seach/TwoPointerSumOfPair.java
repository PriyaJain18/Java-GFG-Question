import java.util.Arrays;

public class TwoPointerSumOfPair {
    static boolean sumPair(int[] arr,int left, int right, int sum){
        boolean pairExists = false;
        while(left<=right){
            if(arr[left]+arr[right] == sum){
                pairExists = true;
                System.out.print(arr[left]+" "+arr[right]);
                return pairExists;
            } 
            else if(arr[left]+arr[right] < sum){
                left++;
            }
            else{
                right--; 
            }
            
        }
            return pairExists;
    } 
    static boolean tripletSum(int arr[],int sum){
        boolean tripletExists = false;
        for(int i=0;i<arr.length;i++){
            boolean pairExists = sumPair(arr, i+1, arr.length-1,(sum-arr[i]));
            if(pairExists){
                System.out.print(" "+arr[i]);
                tripletExists = true;
                return tripletExists;
            }           
        }
        return tripletExists;

    }
    public static void main(String[] args) {
        int[] arr ={ 2,4,7,8,9,11,12,20,30};
        int n =arr.length;

        //find pair with required sum from array :  
        boolean pairExists = sumPair(arr,0,n-1,16);   //O(N)
        System.out.println();
        if(pairExists){
            System.out.println("Such Pair exists");
        }else{
            System.out.println("Such pair doesnot exists");
        }
        //find triplet with required sum from array :  //O(N)*O(N) = O(N^2)
        boolean tripletExists = tripletSum(arr,10);            //GIVES WRONG ANSWER
        System.out.println();
        if(tripletExists){
            System.out.println("Such triplet exists");
        }else{
            System.out.println("Such triplets doesnt exist");
        }
    }
    
}
// unsorted array - pair -> prefer hashing 
// Sorted array - pair -> prefer 2-pointer algo
// Unsorted/sorted array -triplet -> prefer 2-pointer algo  