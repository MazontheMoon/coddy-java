/*
Create a function named slideDown that receives slide and startPosition as its parameters.
Your task is to simulate a child's journey down a playground slide, represented by a string of characters. The function will "slide" the child down by reversing a portion of the string from the starting position to the end.
Imagine a child climbing up to a specific point on a twisty slide. As they slide down, they cause the part of the slide below them to flip upside down, reversing the order of its parts!

Parameters:

- slide (String): A string of characters representing the playground slide.
- startPosition (int): The position where the child starts on the slide (0-indexed).

The function returns a String representing the modified slide after the child has slid down.

For example:

If the slide is "ABCDEFG" and the child starts at position 2, the result should be "ABGFEDCG".
If the slide is "PLAYGROUND" and the child starts at position 4, the result should be "PLAYDNUORGYG".
Remember to handle cases where the startPosition is at the beginning or end of the slide, and ensure that your function works correctly for all valid inputs.
*/
class SlideDown {
    public static String slideDown(String slide, int startPosition) {
        if (startPosition < 0 || startPosition >= slide.length()) {
            return slide;
        }

        StringBuilder result = new StringBuilder();
        result.append(slide.substring(0, startPosition));

        StringBuilder reversedPart = new StringBuilder(slide.substring(startPosition));
        result.append(reversedPart.reverse());

        return result.toString();
    }
}
