package PrefixTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 212. Word Search II
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String boardString = in.nextLine();
        String[] boardArray = boardString
                .substring(2, boardString.length() - 2)
                .replace("\"", "").split("],\\[");
        char[][] board = new char[boardArray.length][];
        for (int i = 0; i < boardArray.length; i++) {
            String[] row = boardArray[i].split(",");
            board[i] = new char[row.length];
            for (int j = 0; j < row.length; j++) {
                board[i][j] = row[j].charAt(0);
            }
        }
        String wordString = in.nextLine();
        String[] words = wordString
                .substring(1, wordString.length() - 1)
                .replace("\"", "")
                .split(",");
        System.out.println("board : ");
        WordSearch2 wordSearch2 = new WordSearch2();
        List<String> ans = wordSearch2.findWords(board, words);
        for (String s : ans
             ) {
            System.out.println(s);
        }
    }
}
