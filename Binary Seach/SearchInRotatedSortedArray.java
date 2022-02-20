
//  40 50 70 100 120 20 30      
//  80 90 100 40 50 60 70 

/**
 * SearchInRotatedSortedArray
 */
public class SearchInRotatedSortedArray {
    static int searchEle(int[] arr, int num){
        int low=0,high=arr.length-1;
        int elementindex = -1;
        while(low<=high){
            int mid= (low+high)/2;
            if (arr[mid] == num) {
                elementindex = mid;
                return elementindex;
            }
            if(arr[low] < arr[mid]){ //left half sorted
                if(num<arr[mid] && num>=arr[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{  //rigyht half sorted
                if(num>arr[mid] && num<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return elementindex; //returning -1 as element not found 


    }
    public static void main(String[] args) {
        
        int[] arr1 = {40, 50,70,100,120,20,30,35,38};
        int[] arr2 = {80,90,98,100,40,45,50,60,70,73,77};

        System.out.println(searchEle(arr1,55));  //sorted side 
        System.out.println(searchEle(arr1,20)); //unsorted side 
        System.out.println(searchEle(arr2,73)); //unsorted side 
        System.out.println(searchEle(arr2,60)); //unsorted side 
    }
}