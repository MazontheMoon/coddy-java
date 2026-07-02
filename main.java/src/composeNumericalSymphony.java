import java.util.*;

class ComposeNumericalSymphony {
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private static final String[] DURATIONS = {"w", "h", "q", "e", "s"};
    private static final String[] DYNAMICS = {"pp", "p", "mp", "mf", "f", "ff"};

    public static String composeNumericalSymphony(int[] bases, String[] numbers, int measures) {
        if (bases.length != numbers.length || measures <= 0) {
            return "Invalid input";
        }

        List<Integer> convertedNumbers = new ArrayList<>();
        for (int i = 0; i < bases.length; i++) {
            try {
                int num = Integer.parseInt(numbers[i], bases[i]);
                convertedNumbers.add(num);
            } catch (NumberFormatException e) {
                return "Invalid input";
            }
        }

        StringBuilder score = new StringBuilder();
        int keySignature = convertedNumbers.get(0) % 12;
        int timeSignature = (convertedNumbers.get(1) % 3) + 2;

        for (int measure = 0; measure < measures; measure++) {
            int beatCount = 0;
            for (int i = 0; i < convertedNumbers.size() && beatCount < timeSignature; i++) {
                int num = convertedNumbers.get(i);
                String note = NOTES[(num + keySignature) % 12];
                String duration = DURATIONS[num % 5];
                String dynamic = DYNAMICS[num % 6];

                char encodedNote = (char) (((num % 12) << 4) | (num % 5));
                score.append(encodedNote);

                beatCount += getDurationValue(duration);
            }
            if (beatCount < timeSignature) {
                score.append('R'); // Rest to fill the measure
            }
        }

        return score.toString();
    }

    private static int getDurationValue(String duration) {
        switch (duration) {
            case "w": return 4;
            case "h": return 2;
            case "q": return 1;
            case "e": return 1;
            case "s": return 1;
            default: return 0;
        }
    }
}