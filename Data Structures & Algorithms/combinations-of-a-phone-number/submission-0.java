class Solution {
    Map<Character,String> numToChar = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return result;
        }

        numToChar.put('2', "abc");
        numToChar.put('3', "def");
        numToChar.put('4', "ghi");
        numToChar.put('5', "jkl");
        numToChar.put('6', "mno");
        numToChar.put('7', "pqrs");
        numToChar.put('8', "tuv");
        numToChar.put('9', "wxyz");

       
        visit(digits, 0, new StringBuilder());
        

        return result;
    }

    public void visit(String digits, int i, StringBuilder soFar){
        if (i > digits.length() - 1){
            result.add(soFar.toString());
            return;
        }

        for(char c : numToChar.get(digits.charAt(i)).toCharArray()){
            soFar.append(c);
            visit(digits, i+1, soFar);
            soFar.deleteCharAt(soFar.length() - 1);
        }
    }
}
