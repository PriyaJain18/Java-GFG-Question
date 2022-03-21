import java.util.Arrays;
import java.util.HashSet;

public class Count_DIstinct_Elements {

    public static int NaiveSol(int[] arr){
        int n = arr.length;
        int distinctElements = 0;
        boolean flag = false;        //if repetitive elements present -> true  
        for(int i=0;i<n;i++){
            flag = false;
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                distinctElements++;
            }
        }
        return distinctElements;

    }
    public static int BetterSol(int[] arr){
        int n = arr.length;
        HashSet<Integer> hashset = new HashSet<>();
        for(int i=0;i<n;i++){
            hashset.add(arr[i]);   //donot insert element if already present (i.e. uniqueness)
        }
        return hashset.size();
    }
    public static int BestSol(Integer[] arr){
        HashSet<Integer> hashset = new HashSet<>(Arrays.asList(arr));    
        // Convert Integer(not int) array to ArrayList which is passed to HashSet, thus convert ArrayList -> HashSet
        
        return hashset.size();
    }
    public static void main(String[] args) {
        int[] arr = {10,20,10,10,40,50,20,50};

        int distinctEleCount = NaiveSol(arr);
        System.out.println(distinctEleCount);

        distinctEleCount = BetterSol(arr);
        System.out.println(distinctEleCount);

        Integer[] arr1 = {10,20,10,10,40,50,20,50};

        distinctEleCount = BestSol(arr1);
        System.out.println(distinctEleCount);

    }
    
}
