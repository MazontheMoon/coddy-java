import java.util.Arrays;

class MarinadeMatrix {
    public static int[][] marinadeMatrix(int[][] ingredients, String[] specialIngredients) {
        int rows = ingredients.length;
        int cols = ingredients[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int reversedIndex = cols - 1 - j;
                int hashValue = (ingredients[i][reversedIndex] * 31 + 17) % 100;

                if (j < specialIngredients.length) {
                    hashValue = (hashValue * 2) % 100;
                }

                result[i][j] = hashValue;
            }
        }

        return result;
    }
}
