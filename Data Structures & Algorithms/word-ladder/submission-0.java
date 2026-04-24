class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);

        if (!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int result = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String word = queue.poll();

                if (word.equals(endWord)){
                    return result;
                }

                List<String> nextWords = getNextWords(word, wordSet, visited);

                for (String nextWord : nextWords){
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
            result++;
        }

        return 0;
    }

    private List<String> getNextWords(String word, Set<String> wordSet, Set<String> visited){
        List<String> nextWords = new ArrayList<>();

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++){
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++){
                if (c == original){
                    continue;
                }

                chars[i] = c;
                String nextWord = new String(chars);

                if (wordSet.contains(nextWord) && !visited.contains(nextWord)){
                    nextWords.add(nextWord);
                }
            }

            chars[i] = original;
        }

        return nextWords;
    }
}
