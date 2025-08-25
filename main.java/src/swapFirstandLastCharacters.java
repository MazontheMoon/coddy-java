/*Create a function named swapFirstLast that receives str as its parameter.

This function aims to swap the first and last characters of the input string, but only if certain conditions are met.

The function should check the following conditions:

The input string must be at least 3 characters long.
The first and last characters of the input string must be different.
If both conditions are satisfied, the function should return a new string with the first and last characters swapped. If either condition is not met, the function should return the original input string unchanged.

Parameters:
 - str (String): The input string that needs to be processed.
 - The function returns a String, which is either the modified string with the first and last characters swapped (if conditions are met) or the original input string (if conditions are not met). */

public class swapFirstandLastCharacters {
    class SwapFirstLast {
        public static String swapFirstLast(String str) {
            // Write code here
            char firstChar = str.charAt(0);
            char lastChar = str.charAt(str.length() - 1);
            String middle = str.substring(1, str.length() - 1);

            if(str.length() < 3 || firstChar == lastChar){
                return str;
            }

            return lastChar + middle + firstChar;

        }
    }

}
