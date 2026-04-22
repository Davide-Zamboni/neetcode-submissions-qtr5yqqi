class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(), 0, 0);
        return result;
    }


    public void backtrack(int n, StringBuilder s, int open, int close){
        if(s.length() == n * 2){
            result.add(s.toString());
            return;
        }

        if(open < n) {
            s.append('(');
            backtrack(n, s, open + 1, close);
            s.deleteCharAt(s.length() - 1);
        }

        if(close < open) {
            s.append(')');
            backtrack(n, s, open, close + 1);
            s.deleteCharAt(s.length() - 1);
        }

    }
}
