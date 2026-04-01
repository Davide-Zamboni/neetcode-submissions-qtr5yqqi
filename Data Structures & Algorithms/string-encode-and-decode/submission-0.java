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
        while (!str.isEmpty()){
            int index = str.indexOf("_EoS_");
            result.add(str.substring(0, index));
            str = str.substring(index + 5, str.length());
        }
        return result;
        
    }
}
