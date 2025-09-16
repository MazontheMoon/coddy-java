/*
Create a function named createCheckersBoard that receives blackPosition and whitePosition as its parameters.

The function should generate a simple ASCII representation of a checkers board with one black piece and one white piece placed on it.

The board is an 8x8 grid where empty squares are represented by dots (.), black pieces by 'B', and white pieces by 'W'. The positions are given as strings in the format "letter+number", where the letter (a-h) represents the column and the number (1-8) represents the row.

To solve this challenge, follow these steps:
- Create an 8x8 grid filled with dots (.)
- Convert the input positions to row and column indices
- Place the 'B' and 'W' characters at their respective positions
- Join the rows with newline characters to create the final board string

Parameters:
- blackPosition (String): A string representing the position of the black piece (e.g., "c3")
- whitePosition (String): A string representing the position of the white piece (e.g., "f6")

The function returns a String representing the checkers board with the pieces placed on it.

Remember to add a friendly message about the sunny afternoon at the beginning of your output!
*/

import java.util.Arrays;

class CreateCheckersBoard {
    public static String createCheckersBoard(String blackPosition, String whitePosition) {
        // Sunny afternoon message
        String message = "It's a lovely sunny afternoon for a game of checkers!\n\n";

        // Create an 8x8 grid filled with dots
        char[][] board = new char[8][8];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Convert positions to row and column indices and place pieces
        placePiece(board, blackPosition, 'B');
        placePiece(board, whitePosition, 'W');

        // Join the rows with newline characters
        StringBuilder result = new StringBuilder(message);
        for (char[] row : board) {
            result.append(new String(row)).append("\n");
        }

        return result.toString();
    }

    private static void placePiece(char[][] board, String position, char piece) {
        int col = position.charAt(0) - 'a';
        int row = 8 - (position.charAt(1) - '0');
        board[row][col] = piece;
    }
}