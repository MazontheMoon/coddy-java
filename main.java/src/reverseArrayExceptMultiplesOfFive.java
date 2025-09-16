/*
Create a function named reverseArrayExceptMultiplesOfFive that receives depths as its parameter.
This function reverses the order of elements in the depths array, except for elements that are multiples of five, which remain in their original positions.
Iterate through the depths array and check each element. If the element is a multiple of five, skip it. Otherwise, swap the current element with its corresponding element from the opposite end of the array. Use a loop that runs from both ends of the array and stops when the pointers meet in the middle.

Parameters:
- depths (int[]): An array of integers representing the depths explored in the ocean. The array can have up to 10 elements.

The function returns a new int[] where all elements are reversed except for the elements that are multiples of five.
*/

class ReverseArrayExceptMultiplesOfFive {
    public static int[] reverseArrayExceptMultiplesOfFive(int[] depths) {
        int left = 0;
        int right = depths.length - 1;

        while (left < right) {
            if (depths[left] % 5 == 0) {
                left++;
                continue;
            }

            if (depths[right] % 5 == 0) {
                right--;
                continue;
            }

            int temp = depths[left];
            depths[left] = depths[right];
            depths[right] = temp;

            left++;
            right--;
        }

        return depths;
    }
}