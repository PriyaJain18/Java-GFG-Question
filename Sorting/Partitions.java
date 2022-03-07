import java.util.Arrays;

public class Partitions {
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static int NaivePartition(int[] arr,int l,int r,int pivotIndex){
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;
        for(int i=l;i<=r;i++){ 
            if(arr[i] < arr[pivotIndex]){
                temp[index] = arr[i];
                index++;
            }
        }
        for(int i=l;i<=r;i++){ 
            if(arr[i] == arr[pivotIndex]){
                temp[index] = arr[i];
                index++;
            }
        }
        int lastOccurence = l + index - 1;
        for(int i=l;i<=r;i++){ 
            if(arr[i] > arr[pivotIndex]){
                temp[index] = arr[i];
                index++;
            }
        }
        //Final step: putting arranged array temp in the original array arr : 
        for(int i=l;i<=r;i++){ 
            arr[i] = temp[i-l];   //WHY i-l ????? 
        }
        return lastOccurence;
        
    }
    public static int LomutoPartition(int[] arr,int l,int r){
        int pivotElement = arr[r]; 
        int i= l-1; //i = denotes window of smaller (than pivotElement) elements 
        for(int j=l;j<=r-1;j++){          //not going till r(=arr.length-1) index as we consider it the pivotIndex by default 
            if(arr[j] < pivotElement){
                i++;
                //swap(arr[i],arr[j]) : 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    //as last smaller element than pivotElement is stored at 'i' , our pivotElement should be after i -> 'i+1' <- before larger elements 
       // swap(arr[i+1],arr[r]) :     //now pivotElement is at it's correct position (accor to a sorted array)
       int temp1 = arr[i+1];
       arr[i+1] = arr[r];
       arr[r] = temp1;
       
       return (i+1);             //returning index of pivotElement
    }
    
    public static void main(String[] args) {
    
    // Partition: a pivot index is given as input -> output the last occurence of the element at the pivot index after sorting array 

        int[] arr = { 4,5,16,5,3,12,8,5};  
       
        //Naive Partition : O(n) && O(n) //4,3,4, 5,5 ,16,12,8 -> LHS AND RHS of PivotIndex's element's value is arranged acco to original array 
        int lastOccurence = NaivePartition(arr, 0, arr.length-1 , 7);
        System.out.println(Arrays.toString(arr));
        System.out.println(lastOccurence);

        int[] arr1 = { 4,5,16,5,3,12,8,5};  

        //Lomuto Partition : O(n)= time [1-time-array-traversal] & O(1) = Space complxity  : 
        int firstOccurence = LomutoPartition(arr1, 0, arr.length-1);    //standard algo works for pivot index = last index of array 
        System.out.println(firstOccurence);

        //Hoare's sort :         //////////////////////////////////

    }
    
}

/* 

# PARTITIONS : 

Naive : not inplace and stable
Lumuto and Hoarse : inplace [Requires space for recursion call stack not array] and unstable and

# QUICK SORT  :
void qSort(int[] arr,int l,int h){
    if(l<h){
        int p = Partition(arr,l,h); //partition here is Lumuto or Hoare
        qSort(arr, l, p);
        qSort(arr, p+1, h);

    }
}

TIME => best case : CnLog(n) + theta(n) = Cn Logn(N) ;  Avg case: nLogn ;  worst case : n^2 
SPACE => best case : theta(Log n) , worst case : theta(n)

*/