public class TrieNode {
        boolean eow = false;
        TrieNode[] children = new TrieNode[26];
}
class WordDictionary {
    private TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(word, 0, root);

    }

    public boolean dfs(String word, int j, TrieNode root){
        TrieNode cur = root;
        for (int i = j; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                for(TrieNode c : cur.children){
                    if(c != null && dfs(word, i + 1, c)){
                        return true;
                    }
                }
                return false;
            }
            else {
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null){
                    return false;
                }
                cur = cur.children[index];
            }
        }
        return cur.eow;

    }
}
