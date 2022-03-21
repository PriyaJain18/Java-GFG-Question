import java.util.Arrays;

 //MERGE SORT : Divide (and sort individual parts) and Conquer (i.e. Merge)

class MergeSort{
    int[] arr; 
    void merge(int[] arr,int l,int m,int r){
        int n1= m-l+1;
        int n2= r-m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
         
        /*Copy data to temp arrays*/
        for(int i=0;i<n1;++i){
            L[i] = arr[l+i];
        }
        for(int j=0;j<n2;++j){
            R[j] = arr[m+j+1];
        }

        int k = l; //for inserting sorted elements to original array 
        int i=0,j=0;  //for subarrays 

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
                k++;
            }else{
                arr[k] = R[j];
                j++;
                k++;
            }

        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int[] arr,int l,int r){
        if(l<r){
            int m = l+(r-l)/2;    //equilaent to m=(l+r)/2  but protects overflows 
            // Sort first and second halves :
            sort(arr, l, m);
            sort(arr , m+1, r);
            // Merge the sorted halves :
            merge(arr, l, m, r);  
        }

    }
    

} 

public class Sorting_Algos_and_Operations_On_Arrays {

    public static int[] BubbleSort(int[] arr) { // largest element at end/RHS
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // no. of passes
            for (int j = 0; j < n - 1 - i; j++) { // till (n-1) normally (-i) as for i-th pass 'i' elements are already
                                                  // fixed at end
                if (arr[j + 1] < arr[j]) {
                    int temp;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] optimizedBubbleSort(int[] arr) { // largest element at end/RHS
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) { // no. of passes
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) { // till (n-1) normally (-i) as for i-th pass 'i' elements are already
                                                  // fixed at end

                if (arr[j + 1] < arr[j]) {
                    swapped = true;
                    int temp;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (swapped == false) {
                break; // out of outer-for-loop as we know the array is already sorted (as no swapping
                       // in the lastest pass took place)
            }
        }
        return arr;
    }

    public static int[] SelectionSort(int[] arr) {
        int min, minIndex, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // swapping min-th and i-th position elements :
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static int[] InsertionSort(int[] arr) { // LHS =Sorted , RHS = Unsorted ; method: move elements from RHS to
                                                   // LHS
        int n = arr.length;
        for (int i = 1; i < n; i++) { // started from i=1 as LHS should be "Sorted part" which initially has 1 element
                                      // i.e. i=0
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // shifting element-data forward ( towards RHS)
                j--;
            } // finishes by reaching at 10 in sorted-array 10 20 30 where we need to INSERT
              // 15
            arr[j + 1] = key;
        }
        return arr;
    }

    //MERGING 2 SORTED ARRAYS INTO 1 SORTED ARRAY :  
    public static int[] Merging(int[] a,int[] b) {
        int n1 = a.length;
        int n2 = b.length;  
        int i= 0, j=0;
        int[] c = new int[n1+n2];
        int k=0;
        
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){       //here = sign ensures stable sorting(i.e. original order of placement of same elements) 
                c[k] = a[i];
                i++;
                k++;
            }else{
                c[k] = b[j];
                j++;
                k++;
            }
        }
        while(i<n1){  //means array b of size n2 reached the end already 
                c[k] = a[i];
                i++;
                k++;
        }
        while(j<n2){  //means array a of size n1 reached the end already 
                c[k] = b[j];
                j++;
                k++;
        }
        
        return c;   //at this point array c gets full 
    }
    public static void intersectionArr(int[] a,int[] b){
        int m = a.length;
        int n = b.length;
        int i=0,j=0;

        while(i<m && j<n){
            //passing through duplicacy :
            if(i>0 && a[i] == a[i-1]){
                i++;
                continue;   //leave current iteration and continue from next iteration
            }
            if(j>0 && b[j] == b[j-1]){
                j++;
                continue;   //leave current iteration and continue from next iteration
            }

            if(a[i]<b[j]){ i++; }
            else if(a[i]>b[j]){ j++; }
            else{
                System.out.print(a[i]+ " ");
                i++;
                j++;
            }

        }
    }
    public static void unionArr(int[] a,int[] b){
        int m=a.length;
        int n=b.length;
        int i=0,j=0;
        while(i<m && j<n){
            //passing through duplicacy :
            if(i>0 && a[i] == a[i-1]){
                i++;
                continue;   //leave current iteration and continue from next iteration
            }
            if(j>0 && b[j] == b[j-1]){
                j++;
                continue;   //leave current iteration and continue from next iteration
            }

            //printing non-duplicates in sorted order : 
            if(a[i]<b[j]){
                System.out.print(a[i]+ " ");
                i++;
            }else if(a[i]>b[j]){
                System.out.print(b[j]+ " ");
                j++;
            }else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
            
        }
        while(i<m){
            //printing if no duplicacy :
            if(i>0 && a[i] != a[i-1]){
                System.out.print(a[i]+ " ");
                i++;
            }
            i++;  //when a[i] == a[i-1]
        }
        while(j<n){
            //printing if no duplicacy :
            if(j>0 && b[j] != b[j-1]){
                System.out.print(b[j]+ " ");
                j++;
            }
            j++;    //when b[j] == b[j-1]
        }

    }
    
