import java.util.HashMap;
import java.util.Map;

class DetermineApartmentRules {
    public static String determineApartmentRules(String[] roommates, String[] proposedRules) {
        Map<String, Long> votingPower = new HashMap<>();
        Map<String, Long> ruleVotes = new HashMap<>();

        // Calculate voting power for each roommate
        for (String name : roommates) {
            long hash = calculateHash(name);
            long reversedHash = reverseHash(hash);
            votingPower.put(name, reversedHash);
        }

        // Count votes
        for (int i = 0; i < roommates.length; i++) {
            String rule = proposedRules[i];
            long votes = votingPower.get(roommates[i]);
            ruleVotes.put(rule, ruleVotes.getOrDefault(rule, 0L) + votes);
        }

        // Find the winning rule
        String winningRule = "";
        long maxVotes = 0;
        for (Map.Entry<String, Long> entry : ruleVotes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winningRule = entry.getKey();
            } else if (entry.getValue() == maxVotes) {
                // Tie-breaker: choose the rule proposed by the roommate with highest voting power
                int index1 = indexOf(proposedRules, winningRule);
                int index2 = indexOf(proposedRules, entry.getKey());
                if (votingPower.get(roommates[index2]) > votingPower.get(roommates[index1])) {
                    winningRule = entry.getKey();
                }
            }
        }

        // Check if the decision is unanimous
        boolean unanimous = ruleVotes.size() == 1;

        return (unanimous ? "Unanimous: " : "Majority: ") + winningRule;
    }

    private static long calculateHash(String name) {
        long hash = 0;
        for (char c : name.toCharArray()) {
            hash = 31 * hash + c;
        }
        return Math.abs(hash);
    }

    private static long reverseHash(long hash) {
        String reversed = new StringBuilder(String.valueOf(hash)).reverse().toString();
        return Long.parseLong(reversed);
    }

    private static int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}
