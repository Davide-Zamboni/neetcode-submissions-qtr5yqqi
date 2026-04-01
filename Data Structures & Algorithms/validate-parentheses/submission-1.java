class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if(c == '(' || c == '{' || c=='['){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()) {
                    return false; 
                } 
                char par = stack.pop();
                if(par == '[' && c != ']'){
                    return false;
                }
                if(par == '(' && c != ')'){
                    return false;
                }
                if(par == '{' && c != '}'){
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
        
    }
}
