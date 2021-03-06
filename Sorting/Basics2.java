// package Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Point2 implements Comparable<Point2>{
    int x;
    int y;
    Point2(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point2 o) {
        return this.x - o.x ;   //in ascending order 
    }
}

class Point3 {
    int x,y;
    Point3(int x,int y){
        this.x = x;
        this.y = y;
    }
   
}
class MyListComp implements Comparator<Point3> {
    @Override
    public int compare(Point3 o1, Point3 o2) {
        return o1.y - o2.y;      //SORTING accor to Y coordinate in Ascending order 
    }
}


public class Basics2 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(5);
        l1.add(17);
        Collections.sort(l1);
        System.out.println(l1);

        List<Integer> l2 = new LinkedList<>();
        l2.add(10);
        l2.add(5);
        l2.add(17);

        Collections.sort(l2,Collections.reverseOrder());
        System.out.println(l2);

        //Customized list : 
        
        //M1 : using comparable interface 
        List<Point2> l3 = new ArrayList<>();
        l3.add(new Point2(10,20));
        l3.add(new Point2(30,80));        
        l3.add(new Point2(20,10));

        // Collections.sort(l3);           //setted accor to 'x' in ascending order 
        Collections.sort(l3,Collections.reverseOrder());  //setted accor to 'x' in decending order 
        System.out.println("CUSTOMIZED L3 : ");
        for (Point2 pt : l3) {
            System.out.println(pt.x + " "+ pt.y);
        }

        // M2 : using our custom  comparator  :

        List<Point3> l4 = new ArrayList<>();
        l4.add(new Point3(10,20));
        l4.add(new Point3(30,80));        
        l4.add(new Point3(20,10));
        Collections.sort(l4,new MyListComp());       //setted accor to 'y' in ascending order 
        System.out.println("CUTOMIZED L4: ");
        for (Point3 pt : l4) {
            System.out.println(pt.x + " "+ pt.y);
        }
        
    } 

}

//STABLE SORTING ALGOS  :Bubble ,insertion ,merge
//UNSTABLE SORTING ALGOS :Selection , quick, heap sort 