    public static int Inversions(int[] a,int[] b){
        int m = a.length;
        int n = b.length;
        int i=0,j=0,count=0;
        
        while(i<m && j<n){
            if(a[i]<=b[j]){
                i++;

            }else{
                count = count + (m-i);
                j++;
            }
        }
        return count;
        
    }


    //INVERSIONS IN AN ARRAY  : 


    public static int countAndMerge(int[] arr,int l,int m,int r){         //3rd case 
        int n1 = m+1-l;
        int n2 = r-m;

        int L[] = new int[n1], R[] = new int[n2]; //diving one array into two halves 
        //assigning data to both subarrays : 
        for(int t=0;t<n1;t++){ L[t] = arr[l+t]; }
        for(int t=0;t<n1;t++){ R[t] = arr[m+1+t]; }
        
        int count=0,i=0,j=0,k=0;     //note : merging is not necessary after counting bigger no from LHS and smaller from RHS
        int totalElements = arr.length;
        int ar[] = new int[totalElements];
        while(i<n1 && j<n2){

            if(L[i]<=R[j]){
                ar[k] = L[i];
                i++;
            }else{
                ar[k] = R[j];
                count += (n1-i);
                j++;
            }
            k++;
        }
        while(i<n1){
            ar[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            ar[k] = R[j];
            j++;
            k++;
        }
        return count;

    }
    public static int InversionCount(int[] arr,int l,int r){
        int count = 0;
        while(l < r){
            int m = l + (r-l)/2;
            count += InversionCount(arr, l, m);
            count += InversionCount(arr, m+1, r);
            count += countAndMerge(arr,l,m,r);
        }
        return count;
        
    }


    public static void main(String[] args) {

        // int[] arr = { 30,10,20,15,5,27,17};

        // int[] sortedArr = BubbleSort(arr); //Bubble Sort O(n^2) : STABLE
        // System.out.println(Arrays.toString(sortedArr));

        // int[] sortedArr1 = optimizedBubbleSort(arr);
        // System.out.println(Arrays.toString(sortedArr1));

        // int[] sortedArr2 = SelectionSort(arr); //Selection sort O(n^2) : Unstable,
        // requires less memory Writes , Inplace
        // System.out.println(Arrays.toString(sortedArr2));

        // int[] sortedArr3 = InsertionSort(arr); //Insertion Sort(O(n^2) ; best case:
        // O(n)) : stable,inplace ,used For small arrays
        // System.out.println(Arrays.toString(sortedArr3));

        // int[] a = { 10, 20, 22, 25, 40 };
        // int[] b = { 5, 15, 22, 30, 50, 60 };
        // int[] sortedArr4 = Merging(a, b);
         
        //Intersection of 2 sorted arrays : 
        // int[] a = { 10, 20, 20, 22, 30 ,30};
        // int[] b = { 5, 10 ,10, 15 ,15 , 20, 30, 50 };
        // System.out.println("intersection of 2 ARRAYS :");
        // intersectionArr(a,b);

        //Union of 2 sorted arrays :   5,10,20,15,30,50,70    => O(m+n) -> time, O(1) -> space 
        // int[] a = { 10, 20, 20, 30,70,70};
        // int[] b = { 5, 10 ,10, 15,50 };
        // System.out.println("union of 2 ARRAYS :");
        // unionArr(a,b);

        // Merge Sort :O(n log n) -time ,O(n) -space;stable ;used in external sorting; good for LL (O(1):space complexity)
        // int[] arrNew = {10, 5, 20, 22, 60, 80, 25, 22};
        // MergeSort o1 = new MergeSort();
        // o1.sort(arrNew,0,arrNew.length-1);  
        // System.out.println(Arrays.toString(arrNew));

        //COUNTING NO. OF INVERSIONS comparing 2 arrays  : (bigger no. in A[] and smaller nos. in B[])
        // int[] a = { 2, 5,8,11};
        // int[] b = { 3,6,9,13};
        // int inv = Inversions(a,b);
        // System.out.println("no. of Inversions are:"+ inv);
        // System.out.println();
        
        //COUNTING NO. OF INVERSIONS IN AN ARRAY :cases: 1) big n small in LHS 2) Both in RHS 3)Big in LHS & small no. in RHS part 
        int arr[] = { 2,5,11,3,6,9,13,8};
        int count  = InversionCount(arr, 0, arr.length-1);
        System.out.println("inversions are: " + count);
        System.out.println("ahellp");
       
       
        // note : for arrays : QuickSort > MergeSort

        //CYCLE SORT : 

    }

}
