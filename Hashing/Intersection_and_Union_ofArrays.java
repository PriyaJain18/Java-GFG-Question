import java.util.Arrays;
import java.util.HashSet;

public class Intersection_and_Union_ofArrays {

    public static void intersectionBetterSol(int[] a,int[] b){
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

    public static void intersectionBestSol( Integer[] a, Integer[] b){
        int blen = b.length;
       
        HashSet<Integer> hash_a = new HashSet<>(Arrays.asList(a));
        int count = 0;   //size of/elements in union array
        for(int i=0;i<blen;i++){
            if(hash_a.contains(b[i])){
                System.out.print(b[i]+ " ");
                count++;
                hash_a.remove(b[i]);   //removes the 1 unique b[i] present in hash_a -> thus ignores duplicate elements from array b 
            }
        }
        System.out.print( " intersection count-> "+ count);
    }
    public static void unionBetterSol(int[] a,int[] b){
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


    public static void unionBestSol(Integer[] a, Integer[] b){
        int blen = b.length;
        HashSet<Integer> hash_a = new HashSet<>(Arrays.asList(a));
        
        for(int i=0;i<blen;i++){
            hash_a.add(b[i]);
        }
        System.out.println(hash_a+" union count -> "+ hash_a.size());
      
    }
    public static void main(String[] args) {

        int a[] = {10,20,20,40,50,70,70};
        int b[] = {20,30,50,60,70,90};
        
        Integer a1[] = {10,20,20,40,50,70,70};
        Integer b1[] = {20,30,50,60,70,90};
        
        intersectionBetterSol(a,b);
        System.out.println();
        intersectionBestSol(a1,b1);   //Theta(m+n) -> time and O(m) -> space //check how ?
        System.out.println();
        unionBetterSol(a,b);             //CHECK  /////////////////////@@@ WRONG OUTPUT
        System.out.println();
        unionBestSol(a1,b1);  //Theta(m+n) -> time and space

    }
}