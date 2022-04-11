package LCOF;

import java.util.*;

public class StringArrangement {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the string s:");
        String str = scanner.nextLine();
        StringArrangement arrangement = new StringArrangement();
        String[] results = arrangement.permutation(str);
        System.out.println("Result:");
        for (String s : results) {
            System.out.println(s);
        }
    }

    public String[] permutation(String s) {
        int length = s.length();
        boolean[] visit = new boolean[length];
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        List<String> result = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        backtrack(characters, visit, result, 0, length, buffer);
        String[] results = result.toArray(new String[result.size()]);
        return results;
    }

    public void backtrack (char[] characters, boolean[] visit, List<String> result, int index, int length, StringBuffer buffer) {
        if (index == length) {
            result.add(buffer.toString());
        }
        for (int i = 0; i < length; ++i) {
            if (visit[i] || (i > 0 && characters[i - 1] == characters[i] && !visit[i - 1])) {
                continue;
            }
            visit[i] = true;
            buffer.append(characters[i]);
            backtrack(characters, visit, result, index + 1, length, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
            visit[i] = false;
        }
    }
}
