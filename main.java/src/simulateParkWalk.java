import java.util.Arrays;

class SimulateParkWalk {
    public static String simulateParkWalk(int numSteps, String[] parkFeatures, boolean isMisty) {
        StringBuilder walkDescription = new StringBuilder();
        String atmosphere = isMisty ? "misty" : "clear";
        walkDescription.append("Starting a " + atmosphere + " morning walk through the park.\n");

        for (int step = 0; step < numSteps; step++) {
            String currentFeature = parkFeatures[step % parkFeatures.length];
            boolean seeChildren = (step % 3 == 0);
            boolean seeAdults = (step % 2 == 0);

            if (currentFeature.equals("playground") && !seeChildren) {
                continue;
            }

            walkDescription.append("Step " + (step + 1) + ": ");

            if (isMisty) {
                walkDescription.append("Through the mist, I see a " + currentFeature + ". ");
            } else {
                walkDescription.append("I approach a " + currentFeature + ". ");
            }

            if (seeChildren && seeAdults) {
                walkDescription.append("Families are enjoying the park. ");
            } else if (seeChildren) {
                walkDescription.append("Children are playing nearby. ");
            } else if (seeAdults) {
                walkDescription.append("Adults are strolling around. ");
            }

            if (currentFeature.equals("pond") && (seeChildren || seeAdults)) {
                walkDescription.append("People are feeding the ducks. ");
            }

            if (step == numSteps - 1 || currentFeature.equals("bench")) {
                walkDescription.append("I decide to rest for a moment.\n");
                break;
            }

            walkDescription.append("\n");
        }

        walkDescription.append("The walk ends as the " + atmosphere + " morning continues.");
        return walkDescription.toString();
    }
}
