// import java.util.Scanner;

/**
 *UNBOUNDED BINARY SEARCH : Searching an element in an array of infinite size .Complexity ->O(LOG(PositionAtWhichElementFound))
 */
public class SearchInInfiniteArray {
    static int searchEle(int[] arr, int num) {
        if (arr[0] == num) {
            return 0;
        }
        int i = 1, ans = 0;
        while (arr[i] < num) {
            i = i * 2;
        }
        if (arr[i] == num) {
            return i;
        } else {
            int low = (i / 2) + 1;
            int high = i - 1;
            while (low <= high) {
                int mid = (high + low) / 2;
                if (arr[mid] == num) {
                    return mid;
                } else if (arr[mid] > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            return -1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = { 1, 10, 15, 20, 30, 45, 60, 67, 80, 83, 90, 105, 107, 120, 135, 142, 150 }; // use an infinite
                                                                                                 // array instead
        int num = 139; // element to search
        System.out.println(searchEle(arr, num)); // returns index value if present else "NOT FOUND"

    }
}