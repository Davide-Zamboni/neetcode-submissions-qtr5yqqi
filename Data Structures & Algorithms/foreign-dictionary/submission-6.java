class Solution {

    public Map<Character, List<Character>> adjList = new HashMap<>();
    Set<Character> visited = new HashSet<>();
    Set<Character> inPath = new HashSet<>();
    public String foreignDictionary(String[] words) {
        

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];

            int word1Pointer = 0;
            int word2Pointer = 0;

            while (word1Pointer < word1.length() && word2Pointer < word2.length()){
                char char1 = word1.charAt(word1Pointer);
                char char2 = word2.charAt(word2Pointer);
                if(char1 != char2){
                    adjList.get(char1).add(char2);
                    break;
                }
                word1Pointer++;
                word2Pointer++;
            }

            if (word2Pointer == word2.length() && word1Pointer < word1.length()){
                return "";
            } 
            
        }

        
        StringBuilder result = new StringBuilder();

        for (char c : adjList.keySet()) {
            if (!dfs(c, result)) return "";
        }


        return result.reverse().toString();
      
    }

    public boolean dfs(char c, StringBuilder result){
        if(inPath.contains(c)){
            return false;
        }
        if(visited.contains(c)){
            return true;
        }
        inPath.add(c);
        for(char letter : adjList.get(c)){
            if(!dfs(letter, result)){
                return false;
            }
        }
        inPath.remove(c);
        visited.add(c);
        result.append(c);
        return true;
    }



}
