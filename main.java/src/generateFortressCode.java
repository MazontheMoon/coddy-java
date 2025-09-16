/*
Create a function named generateFortressCode that receives codeLength and key as its parameters.

You are an archaeologist exploring an ancient fortress. To unlock its secrets, you need to generate a special code based on a key you've discovered. Your task is to create a function that generates this code.

The function should use a loop to iterate through the characters of the key, selecting and concatenating them to form the secret code. The selection process should ensure that the resulting code has the specified length, even if it means wrapping around to the beginning of the key multiple times.

Parameters:
- codeLength (int): The desired length of the secret code. This value will always be positive.
- key (String): The key string used to generate the code. This string will contain at least one character and will consist only of lowercase letters.
- The function returns a String representing the generated secret code.

Here's how the code generation should work:
- Start from the first character of the key.
- Add this character to your secret code.
- Move to the next character in the key.
- If you reach the end of the key before your code is complete, start over from the beginning of the key.
- Continue this process until your secret code has reached the specified length.

For example, if the key is "abcde" and the desired code length is 8, your function should return "abcdeabc".
*/

class GenerateFortressCode {
    public static String generateFortressCode(int codeLength, String key) {
        StringBuilder code = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < codeLength; i++) {
            code.append(key.charAt(i % keyLength));
        }

        return code.toString();
    }
}