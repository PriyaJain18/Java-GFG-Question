// largest sum contig. subarray : 

public class KadaneAlgo {
    public static void main(String[] args) {
        //naive sol -> O(N^2)

        int a[] = {-2,-3,4,-1,-2,1,5,-3 };
        int n = a.length;
        //Kadane's algo -> 
        int curSum = 0,maxSum = a[0];   //maxSum = a[0] as first element/all elements might me -ve

        for(int i=0;i<n;i++){
            curSum += a[i];
            if(curSum > maxSum){
                maxSum = curSum;
            }
            if(curSum < 0){ //gives -ve ans so discarding sum till current element 
                curSum = 0;
            }

        }
        System.out.println(maxSum);
    }
    
}
