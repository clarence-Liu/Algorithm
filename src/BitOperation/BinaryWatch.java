package BitOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 401. Binary Watch
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 * Given an integer turnedOn which represents the number of LEDs that are currently on, return all possible times the watch could represent. You may return the answer in any order.
 *
 * The hour must not contain a leading zero.
 *      For example, "01:00" is not valid. It should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero.
 *      For example, "10:2" is not valid. It should be "10:02".
 */

/*
Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

Input: turnedOn = 9
Output: []
 */
public class BinaryWatch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the integer turnedOn:");
        int turnedOn = scanner.nextInt();
        BinaryWatch watch = new BinaryWatch();
        List<String> result = watch.readBinaryWatch(turnedOn);
        System.out.println("result:");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                result.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return result;
    }
}
