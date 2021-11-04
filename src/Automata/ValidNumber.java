package Automata;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A valid number can be split up into these components (in order):
 *      A decimal number or an integer.
 *      (Optional) An 'e' or 'E', followed by an integer.
 */
/*
A decimal number can be split up into these components (in order):
    1. (Optional) A sign character (either '+' or '-').
    2. One of the following formats:
        1. One or more digits, followed by a dot '.'.
        2. One or more digits, followed by a dot '.', followed by one or more digits.
        3. A dot '.', followed by one or more digits.
An integer can be split up into these components (in order):
    1.(Optional) A sign character (either '+' or '-').
    2. One or more digits.

Example 1:
Input: s = "0"
Output: true

Example 2:
Input: s = "e"
Output: false

Example 3:
Input: s = "."
Output: false

Example 4:
Input: s = ".1"
Output: true
 */
public class ValidNumber {
    /*
    STATE_INITIAL:初始状态; STATE_INT_SIGN:整数符号; STATE_INTEGER:整数部分; STATE_POINT:小数点;
    STATE_POINT_WITHOUT_INT:无整数的小数点; STATE_FRACTION:小数部分
    STATE_EXP:科学计数E; STATE_EXP_SIGN:E的符号; STATE_EXP_NUMBER:E的整数部分;
    STATE_END:结束状态
     */
    enum State {
        STATE_INITIAL, STATE_INT_SIGN, STATE_INTEGER,
        STATE_POINT, STATE_POINT_WITHOUT_INT, STATE_FRACTION,
        STATE_EXP, STATE_EXP_SIGN, STATE_EXP_NUMBER,
        STATE_END
    }

    enum CharType {CHAR_NUMBER, CHAR_EXP, CHAR_POINT, CHAR_SIGN, CHAR_ILLEGAL}

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isNumber(s));
        System.out.println(isNumber2(s));
    }

    public static boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        //初始状态可以是整数，无整数的小数点以及符号位
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }
    public static boolean isNumber2(String s) {
        boolean pointOccur = false;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (toCharType(c) == CharType.CHAR_SIGN) {
                //当前位置为符号位，则下一位必定为小数点或者数字
                if (!((i + 1 < length) &&
                        (toCharType(s.charAt(i + 1)) == CharType.CHAR_NUMBER
                                || toCharType(s.charAt(i + 1)) == CharType.CHAR_POINT))) {
                    return false;
                }
            } else if (toCharType(c) == CharType.CHAR_NUMBER) {
                //如果当前位置为数字位，则下一位可以是小数点、E或者整数，不可能为符号位
                if (i + 1 < length && toCharType(s.charAt(i + 1)) == CharType.CHAR_SIGN) {
                    return false;
                }
            } else if (toCharType(c) == CharType.CHAR_POINT) {
                //如果当前位置为小数点，
                //1、数字开头不是小数点，则前一位必定为数字
                //2、下一位必定为数字
                //3、小数点尚未出现过
                if ( !((i > 0 && toCharType(s.charAt(i - 1)) == CharType.CHAR_NUMBER) ||
                        (i + 1 < length && toCharType(s.charAt(i + 1)) == CharType.CHAR_NUMBER)) || pointOccur){
                            return false;
                }
                pointOccur = true;
            } else if (toCharType(c) == CharType.CHAR_EXP) {
                //如果当前为科学计数位，则当前位置肯定不是位于头部或者尾部，并且是第一次出现
                if (i == 0 || i == length - 1) {
                    return false;
                }
                for (int j = i + 1; j < length; ++j) {
                    char c1 = s.charAt(j);
                    if (toCharType(c1) == CharType.CHAR_SIGN) {
                        if (j != i + 1 && j != length - 1)
                            return false;
                    } else if (toCharType(c1) != CharType.CHAR_NUMBER){
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
