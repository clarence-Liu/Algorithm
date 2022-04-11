package PrefixTree;

import java.util.Scanner;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and
 * retrieve keys in a dataset of strings. T
 * here are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *      Trie() Initializes the trie object.
 *      void insert(String word) Inserts the string word into the trie.
 *      boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 *      boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix (prefix), and false otherwise.
 */

/*
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 */
public class Trie {
    private final Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this.searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return this.searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for(int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String operatorsString = in.nextLine();
        String[] operators = operatorsString
                .substring(1, operatorsString.length() - 1)
                .replace(" ","")
                .replace("\"","").split(",");
        String wordsString = in.nextLine();
        String[] words = wordsString
                .substring(1, wordsString.length() - 1)
                .replace("[","")
                .replace("]","")
                .replace("\"","")
                .replace(" ","")
                .split(",");
        Trie trie = null;
        for (int i = 0; i < operators.length; i++) {
            String operator = operators[i];
            switch (operator){
                case "Trie" :
                    trie = new Trie();
                    System.out.println("null");
                    break;
                case "insert" :
                    trie.insert(words[i]);
                    System.out.println("null");
                    break;
                case "search" :
                    System.out.println(trie.search(words[i]));
                    break;
                default:
                    System.out.println(trie.startsWith(words[i]));
            }
        }
    }
}
