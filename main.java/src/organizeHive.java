class OrganizeHive {
    public static int[][] organizeHive(int[][] grid) {
        // Create a copy of the grid to work with
        int[][] result = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = grid[i][j];
            }
        }
        
        // Try to solve the puzzle
        if (solveSudoku(result)) {
            return result;
        } else {
            // If no solution exists, return the original grid
            return grid;
        }
    }
    
    private static boolean solveSudoku(int[][] board) {
        // Find the next empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    // Try numbers 1-9
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            
                            // Recursively try to solve the rest
                            if (solveSudoku(board)) {
                                return true;
                            }
                            
                            // Backtrack if this doesn't lead to a solution
                            board[row][col] = 0;
                        }
                    }
                    // No valid number found for this cell
                    return false;
                }
            }
        }
        // All cells filled successfully
        return true;
    }
    
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // Check 3x3 box
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}