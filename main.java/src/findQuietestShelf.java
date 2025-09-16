/*
Create a function named findQuietestShelf that receives shelves as its parameter.

The function simulates a library's book search system to find the quietest shelf. Each element in the shelves array represents the number of people near that shelf.

Your task is to find the shelf with the least number of people around it, considering that people tend to move between adjacent shelves. The quietest shelf is the one with the lowest total number of people, including the people at adjacent shelves.

Parameters:
- shelves (int[]): An array representing the number of people near each shelf. The array will have at least one element and no more than 100 elements.

The function returns an integer representing the index of the quietest shelf (0-based index).

For example, if shelves = [3, 1, 5, 2, 4], the function should return 1, because the shelf at index 1 has the lowest total (1 + 3 + 5 = 9) compared to other shelves.

Use only basic increment and decrement operators (++, --) to navigate through the array.
*/

import java.util.Arrays;

class FindQuietestShelf {
    public static int findQuietestShelf(int[] shelves) {
        if (shelves.length == 1) {
            return 0;
        }

        int quietestShelf = 0;
        int minTotal = Integer.MAX_VALUE;

        for (int i = 0; i < shelves.length; i++) {
            int total = shelves[i];

            if (i > 0) {
                total += shelves[i - 1];
            }

            if (i < shelves.length - 1) {
                total += shelves[i + 1];
            }

            if (total < minTotal) {
                minTotal = total;
                quietestShelf = i;
            }
        }

        return quietestShelf;
    }
}