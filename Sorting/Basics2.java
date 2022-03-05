// package Sorting;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Point2> l3 = new ArrayList<>();
        l3.add(new Point2(10,20));
        l3.add(new Point2(30,80));        
        l3.add(new Point2(20,10));

        Collections.sort(l3);
        for (int i = 0; i < l3.size(); i++) {
            for (int j = 0; j < i.length; j++) {
                System.out.print(i[j]);
            }
            
        }
        //////////////////
      

        // Collections.sort(l3,Collections.reverseOrder());
        // System.out.println(l3);  //descending order
    } 

}

