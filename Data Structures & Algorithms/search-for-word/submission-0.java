class Solution {
    public boolean exist(char[][] board, String word) {

        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
        
    }


    public boolean backtrack(char[][] board, String word, int r, int c, int i){
        if(i == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1){
            return false;
        }

        if(board[r][c] != word.charAt(i) || board[r][c] == '#'){
            return false;
        }

        board[r][c] = '#';
        i++;
        boolean res = backtrack(board, word, r + 1, c, i) ||
        backtrack(board, word, r - 1, c, i) ||
        backtrack(board, word, r, c + 1, i) ||
        backtrack(board, word, r, c - 1, i);
        board[r][c] = word.charAt(i - 1);
        return res;
    }
}
