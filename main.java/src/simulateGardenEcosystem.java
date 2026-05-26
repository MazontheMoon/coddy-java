import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class SimulateGardenEcosystem {
    public static String simulateGardenEcosystem(int days, String[] plantSpecies, int[] initialQuantities, float[] growthRates, String[] environmentalFactors, int[] factorFrequencies, String[] chemicalCompounds, float[] compoundRates) {
        // Validate input
        if (days < 1 || days > 365 || plantSpecies.length < 1 || plantSpecies.length > 10 ||
            plantSpecies.length != initialQuantities.length || plantSpecies.length != growthRates.length ||
            environmentalFactors.length != factorFrequencies.length || plantSpecies.length != chemicalCompounds.length ||
            plantSpecies.length != compoundRates.length) {
            return "Invalid input parameters";
        }

        // Initialize data structures
        Map<String, Integer> plantQuantities = new HashMap<>();
        Map<String, Float> chemicalProduction = new HashMap<>();
        Map<String, Integer> environmentalEffects = new HashMap<>();

        for (int i = 0; i < plantSpecies.length; i++) {
            plantQuantities.put(plantSpecies[i], initialQuantities[i]);
            chemicalProduction.put(chemicalCompounds[i], 0.0f);
        }

        for (String factor : environmentalFactors) {
            environmentalEffects.put(factor, 0);
        }

        // Simulate garden ecosystem
        for (int day = 1; day <= days; day++) {
            String currentFactor = getEnvironmentalFactor(day, environmentalFactors, factorFrequencies);
            environmentalEffects.put(currentFactor, environmentalEffects.get(currentFactor) + 1);

            for (int i = 0; i < plantSpecies.length; i++) {
                String plant = plantSpecies[i];
                int quantity = plantQuantities.get(plant);
                float growthRate = growthRates[i];

                // Apply environmental effects
                float effectMultiplier = getEnvironmentalEffect(currentFactor, plant);
                int newQuantity = Math.max(0, (int) (quantity + quantity * growthRate * effectMultiplier));
                plantQuantities.put(plant, newQuantity);

                // Chemical production
                float production = newQuantity * compoundRates[i];
                chemicalProduction.put(chemicalCompounds[i], chemicalProduction.get(chemicalCompounds[i]) + production);
            }
        }

        // Generate report
        StringBuilder report = new StringBuilder();
        report.append("Garden Ecosystem Simulation Report\n");
        report.append("===================================\n\n");

        report.append("Final Plant Quantities:\n");
        for (String plant : plantSpecies) {
            report.append(String.format("  %s: %d\n", plant, plantQuantities.get(plant)));
        }
        report.append("\n");

        report.append("Total Chemical Compounds Produced:\n");
        for (String compound : chemicalCompounds) {
            report.append(String.format("  %s: %.2f\n", compound, chemicalProduction.get(compound)));
        }
        report.append("\n");

        report.append("Environmental Factors Summary:\n");
        for (String factor : environmentalFactors) {
            report.append(String.format("  %s: %d days\n", factor, environmentalEffects.get(factor)));
        }
        report.append("\n");

        String mostProlificPlant = getMostProlific(plantQuantities);
        String mostAbundantCompound = getMostAbundant(chemicalProduction);

        report.append(String.format("Most Prolific Plant Species: %s\n", mostProlificPlant));
        report.append(String.format("Most Abundant Chemical Compound: %s\n", mostAbundantCompound));

        return report.toString();
    }

    private static String getEnvironmentalFactor(int day, String[] factors, int[] frequencies) {
        int totalFrequency = 0;
        for (int freq : frequencies) {
            totalFrequency += freq;
        }
        int index = (day - 1) % totalFrequency;
        for (int i = 0; i < frequencies.length; i++) {
            if (index < frequencies[i]) {
                return factors[i];
            }
            index -= frequencies[i];
        }
        return factors[0]; // Fallback
    }

    private static float getEnvironmentalEffect(String factor, String plant) {
        // Simplified environmental effects
        if (factor.equals("sunny") && plant.matches(".*[aeiouAEIOU].*")) {
            return 1.1f;
        } else if (factor.equals("rainy") && plant.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*")) {
            return 1.2f;
        } else if (factor.equals("windy")) {
            return 0.9f;
        }
        return 1.0f;
    }

    private static String getMostProlific(Map<String, Integer> quantities) {
        return quantities.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
    }

    private static String getMostAbundant(Map<String, Float> production) {
        return production.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
    }
}
