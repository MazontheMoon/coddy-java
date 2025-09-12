/*
Create a function named drawCharacterHead that receives skillLevel, features, difficulties, and mood as its parameters.

The function simulates an artist's attempt to draw a character's head, incorporating the artist's skill level, the difficulty of drawing each feature, and the character's mood.

The function should use advanced logical operators to determine the success of drawing each feature, create a string representation of the drawn head using advanced string concatenation, and sort the artist's thoughts using an advanced sorting algorithm.

Parameters:
- skillLevel (int): The artist's skill level, ranging from 1 to 10.
- features (String[]): An array of facial features (e.g., "eyes", "nose", "mouth", "ears", "hair").
- difficulties (int[]): An array representing the difficulty of drawing each feature, ranging from 1 to 10. This array corresponds to the features array.
- mood (String): The character's mood (e.g., "happy", "sad", "angry").

The function returns a String array containing two elements:
- A string representation of the drawn character's head.
- A sorted string array of the artist's thoughts.

Follow these rules to implement the function:
- Use the logical operator && to determine if a feature is successfully drawn: (skillLevel >= difficulties[i]) && (Math.random() < 0.7).
- For each successfully drawn feature, add a detailed description to the head representation. For failed attempts, add a basic placeholder.
- Generate thoughts for the artist based on the drawing process (e.g., "The eyes are challenging!" for a difficult feature).
- Sort the artist's thoughts alphabetically, ignoring case. If two thoughts start with the same letter, sort them based on their length in descending order.
- Incorporate the character's mood into the final head representation.

Note: Since we can't use random functions in the actual implementation, replace Math.random() with a deterministic alternative in your solution.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class drawCharacterHead {
    public static String[] drawCharacterHead(int skillLevel, String[] features, int[] difficulties, String mood) {
        StringBuilder headRepresentation = new StringBuilder();
        ArrayList<String> thoughts = new ArrayList<>();

        for (int i = 0; i < features.length; i++) {
            boolean success = (skillLevel >= difficulties[i]) && (0.5 < 0.7); // Deterministic alternative

            if (success) {
                switch (features[i]) {
                    case "eyes":
                        headRepresentation.append("Expressive almond-shaped eyes with a twinkle\n");
                        break;
                    case "nose":
                        headRepresentation.append("A perfectly proportioned nose\n");
                        break;
                    case "mouth":
                        headRepresentation.append("A mouth with well-defined lips\n");
                        break;
                    case "ears":
                        headRepresentation.append("Ears with intricate details\n");
                        break;
                    case "hair":
                        headRepresentation.append("Flowing, textured hair\n");
                        break;
                }
                thoughts.add("The " + features[i] + " turned out great!");
            } else {
                headRepresentation.append("Basic " + features[i] + "\n");
                thoughts.add("The " + features[i] + " are challenging!");
            }
        }

        headRepresentation.append("The character looks " + mood);

        String[] sortedThoughts = thoughts.toArray(new String[0]);
        Arrays.sort(sortedThoughts, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char c1 = Character.toLowerCase(s1.charAt(0));
                char c2 = Character.toLowerCase(s2.charAt(0));
                if (c1 == c2) {
                    return s2.length() - s1.length();
                }
                return c1 - c2;
            }
        });

        return new String[]{headRepresentation.toString(), Arrays.toString(sortedThoughts)};
    }
}
