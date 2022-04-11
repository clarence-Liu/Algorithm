package BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 852. Let's call an array arr a mountain if the following properties hold:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 *      arr[0] < arr[1] < ... arr[i-1] < arr[i]
 *      arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 */
/*
Input: arr = [0,1,0]
Output: 1

Input: arr = [0,2,1,0]
Output: 1

Input: arr = [0,10,5,2]
Output: 1

Input: arr = [3,4,5,1]
Output: 2

Input: arr = [24,69,100,99,79,78,67,36,26,19]
Output: 2
 */
public class MountainArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the mountain array:");
        ArrayList<Integer> arr = new ArrayList<>();
        while (scanner.hasNext()) {
            arr.add(scanner.nextInt());
        }
//        String arrString = scanner.nextLine();
//        String[] arrays = arrString.split(" ");
//        int[] arr = new int[arrays.length];
//        for (int i = 0; i < arrays.length; ++i) {
//            arr[i] = Integer.parseInt(arrays[i]);
//        }
        int res = peakIndexInMountainArray(arr.stream().mapToInt(Integer::valueOf).toArray());
//        int res = peakIndexInMountainArray(arr);
        System.out.println("Output : " + res);
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
