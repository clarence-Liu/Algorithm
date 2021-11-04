import java.util.Scanner;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received
 * for their ith paper and citations is sorted in an ascending order, return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers
 * have at least h citations each, and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * You must write an algorithm that runs in logarithmic time.
 */
public class HIndexSec {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the citations array:");
        String citationsString = scanner.nextLine();
        citationsString = citationsString.substring(1, citationsString.length() - 1);
        String[] citationsArray = citationsString.split(",");
        int[] citations = new int[citationsArray.length];
        for (int i = 0; i < citationsArray.length; ++i) {
            citations[i] = Integer.parseInt(citationsArray[i]);
        }
        HIndexSec indexSec = new HIndexSec();
        System.out.println("Output : " + indexSec.hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return length - left;
    }

}
