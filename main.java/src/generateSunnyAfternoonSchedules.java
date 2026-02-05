import java.util.*;

class GenerateSunnyAfternoonSchedules {
    public static String[][] generateSunnyAfternoonSchedules(int numActivities, int timeSlots, String[] activityNames, int[] activityDurations, int maxActivities) {
        List<String[]> schedules = new ArrayList<>();
        generateSchedules(numActivities, timeSlots, activityNames, activityDurations, maxActivities, new boolean[numActivities], new String[timeSlots], 0, 0, schedules);
        return schedules.toArray(new String[schedules.size()][]);
    }

    private static void generateSchedules(int numActivities, int timeSlots, String[] activityNames, int[] activityDurations, int maxActivities, boolean[] used, String[] currentSchedule, int currentSlot, int activitiesUsed, List<String[]> schedules) {
        if (currentSlot == timeSlots || activitiesUsed == maxActivities) {
            while (currentSlot < timeSlots) {
                currentSchedule[currentSlot++] = "Free Time";
            }
            schedules.add(currentSchedule.clone());
            return;
        }

        // Try adding "Free Time"
        currentSchedule[currentSlot] = "Free Time";
        generateSchedules(numActivities, timeSlots, activityNames, activityDurations, maxActivities, used, currentSchedule, currentSlot + 1, activitiesUsed, schedules);

        // Try adding activities
        for (int i = 0; i < numActivities; i++) {
            if (!used[i] && currentSlot + activityDurations[i] <= timeSlots) {
                used[i] = true;
                for (int j = 0; j < activityDurations[i]; j++) {
                    currentSchedule[currentSlot + j] = activityNames[i];
                }
                generateSchedules(numActivities, timeSlots, activityNames, activityDurations, maxActivities, used, currentSchedule, currentSlot + activityDurations[i], activitiesUsed + 1, schedules);
                used[i] = false;
                for (int j = 0; j < activityDurations[i]; j++) {
                    currentSchedule[currentSlot + j] = null;
                }
            }
        }
    }
}
