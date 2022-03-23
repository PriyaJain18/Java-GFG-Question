// package subarrayQues;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;

public class subarrayQues {

    public static boolean subarrayWithSum0(int[] arr){
        //naive: 2 loops -> O(n^2)
        //Better Approach : Prefix sum and hashing : logic : if index 0+1 = 0+1+2+3+4 means -> 2+3+4 will give sum=0
        int n = arr.length;
        HashSet<Integer> hashset = new HashSet<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(hashset.isEmpty()){
                hashset.add(arr[i]);   
            }
            if(hashset.contains(sum)){ //subarray with 0 sum exists
                return true;                   
            }else{
                hashset.add(sum);
            }
        }
        
        return false;

    }

    public static boolean subarrayWithSum(int[] arr,int sum){
        int n = arr.length;
        int largePresum = 0;
        HashSet<Integer> hashset = new HashSet<>();

        for(int i=0;i<n;i++){
            largePresum += arr[i];
            
            if(hashset.isEmpty()){
                hashset.add(arr[i]);
                if(largePresum == sum){
                    return true;
                }
                continue;
            }
            if(largePresum == sum){ //I.e. no smallPresum     //CORNER CASE 
                return true;        //the whole current LargePresum array equals requiredSum array
            }
            if(hashset.contains(largePresum-sum)){        //subarray found !
                return true;
            }else{
                hashset.add(largePresum);
            }

        }
        return false;
    }

    public static ArrayList<Integer> returningSubarrayWithSum0(int[] arr){
       
        //naive: 2 loops -> O(n^2)
        //Better Approach : Prefix sum and hashing : logic : if index 0+1 = 0+1+2+3+4 means -> 2+3+4 will give sum=0
        int n = arr.length;
        boolean pairFound = false;
        HashMap<Integer,Integer> hashmap = new HashMap<>(); //sumTillValue,index
        HashSet<Integer> hashset = new HashSet<>();
        int sum = 0;
        int indexCount = 0;
        
        ArrayList<Integer> subarray = new ArrayList<>();
        for(int i=0;i<n;i++){
            
            sum += arr[i];
            if(hashset.contains(sum)){ //subarray with 0 sum exists
                pairFound = true;            
                // int index = hashmap.get(sum);  
             
                for(int j=0;j<=(hashmap.get(sum));j++){
                    subarray.add(arr[j]);
                }

                return subarray;
                
            }else{
                hashset.add(sum);
            }

            if(hashset.isEmpty()){
                hashset.add(arr[i]);   
            }
            hashmap.put(sum,indexCount);        //atlast taki current sum ke value/index etc check krna ho hashmap me to vo mil jae
            indexCount++;
        }
        
        pairFound = false;
        return subarray;

    }

    public static int naiveSubsq(int[] arr){
        int n = arr.length;

        Arrays.sort(arr);
        System.out.println("sorted array : "+ Arrays.toString(arr));
        int len= 1,res = 1;
        for(int i=1;i<n;i++){
            //1 2 3 3 4 5 
            if(arr[i] == (arr[i-1]+1)){
                len++;      
            }else if(!(arr[i] == (arr[i-1]+1))) {
                res = Math.max(len,res); 
                len = 1;
            }
        }
        return Math.max(res, len);  //because maybe at last vo else part me gaya hi nhi ,so res still contains older value 
    }
    public static int longestSubarr(int[] arr,int sum){
        int largerPresum = 0;
        int len = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            largerPresum += arr[i];
            //case when key/largePresum repeats itself : we will not replace it with newer key , as it would make the sum's subarray smaller in length
            //and accor to ques we require to find largest subarray : 
            
            if(hashmap.containsKey(largerPresum)){
                continue;
            }
            //corner case : 
            if(largerPresum == sum){
                len = i+1;
            }

            if(hashmap.isEmpty()){
                hashmap.put(arr[i], i);
            }
            if(hashmap.containsKey(largerPresum - sum)){  //subarray exist 
                len = Math.max((i-hashmap.get(largerPresum-sum)),len);
            }else{
                hashmap.put(largerPresum, i);    
            }
           
           
        }
        return len;
    }

    public static int longestSubarrSum0(int[] arr){
        HashMap<Integer,Integer> hashmap = new HashMap<>();       //1-largePresum , 2-index of largePresum's current element
        int largePresum = 0,len=0;
        int n =arr.length;

        for(int i=0;i<n;i++){
            largePresum += arr[i];
            if(largePresum == 0){  //case 1 : abhi tal ka total=0 //if current element has sum=0 that means the largest length with sum=0 
                len = i+1;
            }else{

                //case 2: beechme kahi ka total=0 ;i.e. smallPresum == largePresum so bech wale subarray ka sum==0
                if(hashmap.get(largePresum)!=null){      //i.e. index for such largePresum exist in hash already 
                    len = Math.max(len,i-(hashmap.get(largePresum)));

                }else{  //case 3: largePresum is nither present in hash already nor it is = 0, so we must add it in hash for future iterations : 
                    hashmap.put(largePresum, i);
                }
            }

        }
        return len;
    }
    public static int subarrayWith0And1(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                arr[i] = -1;    //replacing 0 with -1
            }
        } 
        System.out.println("converted arr : "+ Arrays.toString(arr));
        int len = longestSubarrSum0(arr);
        return len;
    }

    public static int longestCommonSpan(int[] arr1,int[] arr2){
        int m = arr1.length; 
        int n = arr2.length;
        if(m!=n){
            System.out.println("Error : Enter equal sized arrays !");
            return 0;              //conditions not meeting!! Use different array
        }

        int[] temp = new int[m];
        for(int i=0;i<m;i++){
            temp[i] = arr1[i] - arr2[i]; //all possible elements in temp from -> {0,1,-1}
        }
        System.out.println("temp array : " +Arrays.toString(temp));
        int len = longestSubarrSum0(temp);
        return len;
    }
    public static int BetterSubsqSol(int[] arr){    // {1,9,3,5,7,8,6,2,3}; 
        int n =arr.length;
      
        HashSet<Integer> hashset = new HashSet<>();
        for(int ele : arr){
            hashset.add(ele);
        }
        System.out.println(hashset);
        int res=0;

        for(int e : arr){
            if(!(hashset.contains(e-1))){
                int curNum = e;
                int len = 1;
                while(hashset.contains(e+len)){
                    curNum++;
                    len++;
                }
                res = Math.max(len,res);
            } //else -> Ignore current element and continue next iteration
        }
        return res;
    }
    

    public static ArrayList<HashSet<Integer>> distinctInWindows(int[] arr,int k){    //k = windowSize here
        int n = arr.length;
        ArrayList<HashSet<Integer>> windowList = new ArrayList<>(); 

        // { 10,10,5,3,20,5,30,20};  -> 3 windows 6-4+1

        //[]
        // [ <hashset> ,<> ,<> ]
        HashSet<Integer> hashset;
        int counter = 0;
        for(int i=0;i<(n-k+1);i++){   //windows  //1
            counter = i;  //3
            hashset = new HashSet<>(); 
            while(counter<k+i){  //n-1<k
                // if(counter>n-1){ //counter end of array pr hai 
                //     break;
                // }else{
                    hashset.add(arr[counter]);
                    counter++;    //n-1         
                // }
            }
            windowList.add(hashset);
            // if(counter > n-1){
            //     break;
            // }
        }
        return windowList;
    }
    

    // public static ArrayList<Integer> distinctInWindowsOptimized(int[] arr,int k){  //k =windowSize
    // }

    public static void moreOcurrences(int[] arr,int k){
        int n = arr.length;
        int occurence = (int)(n/k);

        HashMap<Integer,Integer> hashmap = new HashMap<>(); //1->element ,2-> freq.
        for(int i=0;i<n;i++){
            hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0)+1);
        }
        System.out.println("occurences with more than " + n+"/"+k+ " => " );
        for (Map.Entry<Integer,Integer> element : hashmap.entrySet()){
            if(element.getValue() > occurence){
                System.out.print(element.getKey() +" = "+element.getValue()+" times. ");
            }
        }

    } 
    public static void main(String[] args) {

        int arr[] = {-3,5,-3,-1,5,9,-3,-5};
        int[] arr1 = {2,-1,-1,3,4,6,-5,-1};
        
        //Q : Subarray with sum=0 exists or not : 
        boolean subarrayExists = subarrayWithSum0(arr); // LOGIC-> if index 0+1 = 0+1+2+3+4 means -> 2+3+4 will give sum=0
        System.out.println(subarrayExists);

        //q : Subarray withgiven sum exists or not : 
        subarrayExists = subarrayWithSum(arr,9);   //O[N] -> time and space 
        System.out.println(subarrayExists);

        //Q : All subarrays with 0 sum :  //@@@@@@@@@@@@@@@@@@
        // ArrayList<Integer> subarray = returningSubarrayWithSum0(arr);
        // System.out.println(subarray);
       
        //Q : All subarrays with given sum :  //@@@@@@@@@@@@@@@@@@
        // System.out.println(returningSubarrayWithGivenSum(arr,9));
        
        //Q :Longest Subarray with given sum :
        int[] arr2 = {8,3,1,5,-6,6,2,2};
        int l = longestSubarr(arr2,4); //logic -> largerPresum - sumRequired = SmallerPresum-> we store LargerPresum's value and it's last element(curremt elemenet) in hashmap
        System.out.println(l);

        //Q : Longest subarray with given sum=0 : 
        int[] arr22 = { 1,-1,1,1,1,-1,-1,1,-1}; //10
        l = longestSubarrSum0(arr22);
        System.out.println("longest subarray with sum 0 : "+l);

        //Q : Longest subarray with equal 0's and 1's : (1)replace o with -1  (2)Find longest subarray with sum=0
        int[] arr3 = { 1,0,0,1,1,1,1,0,0,1,0};
        l = subarrayWith0And1(arr3);  
        System.out.println("Longest subarray with 0 and 1 :"+  l);  

        //Q : Longest common span (subarrays) with same sum in 2 arrays : (1)arr1-arr2 => tempArr (2)Find Longest subarray with sum=0 as [ -1 ]or [ 1 ] in tempArr mean [0 in arr1,1 in arr2] or [1 in arr1,0 in arr2] respectively

        //note: arrays should be of equal size, returns span of len with same indexes , i.e. index[1-4] from arr4 & arr5 also.
        int[] arr4 = {1,0,1,0,1,0,0,1,1};
        int[] arr5 = {0,0,1,1,1,1,0,0,0};
        //temp ->     1,0,0,-1,0,-1,0,1,1
        int span = longestCommonSpan(arr4,arr5);  //answer= 8
        System.out.println("longest common span from both arrays : "+span);

        //Q : Longest consecutive subsequence in array  : ex {1,9,3,4,2,20} -> here subsequence of form x,x+1,x+2... is 1,3,4,2 -> appearing in any order is also applicable 
  
        //Naive sol -> sorting 
        int[] arr6 = {1,9,3,5,4,7,8,6,2,3}; 
        int lengthOfSubseq = naiveSubsq(arr6);  //O(n logN)
        System.out.println(lengthOfSubseq);
        
        lengthOfSubseq = BetterSubsqSol(arr6);  //O(N)-> space and time
        //LOGIC: 3-> if(3-1)is not-present in hashtable,then 3 is 1st element for the subsequence,then we check for all -> 3+len with len++ to check when this subseq. end
        System.out.println(lengthOfSubseq);   //@@@@@DONOT HANDLES DUPLICATE ELEMENTS ???

        //NOTE: in BetterSubsqSol() -> No. of Lookups  = 2*(No. of elements in hashtable/hashset)

        //Q : Count distinct elements in every window size (windowLength = k ,no. of such windows = n-k+1)

        int[] arr7 = { 10,10,5,3,20,5}; //-> 3 -> n-k+1
        int windowSize = 4;
        ArrayList<HashSet<Integer>> distinctElements =  distinctInWindows(arr7,windowSize); //O((n-k+1)*k)
        System.out.println("distinctElements per window : "+ distinctElements);

        // ArrayList<Integer> mapSizeCount = distinctInWindowsOptimized(arr7, windowSize); //@@@@@@@@@@@@@@@ LEFT 
        // System.out.println("distinctElements per window :"+ mapSizeCount); 
        //O(N) -> time , O(K)-> space as a frequency map can be of max-k size (when all elements are distinct)

        //Q : More than n/k Occurences

        //Naive sol -> sort O(NlogN) then count for each element O(N)-> if >n/k -> print =>Overall time-> O(NlogN)
        int[] arr8 = {30,30,10,10,10,30,40,40};  //n=8
        moreOcurrences(arr8,4);  //k =4         O(N)-> Time 
        // System.out.println(arry);  //n/k = 8/4= 2 => O/P -> elements which occur 2+ times

        //Q : LAST QUES@@@@@@@@@@@@
     }
    
}
