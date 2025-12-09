/*
Create a function named picnicBlanketPattern that receives squareColors and blanketSize as its parameters.

This function creates a checkered picnic blanket pattern with alternating colored squares based on the provided colors and size.

The function should return a 2D array of strings representing the picnic blanket pattern. Each inner array represents a row of squares on the blanket, with the colors alternating based on their position. The size of the blanket is determined by the blanketSize parameter, which represents the number of squares per side (both width and height).

For example, if squareColors is ["red", "blue"] and blanketSize is 3, the resulting pattern should be:

[
	["red", "blue", "red"],
	["blue", "red", "blue"],
	["red", "blue", "red"]
]
Parameters:
- squareColors (String[]): An array of two strings representing the colors of the squares.
- blanketSize (int): An integer representing the size of the blanket, which is the number of squares per side (both width and height).

The function returns a 2D array of strings (String[][]) representing the picnic blanket pattern.
*/

class PicnicBlanketPattern {
    public static String[][] picnicBlanketPattern(String[] squareColors, int blanketSize) {
        String[][] blanket = new String[blanketSize][blanketSize];
        
        for (int i = 0; i < blanketSize; i++) {
            for (int j = 0; j < blanketSize; j++) {
                int colorIndex = (i + j) % 2;
                blanket[i][j] = squareColors[colorIndex];
            }
        }
        
        return blanket;
    }
}