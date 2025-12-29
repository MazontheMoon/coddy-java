/*Create a function named analyzeJungleEcology that receives initialPopulations, observationProbabilities, studySessions, newObservations, and currentDay as its parameters.

The function simulates a complex ecological study of rare animal populations in an uncharted jungle, incorporating advanced probability concepts and mathematical operations.

Your task is to implement the following analyses:

Update population estimates for each species using Bayes' theorem
Calculate the expected value of the total population across all species
Compute the variance of the total population
Calculate a measure of biodiversity using the Shannon diversity index
Determine a seasonal activity index for each species based on the day of the year
Parameters:

initialPopulations (int[]): Initial population estimates for different rare animal species
observationProbabilities (float[]): Probability of observing each species during a study session
studySessions (int): Number of study sessions conducted
newObservations (float[]): New observations for each species (as a proportion of the initial estimate)
currentDay (float): Current day of the year (0-365)
The function returns a string array containing the analysis results in the following order:

Updated population estimates for each species
Expected value of the total population
Variance of the total population
Shannon diversity index
Seasonal activity index for each species
Note: Use mathematical constants π (Math.PI) and e (Math.E) where necessary. Round all floating-point results to 2 decimal places.*/

import java.util.Arrays;

class AnalyzeJungleEcology {
    public static String[] analyzeJungleEcology(int[] initialPopulations, float[] observationProbabilities, int studySessions, float[] newObservations, float currentDay) {
        // Step 1: Update population estimates using Bayes' theorem
        double[] updatedPopulations = new double[initialPopulations.length];
        for (int i = 0; i < initialPopulations.length; i++) {
            double prior = initialPopulations[i];
            double likelihood = Math.pow(observationProbabilities[i], studySessions);
            double evidence = newObservations[i] * initialPopulations[i];
            updatedPopulations[i] = (likelihood * prior) / evidence;
        }

        // Step 2: Calculate expected value of total population
        double expectedValue = Arrays.stream(updatedPopulations).sum();

        // Step 3: Compute variance of total population
        double variance = Arrays.stream(updatedPopulations)
                .map(p -> Math.pow(p - expectedValue / updatedPopulations.length, 2))
                .sum() / updatedPopulations.length;

        // Step 4: Calculate Shannon diversity index
        double totalPopulation = Arrays.stream(updatedPopulations).sum();
        double shannonIndex = -Arrays.stream(updatedPopulations)
                .map(p -> (p / totalPopulation) * Math.log(p / totalPopulation))
                .sum() / Math.log(2);

        // Step 5: Determine seasonal activity index
        double[] seasonalActivityIndex = new double[initialPopulations.length];
        for (int i = 0; i < initialPopulations.length; i++) {
            seasonalActivityIndex[i] = 0.5 + 0.5 * Math.sin(2 * Math.PI * (currentDay / 365 + i / (double) initialPopulations.length));
        }

        // Prepare results
        String[] results = new String[5];
        results[0] = Arrays.toString(Arrays.stream(updatedPopulations).map(p -> Math.round(p * 100.0) / 100.0).toArray());
        results[1] = String.format("%.2f", expectedValue);
        results[2] = String.format("%.2f", variance);
        results[3] = String.format("%.2f", shannonIndex);
        results[4] = Arrays.toString(Arrays.stream(seasonalActivityIndex).map(p -> Math.round(p * 100.0) / 100.0).toArray());

        return results;
    }
}
