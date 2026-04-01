class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String s : strs){
            result.append(s);
            result.append("_EoS_");
        }
        return result.toString();
    }

    public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
        int j = str.indexOf("_EoS_", i);
        result.add(str.substring(i, j));
        i = j + 5;
    }
    return result;
}
}
