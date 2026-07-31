import java.util.HashMap;
import java.util.Map;

class AnalyzeLaboratoryData {
    public static String analyzeLaboratoryData(int[] experimentIds, String[] instruments, float[] results) {
        int totalExperiments = experimentIds.length;
        
        // Find the most frequently used instrument
        Map<String, Integer> instrumentFrequency = new HashMap<>();
        String mostUsedInstrument = "";
        int maxFrequency = 0;
        
        for (String instrument : instruments) {
            int frequency = instrumentFrequency.getOrDefault(instrument, 0) + 1;
            instrumentFrequency.put(instrument, frequency);
            
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostUsedInstrument = instrument;
            }
        }
        
        // Calculate the average result
        float sum = 0;
        float maxResult = Float.MIN_VALUE;
        int highestResultId = 0;
        
        for (int i = 0; i < results.length; i++) {
            sum += results[i];
            
            if (results[i] > maxResult) {
                maxResult = results[i];
                highestResultId = experimentIds[i];
            }
        }
        
        float averageResult = sum / totalExperiments;
        
        // Format the output string
        return String.format("Total experiments: %d, Most used instrument: %s, Average result: %.2f, Highest result experiment ID: %d",
                             totalExperiments, mostUsedInstrument, averageResult, highestResultId);
    }
}
