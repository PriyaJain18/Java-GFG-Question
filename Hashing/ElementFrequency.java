import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ElementFrequency {
    public static void naiveSol(int[] arr){
        int n =arr.length;
        for(int i=0;i<n;i++){
            int freq= 0;
            //LOGIC -> Consider an element on first occurence only and count frequencies in one go i.e. one loop 
            boolean repetition = false;
            //checking if ele comming for first time [i.e has it occured PREVIOUSLY in the array] -> to be considered or not by us 

            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    repetition = true;
                    break;
                }
            }

            if(repetition == true){
                continue;          //means : this element is repitive and we have considered it and it's frequen already (using code below)
            }

            //else -> consider the element and count it's freq
            freq = 1; 
            for(int j=i+1;j<n;j++){
                if(arr[i] == arr[j]){
                    freq++;
                }
            }
            System.out.print(arr[i]+" : "+freq+" , ");
        }

    }
    public static void betterSol(int arr[]){
        int n = arr.length;

        HashMap<Integer,Integer> hashmap = new HashMap<>();  //keyname , frequency
        // int count = 1;
        int val;
        for(int i=0;i<n;i++){
            if(!hashmap.containsKey(arr[i])){
                val = 1;
                hashmap.put(arr[i],val);
            }else{
                int key_val = hashmap.get(arr[i]);
                key_val++;
                hashmap.put(arr[i], key_val);   //uniqueness of key exists in hashmap i.e. cant create another key with same keyname
            }
        }
        for(Map.Entry<Integer,Integer> e : hashmap.entrySet()){
            System.out.print(e.getKey() + " " + e.getValue()+" , ");
        }
    }

    public static void bestSol(int arr[]){

        HashMap<Integer,Integer> hashmap = new HashMap<>();  //keyname , frequency
        for(int element : arr){
            hashmap.put(element,hashmap.getOrDefault(element,0)+1);
        }
        //Printing hash-map's key-value : 
        for(Map.Entry<Integer, Integer> e: hashmap.entrySet()){
            System.out.print(e.getKey() + " "+e.getValue()+" , ");  
        }

    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,10,10,40,30,20};

        naiveSol(arr);   //O(n^2) -> time , O(1) -> space
        System.out.println("better sol : ");
        betterSol(arr);     
        System.out.println("best sol: ");
        bestSol(arr);   //Theta(n) -> time , O(n) -> space
    }
    
}
