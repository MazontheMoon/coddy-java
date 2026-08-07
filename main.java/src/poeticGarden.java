import java.util.Arrays;

class PoeticGarden {
    public static String poeticGarden(String word, int size) {
        StringBuilder garden = new StringBuilder();
        int wordLength = word.length();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                for (int k = 0; k < wordLength; k++) {
                    int index = (i + j + k) % wordLength;
                    garden.append(word.charAt(index));
                }
            }
            if (i < size - 1) {
                garden.append("\n");
            }
        }

        return garden.toString();
    }
}