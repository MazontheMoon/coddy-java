/*
Write a function generateFestivalSeating that takes rows, cols and returns a String[][] representing festival seating labels.

Each seat label shows its position in format "R[row]C[col]-[row_binary]|[col_binary]" where row and column numbers are converted to binary.

Parameters:

rows (int): Number of rows in the seating area
cols (int): Number of columns in the seating area
Returns: 2D string array with seat labels. Format: "R1C2-1|10"
*/

class GenerateFestivalSeating {
    public static String[][] generateFestivalSeating(int rows, int cols) {
        String[][] seating = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int rowNum = i + 1;
                int colNum = j + 1;
                String rowBinary = Integer.toBinaryString(rowNum);
                String colBinary = Integer.toBinaryString(colNum);
                seating[i][j] = "R" + rowNum + "C" + colNum + "-" + rowBinary + "|" + colBinary;
            }
        }

        return seating;
    }
}