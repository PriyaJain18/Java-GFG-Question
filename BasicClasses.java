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
        normalSwap(10, 20);
        swapWithoutAuxiliarySpace(10, 30);
        swapUsingXOR(10, 40);
    }
    
}
