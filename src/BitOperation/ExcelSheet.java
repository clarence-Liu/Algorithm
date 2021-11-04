package BitOperation;

import java.util.Scanner;

/**
 * 171. Excel Sheet Column Number
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
 */
/*
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28(26*1 + 2)

Example 3:
Input: columnTitle = "ZY"
Output: 701(26*26+25)

Example 4:
Input: columnTitle = "FXSHRXW"
Output: 2147483647
 */

public class ExcelSheet {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Given the columnTitle:");
        String columnTitle = in.nextLine();
        ExcelSheet sheet = new ExcelSheet();
        System.out.println("Output: " + sheet.titleToNumber(columnTitle));
    }
    public int titleToNumber(String columnTitle) {
        int step = 1, length = columnTitle.length(), res = 0;
        int index = length - 1;
        while (index >= 0) {
            res += (columnTitle.charAt(index) - 'A' + 1) * step;
            step *= 26;
            index--;
        }

        return res;
    }
}
