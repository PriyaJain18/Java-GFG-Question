/* QUESTION :
[ 5,10,20,15,7,8,6 ] ->UNSORTED ARRAY-> we need to find any one peak element in this array , Peak element's index = x such that arr[x-1] < arr[x] > arr[x+1]
For this ,logic : if mid is peak i.e. mid-1<mid>mid+1 -> ans 
                    if mid-1>mid -> then its LEFT Half array WILL HAVE a peak definitely  [cant comment abt RIGHT]
                    if mid< mid+1 -> then RIGHT HALF array will have a peak definitely [cant comment abt LEFT]
*/

public class returnAnyPeakElement {
    static int getPeak(int[] arr){
        if (arr.length == 1){
            return arr[0];
        }else if(arr.length == 2){
            if(arr[0]>arr[1]){
                return arr[0];
            }else{
                return arr[1];
            }
        }else if(arr.length == 3){  
            if(arr[1]>arr[0] && arr[1]>arr[2]){
                return arr[1];
            }else if(arr[0]>arr[1]){
                return arr[0];
            }else{
                return arr[2];
            }

        }else{ //length of arr is >3
            int low=0,high =arr.length-1;
            int n =arr.length;
            while(low<=high){
                int mid=(high+low)/2;
                if(((mid==0) || (arr[mid-1]<=arr[mid])) && ((arr[mid]>=arr[mid+1]) || (mid == n-1))){
                    return arr[mid];
                }else if((arr[mid] < arr[mid-1]) && (mid>0)){       //RHS SIDE MUST CONTAIN A PEAK ELEMENT 
                    high = mid-1;
                }else if((arr[mid]<arr[mid+1]) && (mid<n-1)){           //LHS SIDE MUST CONTAIN A PEAK ELEMENT
                    low = mid+1;
                }

            }
            return -1; //there's always a peak element thus would never return this 

        }

    }
    public static void main(String[] args) {
        int arr[] = {5,10,20,15,7,8,6};  //as 20>15(mid) -> searching firstly in the LEFT array [note : right array also contains peak(8) here]
        // int arr[] = {2,4,0};
        System.out.println(getPeak(arr)); //returns any 1 Peak element 
    }
    
}

