class SimulateTraffic {
    public static String simulateTraffic(int[][] pedestrianWaves, int[][] vehicleWaves, String[] trafficLights, int simulationTime) {
        int totalPedestrians = 0;
        int totalVehicles = 0;
        int[] pedestrianCounts = new int[4];
        int[] vehicleCounts = new int[4];
        int lightChanges = 0;

        int waveIndex = 0;
        for (int time = 0; time < simulationTime; time++) {
            String currentLight = trafficLights[time % trafficLights.length];
            if (time > 0 && !currentLight.equals(trafficLights[(time - 1) % trafficLights.length])) {
                lightChanges++;
            }

            if (waveIndex < pedestrianWaves.length) {
                int[] pedestrianWave = pedestrianWaves[waveIndex];
                for (int i = 0; i < 4; i++) {
                    if ((currentLight.equals("NSG") && (i == 0 || i == 2)) ||
                            (currentLight.equals("EWG") && (i == 1 || i == 3)) ||
                            currentLight.equals("G")) {
                        totalPedestrians += pedestrianWave[i];
                        pedestrianCounts[i] += pedestrianWave[i];
                    }
                }
            }

            if (waveIndex < vehicleWaves.length) {
                int[] vehicleWave = vehicleWaves[waveIndex];
                for (int i = 0; i < 4; i++) {
                    if ((currentLight.equals("NSG") && (i == 0 || i == 2)) ||
                            (currentLight.equals("EWG") && (i == 1 || i == 3))) {
                        totalVehicles += vehicleWave[i];
                        vehicleCounts[i] += vehicleWave[i];
                    }
                }
            }

            waveIndex++;
        }

        String[] directions = {"North", "East", "South", "West"};
        int busiestPedestrianDirection = getMaxIndex(pedestrianCounts);
        int busiestVehicleDirection = getMaxIndex(vehicleCounts);

        String result = "Simulation Results:\n" +
                "Total Pedestrians: " + totalPedestrians + "\n" +
                "Total Vehicles: " + totalVehicles + "\n" +
                "Busiest Pedestrian Direction: " + directions[busiestPedestrianDirection] + "\n" +
                "Busiest Vehicle Direction: " + directions[busiestVehicleDirection] + "\n" +
                "Number of Traffic Light Changes: " + lightChanges;

        return result;
    }

    private static int getMaxIndex(int[] counts) {
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
