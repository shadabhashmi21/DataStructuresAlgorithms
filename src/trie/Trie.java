package trie;

public class Trie {
    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    private static class TrieNode{
        private final TrieNode[] children;
        private boolean isWord;

        TrieNode(){
            children = new TrieNode[26]; // Because English language contains 26 alphabets
            isWord = false;
        }
    }

    public void insert(String word){
        if (word == null || word.isEmpty())
            throw new IllegalArgumentException("invalid input");

        word = word.toLowerCase();

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }else{
                current = current.children[index];
            }
        }
        current.isWord = true;
    }
}
