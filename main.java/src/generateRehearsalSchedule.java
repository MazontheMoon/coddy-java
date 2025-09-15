/*
Create a function named generateRehearsalSchedule that receives numberOfGroups and availableDays as its parameters.
The function should generate a rehearsal schedule for musical groups in a small-town community center.
Use nested loops and basic logical operators to create a schedule where each group gets to rehearse on different days. If there are more groups than available days, some groups will have to share days.

Parameters:

- numberOfGroups (int): The number of musical groups (1 to 5)
- availableDays (int): The number of days available for rehearsals (1 to 7)

The function returns a string array representing the rehearsal schedule. Each string in the array should follow the format "Day X: Group Y" or "Day X: No rehearsal" if no group is scheduled for that day.

Handle cases where there might be more groups than days or vice versa. Ensure that each group gets a fair chance to rehearse, and distribute the rehearsal slots as evenly as possible.
*/

import java.util.Arrays;

class GenerateRehearsalSchedule {
    public static String[] generateRehearsalSchedule(int numberOfGroups, int availableDays) {
        String[] schedule = new String[availableDays];
        Arrays.fill(schedule, "No rehearsal");

        int currentGroup = 1;
        int daysAssigned = 0;

        for (int day = 0; day < availableDays; day++) {
            if (daysAssigned < numberOfGroups) {
                schedule[day] = String.format("Day %d: Group %d", day + 1, currentGroup);
                currentGroup++;
                daysAssigned++;
            } else if (numberOfGroups < availableDays) {
                schedule[day] = String.format("Day %d: No rehearsal", day + 1);
            } else {
                currentGroup = (currentGroup > numberOfGroups) ? 1 : currentGroup;
                schedule[day] = String.format("Day %d: Group %d", day + 1, currentGroup);
                currentGroup++;
            }
        }

        return schedule;
    }
}