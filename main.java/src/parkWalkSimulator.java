import java.util.Arrays;

class ParkWalkSimulator {
    public static String parkWalkSimulator(int numTrees, int walkDuration, boolean isWeekend, String[] observations, int energyLevel) {
        StringBuilder description = new StringBuilder();

        // Greeting
        description.append(isWeekend ? "Happy weekend! " : "Welcome to a lovely day! ");
        description.append(String.format("You're about to enjoy a %d-minute walk in the park.\n", walkDuration));

        // Tree description
        String[] treeAdj = {"majestic", "towering", "leafy", "ancient", "colorful"};
        description.append(String.format("You encounter %d %s trees along your path.\n", numTrees, treeAdj[numTrees % 5]));

        // Observations
        description.append("During your walk, you observe: ");
        if (observations.length == 0) {
            description.append("nothing in particular. It's a quiet day.\n");
        } else {
            for (int i = 0; i < observations.length; i++) {
                if (i == 3 && observations.length > 4) {
                    description.append("and more. It's a lively day!\n");
                    break;
                }
                description.append(observations[i]);
                if (i == observations.length - 1) {
                    description.append(".\n");
                } else if (i == observations.length - 2) {
                    description.append(", and ");
                } else {
                    description.append(", ");
                }
            }
        }

        // Conclusion
        String feeling = (walkDuration <= 30 && energyLevel >= 7) ? "invigorated" :
                         (walkDuration > 90 || energyLevel <= 3) ? "tired" : "refreshed";
        description.append(String.format("After %d minutes, you feel %s. ", walkDuration, feeling));
        description.append(String.format("Your energy level is now at %d/10.", Math.max(1, Math.min(10, energyLevel + (walkDuration > 60 ? -1 : 1)))));

        return description.toString();
    }
}