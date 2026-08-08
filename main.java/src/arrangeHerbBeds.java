import java.util.ArrayList;
import java.util.List;

public static String[][] arrangeHerbBeds(String[] herbs, int bedsPerRow) {
    List<String[]> rows = new ArrayList<>();

    for (int i = 0; i < herbs.length; i += bedsPerRow) {
        int end = Math.min(i + bedsPerRow, herbs.length);

        String[] row = new String[end - i];

        for (int j = i; j < end; j++) {
            row[j - i] = herbs[j];
        }

        rows.add(row);
    }

    return rows.toArray(new String[0][]);
}