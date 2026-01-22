import java.util.ArrayList;
import java.util.List;

class ReportMeteorActivity {
    public static String reportMeteorActivity(int initialCount, int adjustments) {
        int count = initialCount;
        List<Integer> specialNumbers = new ArrayList<>();

        for (int i = 0; i < adjustments; i++) {
            if (count % 2 == 0) {
                count++;
            } else {
                count--;
            }

            if (count == 7 || count == 13 || count == 21) {
                specialNumbers.add(count);
            }
        }

        String specialNumbersStr = specialNumbers.isEmpty() ? "None" : String.join(", ", specialNumbers.stream().map(String::valueOf).toArray(String[]::new));

        return "Final count: " + count + ", Special numbers encountered: " + specialNumbersStr;
    }
}
