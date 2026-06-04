import java.util.*;

class MaritimeDisputeArbitrator {
    public static int[] maritimeDisputeArbitrator(int n, int[] claim1, int[] claim2, int maxValue) {
        int[] fairDistribution = new int[n];
        int maxFairness = -1;
        int maxMask = 1 << n;

        for (int mask = 0; mask < maxMask; mask++) {
            int[] distribution = new int[n];
            int fairness = calculateFairness(mask, claim1, claim2, maxValue);

            if (fairness > maxFairness && !exactMatch(mask, claim1) && !exactMatch(mask, claim2)) {
                maxFairness = fairness;
                for (int i = 0; i < n; i++) {
                    distribution[i] = (mask & (1 << i)) != 0 ? 1 : 0;
                }
                fairDistribution = distribution;
            }
        }

        return fairDistribution;
    }

    private static int calculateFairness(int mask, int[] claim1, int[] claim2, int maxValue) {
        int fairness = 0;
        for (int i = 0; i < claim1.length; i++) {
            if (((mask & (1 << i)) != 0) == (claim1[i] == 1)) {
                fairness += maxValue;
            }
            if (((mask & (1 << i)) == 0) == (claim2[i] == 1)) {
                fairness += maxValue;
            }
        }
        return fairness;
    }

    private static boolean exactMatch(int mask, int[] claim) {
        for (int i = 0; i < claim.length; i++) {
            if (((mask & (1 << i)) != 0) != (claim[i] == 1)) {
                return false;
            }
        }
        return true;
    }
}
