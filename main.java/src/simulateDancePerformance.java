import java.util.LinkedList;

class SimulateDancePerformance {
    public static String simulateDancePerformance(String movements, int[] stagePositions) {
        // Reverse the dancer's movements
        String[] movementArray = movements.split("_");
        StringBuilder reversedMovements = new StringBuilder();
        for (int i = movementArray.length - 1; i >= 0; i--) {
            reversedMovements.append(new StringBuilder(movementArray[i]).reverse());
            if (i > 0) {
                reversedMovements.append("_");
            }
        }

        // Create a linked list from stage positions
        LinkedList<Integer> positionsList = new LinkedList<>();
        for (int position : stagePositions) {
            positionsList.add(position);
        }

        // Calculate dance score
        int sum = 0;
        int product = 1;
        for (int i = 0; i < stagePositions.length; i++) {
            if (i % 2 == 0) {
                sum += stagePositions[i];
            } else {
                product *= stagePositions[i];
            }
        }
        int danceScore = product - sum;

        // Generate performance summary
        StringBuilder summary = new StringBuilder();
        summary.append(reversedMovements).append("\n");
        summary.append("LinkedList: ").append(positionsList).append("\n");
        summary.append("Dance Score: ").append(danceScore);

        return summary.toString();
    }
}
