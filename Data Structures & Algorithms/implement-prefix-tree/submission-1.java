

    public class TrieNode {
        boolean eow = false;
        TrieNode[] children = new TrieNode[26];
    }

class PrefixTree {
        private TrieNode root;

        private PrefixTree() {
            root = new TrieNode();
        }
        

    public void insert(String word) {
       TrieNode cur = root;
       for (char c : word.toCharArray()){
        int i = c - 'a';
        if(cur.children[i] == null){
            cur.children[i] = new TrieNode();
        }
        cur = cur.children[i];
       }
       cur.eow = true;

    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null){
                return false;
            }
            cur = cur.children[i];
        }
        return cur.eow;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null){
                return false;
            }
            cur = cur.children[i];
        }
        return true;

    }
}
