/*
Create a function named reverseAndCompare that receives String[] instruments and String target as its parameters.

The function should help a musical instrument shop owner organize their inventory on a warm summer day. It will reverse the order of the instruments in the array and compare each reversed instrument name with the given target string.

Follow these steps to implement the function:
- Reverse the order of the instrument names in the input array.
- For each reversed instrument name, compare it with the target string.
- Create a boolean array to store the comparison results.

Parameters:
- instruments (String[]): An array of strings representing the names of instruments in the shop's inventory.
- target (String): A target string to compare with the reversed instrument names.

The function returns a boolean array where each element indicates whether the reversed instrument name matches the target string (true if it matches, false otherwise).

For example, if the input array is ["guitar", "piano", "drum"] and the target string is "ratiug", the function should return [true, false, false] because only the reversed "guitar" ("ratiug") matches the target string.

Note: The comparison between the reversed instrument name and the target string should be case-sensitive.
*/
import java.util.Arrays;

class ReverseAndCompare {
    public static boolean[] reverseAndCompare(String[] instruments, String target) {
        int length = instruments.length;
        boolean[] result = new boolean[length];

        for (int i = 0; i < length; i++) {
            String reversedInstrument = new StringBuilder(instruments[length - 1 - i]).reverse().toString();
            result[i] = reversedInstrument.equals(target);
        }

        return result;
    }
}