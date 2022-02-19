import java.util.Scanner;
class squareRoot
{ 
	static int sqRootFloor(int x)
	{
		int low = 1, high = x, ans = -1;

		while(low <= high)
		{
			int mid = (low + high) / 2;

			int mSq = mid * mid;

			if(mSq == x)
				return mid;
			else if(mSq > x)
				high = mid - 1;
			else
			{
				low = mid + 1;
				ans = mid;
			}
		}

		return ans;
	}

	public static void main(String args[]) 
    {

		System.out.println(sqRootFloor(10));

    } 

}

 // finding squareRoot using binary search :
        
//  Scanner sc = new Scanner(System.in);
//  int findRoot = sc.nextInt(); // ex. 10
//  ArrayList<Integer> array = new ArrayList<>(findRoot);
//  int array[] = new int[findRoot]; //then array with 10 nos.
 // IntStream.range(1, findRoot+1).forEach(( element -> ( array.)); //adding nos. to array from 1 to 10(exclusive of findRoot+1)
 // IntStream.range(1, findRoot+1).for(int i=0;i<=findRoot;i++){ array[i] =
 // findRoot;}; //adding nos. to array from 1 to 10(exclusive of findRoot+1)
