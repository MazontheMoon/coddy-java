import java.util.ArrayList;

class BeautySalonWhisper {
    public static String beautySalonWhisper(String sentence, int whisperCount) {
        ArrayList<String> whispers = new ArrayList<>();
        String currentWhisper = sentence.toLowerCase().replace(' ', '_');
        whispers.add(currentWhisper);

        for (int i = 1; i < whisperCount; i++) {
            int newLength = currentWhisper.length() - (currentWhisper.length() / (whisperCount - 1));
            if (newLength < 1) {
                newLength = 1;
            }
            currentWhisper = currentWhisper.substring(0, newLength);
            whispers.add(currentWhisper);
        }

        return String.join("\n", whispers);
    }
}