// import java.util.ArrayList;
// import java.util.Scanner;
// import java.util.stream.IntStream;

// import javax.lang.model.element.Element;

// package BinarySearch;

public class binarySearch {

    public static final String BG_RESET = "\u001B[0m"; // Declaring ANSI_RESET so that we can reset the color
    public static final String REDBG = "\u001B[41m"; // Declaring the background color

    static int searchFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (x < arr[mid]) {
                high = mid - 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else { // when x==mid
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    static int searchLast(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x < arr[mid]) {
                high = mid - 1;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else { // when x==mid
                if (mid == n - 1 || arr[mid + 1] != arr[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            }
        }
        return -1;
    }

    // MID =(low+(high-low)/2)

    // static int countNum(int[] arr, int x) { //COUNT NO. OF OCCURENCES OF A NUMBER
    // IN A SORTED ARRAY

    static int countNum(int[] arr, int x) {
        int count = 0, n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x < arr[mid]) {
                high = mid - 1;

            } else if (x > arr[mid]) {
                low = mid + 1;

            } else { // x==mid

                if (arr[mid - 1] != arr[mid] || mid == 0) {
                    count++;
                    int i = mid + 1;
                    while (arr[i] == x && i < n) {
                        count++;
                        i++;
                    }
                    return count;

                } else if (arr[mid + 1] != arr[mid] || mid == n - 1) {
                    count++;
                    int i = mid - 1;
                    while (arr[i] == x && i >= 0) {
                        count++;
                        i--;
                    }
                    return count;

                } else { // traversing both sides
                    count++;
                    int i = mid - 1;
                    while (arr[i] == x && i >= 0) {
                        count++;
                        i--;
                    }
                    int j = mid + 1;
                    while (arr[j] == x && i < n) {
                        count++;
                        i++;
                    }
                    return count;
                }
            }
        }

        return -1;
    }

    static int countNum1(int[] arr, int x) {
        int count = 0;
        int firstIndex = searchFirst(arr, x);
        if (firstIndex != -1) {
            count = searchLast(arr, x) - firstIndex + 1;
            return count;
        } else {
            count = 0;
            return count;
        }
    }

    static int countOnes(int[] arr) {
        int n = arr.length, count = 0;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == 0) {
                low = mid + 1;
                if (arr[high - 1] != 1)
                    return (count + 1);
            } else if (arr[mid] == 1) {
                count += (n - 1 - mid) + 1; // counting current index + age wale(RHS) sare index
                if (arr[mid - 1] == 1) {
                    high = mid - 1;
                    if (arr[high - 1] != 1)
                        return (count + 1);
                } else
                    return count;
            }
        }
        return -1;
    }

    static int countOnes1(int[] arr) { // O(Log N)
        int onesFirst = searchFirst(arr, 1);
        if (onesFirst == 0) {
            return -1;
        } else {
            return (arr.length - 1 - onesFirst + 1); // or//arr.length - onesFirst
        }
    }

    static int countOnes2(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == 0) {
                low = mid + 1;
            } else { // mid==1
                if (mid == 0 || arr[mid - 1] == 0) {
                    return n - mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        /*
        int[] arr = { 5, 10, 10, 15, 15, 15, 16, 16, 16 };

        System.out.println("first occurance of  16 is at index : " + searchFirst(arr, 16)); // let x=15->3
        System.out.println("Last occurance of  16 is at index : " + searchLast(arr, 16)); // let x=15->5

        int[] arr1 = { 5, 10, 10, 11, 11, 14, 14, 14, 14, 14, 15, 16, 16, 17 };

        // System.err.println(REDBG + "No. of occurances of 14 is : " + countNum(arr1, 14) + BG_RESET); // -> @@@ GIVING
                                                                                                     // WRONG OUTPUT
                                                                                                     // //O(Logn + k)
        // To count no. of occurences : int count = lastIndex - firstIndex +1;
        System.out.println("No. of occurances of 14 is : " + countNum1(arr1, 14)); // 3 // //O(log N)

        int[] arr01 = { 0, 0, 0, 0, 1, 1, 1, 1 }; // sorted
        System.out.println(countOnes(arr01));
        System.out.println(countOnes1(arr01));
        System.out.println(countOnes2(arr01));
        // note : better -> countOnes1 >>>

        */

       
        

    }

}
