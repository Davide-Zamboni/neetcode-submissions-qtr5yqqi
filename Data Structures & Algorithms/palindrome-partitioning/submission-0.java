class Solution {
    List<List<String>> result = new ArrayList<>();
    private List<String> part = new ArrayList<>();
    public List<List<String>> partition(String s) {

        dfs(0,0,s);
        return result;
    }

    public void dfs(int i, int j, String s){
        if (i == s.length()){
            result.add(new ArrayList<>(part));
        }

        if (j == s.length()){
            return;
        }

        if (isPalindrome(s.substring(i, j + 1))){
            part.add(s.substring(i, j + 1));
            dfs(j + 1, j + 1, s);
            part.remove(part.size() - 1);
        }

        dfs(i, j+1, s);
    }






    public boolean isPalindrome(String s){
        int start = 0; 
        int end = s.length() - 1;

        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
