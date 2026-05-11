import java.util.*;

class PlanWeekendGetaway {
    public static String[] planWeekendGetaway(int[][] preferences, int[] budgets, int[][] activityCosts, int[] accommodationCosts) {
        int numFriends = preferences.length;
        int numActivities = preferences[0].length;
        
        // Calculate average preference scores
        double[] avgPreferences = new double[numActivities];
        for (int i = 0; i < numActivities; i++) {
            double sum = 0;
            for (int j = 0; j < numFriends; j++) {
                sum += preferences[j][i];
            }
            avgPreferences[i] = sum / numFriends;
        }
        
        // Sort activities based on average preference scores
        Integer[] activityIndices = new Integer[numActivities];
        for (int i = 0; i < numActivities; i++) {
            activityIndices[i] = i;
        }
        Arrays.sort(activityIndices, (a, b) -> Double.compare(avgPreferences[b], avgPreferences[a]));
        
        // Find lowest accommodation cost within budget
        int accommodationCost = Arrays.stream(accommodationCosts).filter(cost -> Arrays.stream(budgets).allMatch(budget -> budget >= cost)).min().orElse(0);
        
        // Plan activities for each day
        List<String> plan = new ArrayList<>();
        plan.add("Accommodation: $" + accommodationCost);
        
        int[] remainingBudgets = Arrays.copyOf(budgets, budgets.length);
        for (int i = 0; i < remainingBudgets.length; i++) {
            remainingBudgets[i] -= accommodationCost;
        }
        
        for (int day = 0; day < 2; day++) {
            StringBuilder dayPlan = new StringBuilder("Day " + (day + 1) + ": ");
            for (int activity : activityIndices) {
                int cost = activityCosts[day][activity];
                if (Arrays.stream(remainingBudgets).allMatch(budget -> budget >= cost)) {
                    dayPlan.append("Activity " + (activity + 1) + " ($" + cost + ") ");
                    for (int i = 0; i < remainingBudgets.length; i++) {
                        remainingBudgets[i] -= cost;
                    }
                    break;
                }
            }
            plan.add(dayPlan.toString().trim());
        }
        
        return plan.toArray(new String[0]);
    }
}
