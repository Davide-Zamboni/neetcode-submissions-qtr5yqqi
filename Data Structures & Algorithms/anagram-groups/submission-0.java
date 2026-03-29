class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> resultMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            java.util.Arrays.sort(chars);
            String orderedString = new String(chars);
            if(resultMap.containsKey(orderedString)){
                List<String> result = resultMap.get(orderedString);
                result.add(s);
                resultMap.put(orderedString, result);
            }
            else{
                List<String> list = new ArrayList<>(); // FIX
                list.add(s);                          // FIX
                resultMap.put(orderedString, list);
            }
        }
        return new ArrayList<>(resultMap.values());
        
    }
}
