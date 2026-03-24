class ReverseDebate {
    public static String reverseDebate(String transcript, int[][] keyPhrases) {
        StringBuilder result = new StringBuilder();

        for (int[] phrase : keyPhrases) {
            int startIndex = phrase[0];
            int endIndex = phrase[1];

            String substring = transcript.substring(startIndex, endIndex);
            String reversedSubstring = reverseString(substring);

            result.append(reversedSubstring).append(" ");
        }

        return result.toString().trim();
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}