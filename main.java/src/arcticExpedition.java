import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArcticExpedition {
    public static String arcticExpedition(String teamMembers, int[] temperatures, int days) {
        List<String> team = new ArrayList<>(Arrays.asList(teamMembers.split(",")));
        StringBuilder narrative = new StringBuilder();
        int[] expeditionTemps = Arrays.copyOf(temperatures, Math.min(days, temperatures.length));

        narrative.append(String.format("Starting team members: %s\n", String.join(", ", team)));

        boolean prevDayBelow25 = false;

        for (int day = 0; day < expeditionTemps.length; day++) {
            int temp = expeditionTemps[day];
            narrative.append(String.format("Day %d - Temperature: %d°C\n", day + 1, temp));

            if (day > 0) {
                int tempDrop = expeditionTemps[day - 1] - temp;
                if (tempDrop > 10 && !team.isEmpty()) {
                    String eliminated = team.remove(0);
                    narrative.append(String.format("%s didn't survive the sudden temperature drop.\n", eliminated));
                }
            }

            if (temp < -25) {
                if (prevDayBelow25 && !team.isEmpty()) {
                    String eliminated = team.remove(0);
                    narrative.append(String.format("%s didn't survive the prolonged extreme cold.\n", eliminated));
                }
                prevDayBelow25 = true;
            } else {
                prevDayBelow25 = false;
            }

            if (!team.isEmpty()) {
                narrative.append(String.format("Survivors: %s\n", String.join(", ", team)));
            } else {
                narrative.append("No survivors remain.\n");
                break;
            }
        }

        narrative.append("\nFinal Report:\n");
        if (!team.isEmpty()) {
            narrative.append(String.format("Survivors: %s\n", String.join(", ", team)));
        } else {
            narrative.append("No survivors.\n");
        }

        List<String> originalTeam = Arrays.asList(teamMembers.split(","));
        List<String> lost = new ArrayList<>(originalTeam);
        lost.removeAll(team);
        if (!lost.isEmpty()) {
            narrative.append(String.format("Lost team members: %s\n", String.join(", ", lost)));
        }

        return narrative.toString();
    }
}
