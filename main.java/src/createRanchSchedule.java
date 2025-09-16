/*
Create a function named createRanchSchedule that receives morningTasks and eveningTasks as its parameters.
The function should combine the morning and evening tasks into a formatted daily schedule for a ranchwoman on a remote cattle farm.

Follow these steps to create the schedule:
- Concatenate the morningTasks and eveningTasks arrays.
- Create a formatted string representing the daily schedule.
- Number each task and prefix it with either "Morning:" or "Evening:" based on its original array.
- Add a header and footer to the schedule.

Parameters:
- morningTasks (String[]): An array of strings representing morning tasks.
- eveningTasks (String[]): An array of strings representing evening tasks.

The function returns a String containing the formatted daily schedule.
*/

import java.util.ArrayList;
import java.util.List;

class CreateRanchSchedule {
    public static String createRanchSchedule(String[] morningTasks, String[] eveningTasks) {
        List<String> allTasks = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        // Concatenate morning and evening tasks
        for (String task : morningTasks) {
            allTasks.add("Morning: " + task);
        }
        for (String task : eveningTasks) {
            allTasks.add("Evening: " + task);
        }

        // Create formatted string
        schedule.append("=== Daily Ranch Schedule ===\n\n");
        for (int i = 0; i < allTasks.size(); i++) {
            schedule.append(String.format("%d. %s\n", i + 1, allTasks.get(i)));
        }
        schedule.append("\n=== End of Schedule ===");

        return schedule.toString();
    }
}