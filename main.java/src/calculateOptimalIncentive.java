import java.util.Arrays;
import java.util.Random;

class CalculateOptimalIncentive {
    public static String[] calculateOptimalIncentive(float[] tenantSatisfaction, float[] windowDraftiness, int[] currentRent, int marketRent, int maintenanceCost, float seasonalFactor, float economicOutlook) {
        int numTenants = tenantSatisfaction.length;
        String[] strategies = new String[numTenants];
        Random random = new Random(42); // Seed for reproducibility

        for (int i = 0; i < numTenants; i++) {
            double satisfactionProbability = tenantSatisfaction[i];
            double draftinessProbability = windowDraftiness[i] * seasonalFactor;
            double rentDifference = (marketRent - currentRent[i]) / (double) marketRent;

            // Complex logical conditions using XOR, NAND, NOR, Implication, and Biconditional operators
            boolean condition1 = (satisfactionProbability > 0.7) ^ (draftinessProbability < 0.4);
            boolean condition2 = !((rentDifference > 0.1) && (economicOutlook < 0.5));
            boolean condition3 = !(satisfactionProbability < 0.6 || draftinessProbability > 0.6);
            boolean condition4 = (satisfactionProbability > 0.8) == (rentDifference < 0.05);

            // Probability distributions and Bayes' theorem
            double priorProbStaying = satisfactionProbability * (1 - draftinessProbability);
            double likelihoodStayingGivenIncentive = 0.8;
            double posteriorProbStaying = (likelihoodStayingGivenIncentive * priorProbStaying) /
                    ((likelihoodStayingGivenIncentive * priorProbStaying) + (1 - priorProbStaying));

            // Expected value and variance calculations
            double expectedValueNoAction = currentRent[i] * priorProbStaying * 12;
            double expectedValueIncentive = (currentRent[i] * 0.95) * posteriorProbStaying * 12;
            double varianceNoAction = Math.pow(currentRent[i] * 12, 2) * priorProbStaying * (1 - priorProbStaying);
            double varianceIncentive = Math.pow(currentRent[i] * 0.95 * 12, 2) * posteriorProbStaying * (1 - posteriorProbStaying);

            // Central Limit Theorem application (simplified)
            double zScore = (expectedValueIncentive - expectedValueNoAction) / Math.sqrt((varianceNoAction + varianceIncentive) / numTenants);

            // Risk assessment
            double riskFactor = (1 - economicOutlook) * draftinessProbability * (1 - satisfactionProbability);

            // Decision making
            if (condition1 && condition2 && zScore > 1.96) {
                strategies[i] = "Rent Reduction";
            } else if (condition3 && draftinessProbability > 0.5 && riskFactor < 0.3) {
                strategies[i] = "Window Improvement";
            } else if (condition4 && economicOutlook > 0.7 && random.nextDouble() < posteriorProbStaying) {
                strategies[i] = "Offer Perks";
            } else {
                strategies[i] = "No Action";
            }
        }

        return strategies;
    }
}
