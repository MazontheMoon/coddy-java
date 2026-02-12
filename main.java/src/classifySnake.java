import java.util.Arrays;

class ClassifySnake {
    public static String[] classifySnake(float length, String pattern, int[] colorRGB, float venomPotency, float heatSignature, String[] behaviorTraits, int scaleCount, String habitatPreference) {
        // Calculate unique identifier
        double uniqueIdentifier = (length * scaleCount) + (colorRGB[0] * 0.3 + colorRGB[1] * 0.59 + colorRGB[2] * 0.11);

        // Determine species
        String species;
        if (uniqueIdentifier < 500) {
            species = "Common Garter Snake";
        } else if (uniqueIdentifier < 1000) {
            species = "Eastern Ratsnake";
        } else if (uniqueIdentifier < 1500) {
            species = "Timber Rattlesnake";
        } else if (uniqueIdentifier < 2000) {
            species = "Copperhead";
        } else {
            species = "Eastern Coral Snake";
        }

        // Calculate rarity score
        double rarityScore = 100 * (1 - Math.exp(-uniqueIdentifier / 1000));

        // Assess danger level
        int dangerLevel = Math.round(venomPotency * 10 + heatSignature / 10);

        // Determine conservation status
        String conservationStatus;
        if (rarityScore > 90) {
            conservationStatus = "Critically Endangered";
        } else if (rarityScore > 70) {
            conservationStatus = "Endangered";
        } else if (rarityScore > 50) {
            conservationStatus = "Vulnerable";
        } else if (rarityScore > 30) {
            conservationStatus = "Near Threatened";
        } else {
            conservationStatus = "Least Concern";
        }

        // Prepare and return the result
        return new String[]{
            species,
            String.format("%.2f%%", rarityScore),
            String.valueOf(Math.min(dangerLevel, 10)),
            conservationStatus
        };
    }
}
