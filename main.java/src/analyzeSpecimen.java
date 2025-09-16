/*
Create a function named analyzeSpecimen that receives specimenType and reactionLevel as its parameters.

The function simulates a scientist's analysis of a specimen in a laboratory. It should return a string that describes the analysis result based on the specimen type and reaction level.

Use basic string concatenation and conditional statements (if-else) to determine the appropriate response. The analysis should cover three types of specimens: bacteria, virus, and fungus. For any other specimen type, return a message indicating it's unknown.

Parameters:
- specimenType (String): The type of specimen being analyzed (e.g., "bacteria", "virus", "fungus").
- reactionLevel (int): An integer representing the observed reaction level, ranging from 1 to 5.

The function returns a string describing the analysis result.

Use the following criteria for your analysis:
- For bacteria:
   - Low reaction levels (1-2): "Minimal bacterial activity observed."
   - Medium reaction levels (3-4): "Moderate bacterial growth detected."
   - High reaction level (5): "Significant bacterial proliferation identified."
- For viruses:
   - Low reaction levels (1-2): "Low viral load detected."
   - Medium reaction levels (3-4): "Moderate viral activity observed."
   - High reaction level (5): "High viral replication rate confirmed."
- For fungi:
   - Low reaction levels (1-2): "Slight fungal presence noted."
   - Medium reaction levels (3-4): "Moderate fungal growth observed."
   - High reaction level (5): "Extensive fungal colonization detected."
- For any other specimen type: "Unknown specimen type. Further analysis required."
*/

class AnalyzeSpecimen {
    public static String analyzeSpecimen(String specimenType, int reactionLevel) {
        String result = "";

        if (specimenType.equals("bacteria")) {
            if (reactionLevel <= 2) {
                result = "Minimal bacterial activity observed.";
            } else if (reactionLevel <= 4) {
                result = "Moderate bacterial growth detected.";
            } else {
                result = "Significant bacterial proliferation identified.";
            }
        } else if (specimenType.equals("virus")) {
            if (reactionLevel <= 2) {
                result = "Low viral load detected.";
            } else if (reactionLevel <= 4) {
                result = "Moderate viral activity observed.";
            } else {
                result = "High viral replication rate confirmed.";
            }
        } else if (specimenType.equals("fungus")) {
            if (reactionLevel <= 2) {
                result = "Slight fungal presence noted.";
            } else if (reactionLevel <= 4) {
                result = "Moderate fungal growth observed.";
            } else {
                result = "Extensive fungal colonization detected.";
            }
        } else {
            result = "Unknown specimen type. Further analysis required.";
        }

        return result;
    }
}