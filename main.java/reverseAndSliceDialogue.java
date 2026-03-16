import java.util.Arrays;

class ReverseAndSliceDialogue {
    public static String[] reverseAndSliceDialogue(String[] dialogue, int wordsToKeep) {
        if (dialogue == null || dialogue.length == 0 || wordsToKeep <= 0) {
            return new String[0];
        }

        int n = dialogue.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String phrase = dialogue[n - 1 - i];
            String[] words = phrase.split(" ");
            int keepCount = Math.min(words.length, wordsToKeep);
            result[i] = String.join(" ", Arrays.copyOfRange(words, 0, keepCount));
        }

        return result;
    }
}
