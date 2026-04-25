class Solution {
    List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        
        boolean[] usedCols = new boolean[n];
        boolean[] usedDiag1 = new boolean[2 * n - 1];
        boolean[] usedDiag2 = new boolean[2 * n - 1];

        placeQueens(0, n, board, usedCols, usedDiag1, usedDiag2);

        return solutions;
    }

    private void placeQueens (
        int row,
        int n,
        char[][] board,
        boolean[] usedCols,
        boolean[] usedDiag1,
        boolean[] usedDiag2
    ) {
        if (row == n) {
            solutions.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++){
            int diag1Index = row - col + n - 1;
            int diag2Index = row + col;

            if (usedCols[col] || usedDiag1[diag1Index] || usedDiag2[diag2Index]){
                continue;
            }

            board[row][col] = 'Q';
            usedCols[col] = true;
            usedDiag1[diag1Index] = true;
            usedDiag2[diag2Index] = true;

            placeQueens(row + 1, n, board, usedCols, usedDiag1, usedDiag2);

            board[row][col] = '.';
            usedCols[col] = false;
            usedDiag1[diag1Index] = false;
            usedDiag2[diag2Index] = false;
        }
    }


    private List<String> buildBoard(char[][] board){
        List<String> layout = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            layout.add(new String(board[row]));
        }

        return layout;
    }
}
