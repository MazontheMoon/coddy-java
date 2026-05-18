import java.util.HashMap;
import java.util.Map;

class AnalyzeChildSymptoms {
    public static String analyzeChildSymptoms(String symptomDescription, int previousAttempts) {
        String reversedSymptoms = new StringBuilder(symptomDescription).reverse().toString();
        String[] symptoms = reversedSymptoms.split("[,.:; ]+");
        Map<String, Integer> symptomWeights = new HashMap<>();
        symptomWeights.put("fever", 3);
        symptomWeights.put("headache", 2);
        symptomWeights.put("stomachache", 2);
        symptomWeights.put("cough", 1);
        int genuinenessScore = 0;
        for (String symptom : symptoms) {
            for (Map.Entry<String, Integer> entry : symptomWeights.entrySet()) {
                if (symptom.toLowerCase().contains(entry.getKey())) {
                    genuinenessScore += entry.getValue();
                }
            }
        }
        int confidence = Math.max(0, Math.min(100, genuinenessScore * 10 - previousAttempts * 15));
        String diagnosis;
        if (confidence > 70) diagnosis = "Genuinely Ill";
        else if (confidence > 30) diagnosis = "Possibly Faking";
        else diagnosis = "Definitely Faking";
        return diagnosis + ": " + confidence + "%";
    }
}
