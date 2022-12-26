package trie;

public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;

        TrieNode(){
            children = new TrieNode[26]; // Because English language contains 26 alphabets
            isWord = false;
        }
    }
}
