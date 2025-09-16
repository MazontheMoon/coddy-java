/*
Create a function named transformStrings that receives original and modifier as its parameters.

The function should:
- Reverse the string original.
- Concatenate the reversed original string with the modifier string.
- Reverse the entire result of the concatenation.

For example:
If original is "cat" and modifier is "dog", the function should return "godtac".
If original is "ABBA" and modifier is "123", the function should return "321ABBA".

Parameters:
- original (String): The original string to be transformed.
- modifier (String): The string to be concatenated with the transformed original string.

The function returns a String, which is the result of the transformation process described above.
*/
class TransformStrings {
    public static String transformStrings(String original, String modifier) {
        String reversedOriginal = new StringBuilder(original).reverse().toString();
        String concatenated = reversedOriginal + modifier;
        String result = new StringBuilder(concatenated).reverse().toString();
        return result;
    }
}