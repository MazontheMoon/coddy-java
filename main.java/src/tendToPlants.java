/*
Create a function named tendToPlants that receives plantHealth, plantTypes, and gardenerEnergy as its parameters.

The function simulates a gardener's day at the greenhouse, tending to various plants based on their health and type, while managing the gardener's energy level.

The gardener should tend to plants in the following manner:
- If a plant's health is below 50, the gardener will water it, increasing its health by 20.
- If a plant's health is between 50 and 80, the gardener will prune it, increasing its health by 10.
- If a plant's health is above 80, the gardener will skip it.
- If the plant is a "cactus", the gardener will always skip it, regardless of its health.
- Each action (watering or pruning) reduces the gardener's energy by 5. If the gardener's energy reaches 0, they must stop working for the day.

Parameters:
- plantHealth (int[]): An array representing the health of each plant (0-100).
- plantTypes (String[]): An array representing the types of plants (e.g., "rose", "tulip", "cactus").
- gardenerEnergy (int): An integer representing the gardener's initial energy level (0-100).

The function returns a String summarizing the gardener's day, including the number of plants watered, pruned, and skipped, as well as the gardener's remaining energy.
*/

import java.util.Arrays;

class TendToPlants {
    public static String tendToPlants(int[] plantHealth, String[] plantTypes, int gardenerEnergy) {
        int watered = 0;
        int pruned = 0;
        int skipped = 0;

        for (int i = 0; i < plantHealth.length; i++) {
            if (gardenerEnergy < 5) {
                skipped += plantHealth.length - i;
                break;
            }

            if (plantTypes[i].equals("cactus")) {
                skipped++;
                continue;
            }

            if (plantHealth[i] < 50) {
                plantHealth[i] += 20;
                watered++;
                gardenerEnergy -= 5;
            } else if (plantHealth[i] <= 80) {
                plantHealth[i] += 10;
                pruned++;
                gardenerEnergy -= 5;
            } else {
                skipped++;
            }
        }

        return String.format("Plants watered: %d, pruned: %d, skipped: %d. Gardener's remaining energy: %d",
                watered, pruned, skipped, gardenerEnergy);
    }
}