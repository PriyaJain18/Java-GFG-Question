// package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MyCmp  implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return o1%2 - o2%2; //left one == 0 gives even
    }
}

public class EvenOddArray {
    public static void main(String[] args) {
        Integer[] arr = {10,30,27,48,16,31};
        Arrays.sort(arr,new MyCmp());
        // Arrays.toString(arr);
        System.out.println(Arrays.toString(arr));
    }

    
}
