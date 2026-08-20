import java.util.Arrays;

class IslandSurvivalSimulation {
    public static int islandSurvivalSimulation(int initialFood, int initialWater, boolean[] tools, int[] resources, int[] weather, int rescueDays) {
        int food = initialFood;
        int water = initialWater;
        int energy = 100;
        int shelter = 0;
        int days = 0;

        while (days < rescueDays && food > 0 && water > 0 && energy > 0) {
            int dailyWeather = weather[days % weather.length];
            
            // Consume resources
            food--;
            water--;
            energy = Math.min(100, energy + 10);

            // Perform survival activities
            if (dailyWeather != 2) { // Not stormy
                if (shelter < 100) {
                    shelter = buildShelter(shelter, tools, resources);
                } else {
                    int[] result = searchForResources(tools, resources, dailyWeather);
                    food += result[0];
                    water += result[1];
                }
                energy -= 20;
            } else {
                energy -= 10; // Less energy consumed during storms
            }

            // Handle rain
            if (dailyWeather == 1) {
                water = Math.min(water + 2, initialWater * 2);
            }

            // Unexpected events
            if (days % 7 == 0 && days > 0) {
                handleUnexpectedEvent(tools, resources);
            }

            days++;
        }

        return Math.min(days, rescueDays);
    }

    private static int buildShelter(int currentShelter, boolean[] tools, int[] resources) {
        boolean hasAxe = tools[0];
        boolean hasRope = tools[2];
        int wood = resources[2];

        if ((hasAxe ^ hasRope) && wood > 0) {
            return Math.min(100, currentShelter + 10);
        } else if (hasAxe && hasRope && wood > 1) {
            return Math.min(100, currentShelter + 20);
        }
        return currentShelter + 5;
    }

    private static int[] searchForResources(boolean[] tools, int[] resources, int weather) {
        int foodFound = 0;
        int waterFound = 0;

        boolean canFish = tools[1] && resources[1] > 0;
        boolean canForage = resources[0] > 0;

        if (weather == 0 && (canFish ^ canForage)) { // Sunny and can either fish or forage
            foodFound += 2;
        } else if (!(canFish | canForage)) { // Can neither fish nor forage
            foodFound += 1;
        }

        if (tools[3] && weather != 0) { // Has container and not sunny
            waterFound += 1;
        }

        return new int[]{foodFound, waterFound};
    }

    private static void handleUnexpectedEvent(boolean[] tools, int[] resources) {
        int eventType = (int) (Math.random() * 3);
        switch (eventType) {
            case 0: // Tool breaks
                int toolIndex = (int) (Math.random() * tools.length);
                tools[toolIndex] = false;
                break;
            case 1: // Resource depletion
                int resourceIndex = (int) (Math.random() * resources.length);
                resources[resourceIndex] = Math.max(0, resources[resourceIndex] - 1);
                break;
            case 2: // Resource abundance
                resourceIndex = (int) (Math.random() * resources.length);
                resources[resourceIndex] += 2;
                break;
        }
    }
}