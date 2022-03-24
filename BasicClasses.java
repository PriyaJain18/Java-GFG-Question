import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.sql.rowset.spi.SyncResolver;

public class BasicClasses {

    //SWAPPING 2 VALUES :

    public static void normalSwap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a+" "+b);
    }
    public static void swapWithoutAuxiliarySpace(int a,int b){
        a = a - b;
        // Sum is stored in second variable
        b = a + b;
        // Difference of 1st from 2nd is replaced in first variable
        a = b - a;
        System.out.println(a+" "+b);
    }   
    public static void swapUsingXOR(int a,int b){  //at bit level not byte level ; thus more optimized than above methods 
        // Logic of XOR operator
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+" "+b);
    }

    public static void main(String[] args) {

        //SWAP : 
        normalSwap(10, 20);
        swapWithoutAuxiliarySpace(10, 30);
        swapUsingXOR(10, 40);

        //CONVERT int-ARRAY to Integer-ARRAY-LIST : 
        
        int[] arr = {10,20,30,40};
    // M1: 
        List<Integer> list1 = new ArrayList<>();
 
         for (int i : arr) {
            list1.add(i);
         }

    /* M2: Using JAVA 8 : 
      1. primitive array -> sequential stream using Arrays.stream().
      2. Box each element of the stream to an Integer using IntStream.boxed().
      3. Use Collectors.toList() to accumulate the input elements into a new list.
      */
        List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());        // .boxed()  : Stream<Integer>


        //Converting array to list to pass to another DataStructure: 

        Integer[] ar = {10,20,30};
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(ar)); 

        //GETTING DATATYPES: 
        
        int a1 = 10;
        Integer a2 = 20;
        String a3 = "str";
        System.out.println(((Object)a1).getClass().getSimpleName());
        System.out.println(a2.getClass());
        System.out.println(a3.getClass().getSimpleName());
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
    }
    
}


//SUB STRING / SUBARRAY -> a, b,c , ab,bc,abc -> (n*(n+1)) / 2

// SUB SEQUENCE/SUB-SETS-> _ _ _ , a , b, c ,ab_, _bc,a_c ,abc

