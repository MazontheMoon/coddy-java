import java.util.Arrays;

class AnalyzePharyngoscopyData {
    public static String[][] analyzePharyngoscopyData(int[] rawData, int bitMask, String[] regionLabels) {
        int dataPointsPerRegion = rawData.length / regionLabels.length;
        String[][] result = new String[regionLabels.length][4];
        
        int trailingZeros = Integer.numberOfTrailingZeros(bitMask);
        
        for (int i = 0; i < regionLabels.length; i++) {
            int startIndex = i * dataPointsPerRegion;
            int endIndex = (i + 1) * dataPointsPerRegion;
            
            int[] processedData = Arrays.stream(rawData, startIndex, endIndex)
                .map(data -> (data & bitMask) >> trailingZeros)
                .toArray();
            
            double average = Arrays.stream(processedData).average().orElse(0);
            int peak = Arrays.stream(processedData).max().orElse(0);
            long anomalies = Arrays.stream(processedData)
                .filter(value -> value > average * 1.5)
                .count();
            
            result[i][0] = regionLabels[i];
            result[i][1] = String.format("%.2f", average);
            result[i][2] = String.valueOf(peak);
            result[i][3] = String.valueOf(anomalies);
        }
        
        return result;
    }
}
