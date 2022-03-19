// package Matrix;
import java.util.Scanner;
public class Matrix1{

    public static void SnakeMatrix(){

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt(); 
        int[][]  a = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<r;i++){

            if(i%2==0){
                for(int j=0;j<c;j++){
                    System.out.print(a[i][j]+" ");
                }

            }else{
                for(int j=c-1;j>=0;j--){
                    System.out.print(a[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
    public static void BoundedMatrix(int[][] a,int r,int c){
        if(r==1){    //only 1 row exist
            for(int j=0;j<c;j++){
                System.out.print(a[0][j]+" ");
            }
        }else if(c == 1){ //only 1 column 
            for(int i=0;i<r;i++){
                System.out.print(a[i][0]+ " ");
            }
        }else{
            for(int i=0;i<c;i++){              //for 0th row
                System.out.print(a[0][i]+" ");
            }
            for(int i=1;i<r;i++){
                System.out.print(a[i][c-1]+" ");  //for last column
            }

            for(int i=c-2;i>=0;i--){
                System.out.print(a[r-1][i]+" ");  //for bottommost row
            }
            for(int i=r-2;i>0;i--){
                System.out.print(a[i][0]+ " ");
            }
            
        }
    }

    public static void TransposeOfMatrix(int[][] a,int r,int c){

        // 1 2 3      1 4 7
        // 4 5 6 ->   2 5 8
        // 7 8 9      3 6 9

        //note : in following diagnol ones arent touched at all :
        for(int i=0;i<r;i++){
            for(int j=i+1;j<c;j++){

                //swapping a[i][j] with a[j][i] :
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp; 
            }
        }
        //printing  : 
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public static void RotateBy90(int[][] a, int r,int c){        //O(N^2) -> time and space 

    // 1 2       
    // 4 5  -->  2 5 8
    // 7 8       1 4 7
        int temp[][] = new int[c][r];
        for(int i=0;i<r;i++){
            int k=0;
            for(int j=c-1;j>=0;j--){
                
                temp[k][i] = a[i][j];
                k++;

            }

        }
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
        

    }

    public static void RotateBy90Efficiently(int[][] a,int r,int c){
        //STEP 1 -> Transpose 
        TransposeOfMatrix(a,r,c);

        //STEP 2 -> Reverse all columns 
    }
    public static void main(String[] args){
        // SnakeMatrix();

        int[][] a= {{1,2,3},{4,5,6},{7,8,9}};
        // BoundedMatrix(a,4,3);

        // TransposeOfMatrix(a,r,c);

        // RotateBy90(a,2,2);
        RotateBy90Efficiently(a, 3, 3);       //TRANSPOSE THEN REVERSE ALL COLUMNS  -> O[n^2] time and O[1] Space compl.
        
       

    }
}