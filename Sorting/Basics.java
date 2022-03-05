// package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Point implements Comparable<Point>{  //M1 : our class IMPLEMENTS Comparable interface 
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Point p){
        return p.x - this.x;  //Setted to descending order 
    }
}
 
//M2 : Using our own Comparator
class Point1 {
    int x,y;
    Point1(int x,int y){
        this.x=  x;
        this.y = y;
    }
}
class MyComp implements Comparator<Point1>{
    public int compare(Point1 p1,Point1 p2){
        return p2.x - p1.x;  //descending order
    }
}

public class Basics {
    
    public static void main(String[] args) {

        //PRIMITVES : 

        int[] arr1 = {20,17,15,9};
        char[] arr2 = { 'A','v','D','E'};
        Arrays.sort(arr1,1,3);  //including index 1 and exluding index 3 
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        
        //NON - PRIMITIVES  :

        Integer[] arr3 = {20,17,15,9};
        Arrays.sort(arr3,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr3));


        Point[] arr4 = { new Point(10,30) , new Point(40,20) };
        Arrays.sort(arr4);  //gets sorted in descending now (acco to x) , accor to over-written compareTo func.
        for (Point ele : arr4) {
            System.out.println(ele.x +" "+ ele.y);
            
        }
        
        Point1[] arr5 = { new Point1(10,30) , new Point1(40,20) };
        Arrays.sort(arr5, new MyComp());
        for (Point1 ele : arr5) {
            System.out.println(ele.x +" "+ ele.y);
            
        }

    }
}

//Arrays.sort -> for primitives  ->  cannot be reversed using comparator 
//Arrays.sort -> for non-primitives -> uses comparators (Comparator class or extends comparable )