import java.util.Arrays;

class AnalyzeDonatianPatterns {
    public static String analyzeDonatianPatterns(int[][] donations) {
        // Reverse the order of donations for each member
        for (int[] row : donations) {
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length - 1 - i];
                row[row.length - 1 - i] = temp;
            }
        }

        // Calculate the average donation for each week
        double[] averages = new double[donations[0].length];
        int[] totals = new int[donations[0].length];
        for (int i = 0; i < donations[0].length; i++) {
            int sum = 0;
            for (int[] member : donations) {
                sum += member[i];
            }
            totals[i] = sum;
            averages[i] = (double) sum / donations.length;
        }

        // Find the week with the highest total donations
        int highestWeek = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > totals[highestWeek]) {
                highestWeek = i;
            }
        }

        // Format the averages
        StringBuilder averagesStr = new StringBuilder();
        for (int i = 0; i < averages.length; i++) {
            averagesStr.append(String.format("%.2f", averages[i]));
            if (i < averages.length - 1) {
                averagesStr.append(", ");
            }
        }

        // Return the summary string
        return String.format("Highest donation week: %d, Average donations: %s", highestWeek + 1, averagesStr.toString());
    }
}
