class Solution {
    Map<Character, List<Character>> adjList = new HashMap<>();
    Set<Character> visited = new HashSet<>();
    Set<Character> visiting = new HashSet<>();
    StringBuilder result = new StringBuilder();
    public String foreignDictionary(String[] words) {

        for (String word : words){
            for (char c : word.toCharArray()){
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++){
            String word1 = words[i - 1];
            String word2 = words[i];
            int length = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for (int j = 0; j < length; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    foundDifference = true;
                    break;
                }
                
            }

            if (!foundDifference && word1.length() > word2.length()){
                return "";
            }
        }

        
        
        for (char c : adjList.keySet()){
            if(!visited.contains(c)){
                if(!dfs(c)){
                    return "";
                }
            }
        }

        return result.reverse().toString();
    }

    public boolean dfs(char c){
        if (visiting.contains(c)){
            return false;
        }

        if (visited.contains(c)){
            return true;
        }

        visiting.add(c);

        for (char neighbor : adjList.get(c)){
            if(!dfs(neighbor)){
                return false;
            }
        }


        visiting.remove(c);
        visited.add(c);
        result.append(c);

        return true;
    }
}
