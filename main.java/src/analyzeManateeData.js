

import java.util.regex.Pattern;

class AnalyzeManateeData {
    public static String[] analyzeManateeData(String binaryData, int manateeCount) {
        if (!isValidInput(binaryData, manateeCount)) {
            return new String[]{"Error: Invalid input"};
        }

        String[] result = new String[manateeCount];
        for (int i = 0; i < manateeCount; i++) {
            int startIndex = i * 41;
            long data = Long.parseLong(binaryData.substring(startIndex, startIndex + 41), 2);

            int id = (int) (data >> 36) & 0x1F;
            int x = (int) (data >> 26) & 0x3FF;
            int y = (int) (data >> 16) & 0x3FF;
            int behaviorCode = (int) (data >> 12) & 0xF;
            int time = (int) data & 0xFFF;

            String behavior = decodeBehavior(behaviorCode);
            String formattedTime = formatTime(time);

            result[i] = String.format("Manatee #%d: (%d, %d) - %s at %s", id, x, y, behavior, formattedTime);
        }

        return result;
    }

    private static boolean isValidInput(String binaryData, int manateeCount) {
        return Pattern.matches("^[01]+$", binaryData) && binaryData.length() == 41 * manateeCount;
    }

    private static String decodeBehavior(int code) {
        switch (code) {
            case 0: return "Resting";
            case 1: return "Feeding";
            case 2: return "Swimming";
            case 3: return "Playing";
            case 4: return "Surfacing";
            default: return "Unknown";
        }
    }

    private static String formatTime(int time) {
        int hours = time / 60;
        int minutes = time % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
}