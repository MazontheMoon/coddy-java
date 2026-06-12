import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DecodeGiantMessage {
    public static String decodeGiantMessage(String[] encodedMessage, int strideLength, float slopeAngle) {
        List<Character> decodedChars = new ArrayList<>();
        List<Integer> originalIndices = new ArrayList<>();
        double cosAngle = Math.cos(Math.toRadians(slopeAngle));

        for (int i = 0; i < encodedMessage.length; i += strideLength) {
            String word = encodedMessage[i];
            for (char c : word.toCharArray()) {
                int transformedAscii = (int) Math.round((int) c * cosAngle);
                decodedChars.add((char) transformedAscii);
                originalIndices.add(i);
            }
        }

        List<Integer> sortedIndices = new ArrayList<>(originalIndices);
        Collections.sort(sortedIndices);

        StringBuilder decodedMessage = new StringBuilder();
        for (int index : sortedIndices) {
            int charIndex = originalIndices.indexOf(index);
            decodedMessage.append(decodedChars.get(charIndex));
            originalIndices.set(charIndex, -1); // Mark as used
        }

        return decodedMessage.toString();
    }
}