package HashTable;

import java.util.*;
/**
 * 726. Number of Atoms
 * Given a chemical formula (given as a string), return the count of each atom.
 *
 * The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 *
 * Two formulas concatenated together to produce another formula. For example, H2O2He3Mg4 is also a formula.
 *
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 *
 * Given a formula, return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 */
/*
Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.

Input: formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

Input: formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

Input: formula = "Be32"
Output: "Be32"
 */
public class Atoms {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the chemical formula:");
        String chemical = scanner.nextLine();
        Atoms atoms = new Atoms();
        System.out.println("Output: " + atoms.countOfAtoms(chemical));
    }

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int length = formula.length();
        int i = 0;
        while (i < length){
            if (formula.charAt(i) == '(') {
                i++;
                stack.push(new HashMap<>());
            } else if (formula.charAt(i) == ')') {
                ++i;
                int num = parseNum(i, length, formula);
                Map<String, Integer> popMap = stack.pop();
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    topMap.put(key, topMap.getOrDefault(key, 0) + value * num);
                }
            } else {
                int start = i++;
                while (i < length && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);
                int num = parseNum(i, length, formula);
                Map<String, Integer> atomMap = stack.peek();
                atomMap.put(atom, atomMap.getOrDefault(atom, 0) + num);
            }
        }
        Map<String, Integer> atomsMap = stack.peek();
        TreeMap<String, Integer> atomsCount = new TreeMap<>(atomsMap);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : atomsCount.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            builder.append(key);
            if (value > 1) {
                builder.append(value);
            }
        }
        return builder.toString();
    }

    public int parseNum(int start, int length, String formula) {
        int num = 0;
        if (start==length || !Character.isDigit(formula.charAt(start))) {
            num = 1;
        } else {
            while (start < length && Character.isDigit(formula.charAt(start))) {
                num = num * 10 + (formula.charAt(start++) - '0');
            }
        }
        return num;
    }
}
