class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> maps = buildMap(s);
        HashMap<Character,Integer> mapt = buildMap(t);


        return maps.equals(mapt);

    }

    public HashMap<Character,Integer> buildMap(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(s.charAt(i))){
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
