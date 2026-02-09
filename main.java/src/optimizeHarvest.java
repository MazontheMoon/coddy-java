import java.util.*;

class OptimizeHarvest {
    public static String[] optimizeHarvest(String farmLayout, int[] growthStages, String[] weatherForecasts, int[] marketPrices, int workers) {
        // Parse farm layout
        int rows = (int) Math.sqrt(farmLayout.length());
        int cols = farmLayout.length() / rows;
        char[][] farm = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                farm[i][j] = farmLayout.charAt(i * cols + j);
            }
        }

        // Create a map of crop types to market prices
        Map<Character, Integer> priceMap = new HashMap<>();
        Set<Character> crops = new HashSet<>();
        for (char c : farmLayout.toCharArray()) {
            crops.add(c);
        }
        int priceIndex = 0;
        for (char crop : crops) {
            priceMap.put(crop, marketPrices[priceIndex++]);
        }

        // Initialize strategy
        List<String> strategy = new ArrayList<>();
        int day = 0;

        // Simulate harvest season
        while (day < weatherForecasts.length) {
            StringBuilder dailyStrategy = new StringBuilder();
            dailyStrategy.append("Day ").append(day + 1).append(": ");

            // Check weather impact
            int weatherImpact = getWeatherImpact(weatherForecasts[day]);

            // Prioritize crops based on growth stage, weather, and market price
            PriorityQueue<CropInfo> harvestPriority = new PriorityQueue<>((a, b) -> {
                int scoreA = a.growthStage + weatherImpact + priceMap.get(a.type);
                int scoreB = b.growthStage + weatherImpact + priceMap.get(b.type);
                return scoreB - scoreA;
            });

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    char cropType = farm[i][j];
                    int growthStage = growthStages[i * cols + j];
                    if (growthStage >= 80) { // Consider harvesting if growth stage is at least 80%
                        harvestPriority.offer(new CropInfo(cropType, growthStage, i, j));
                    }
                }
            }

            // Assign workers to harvest
            int remainingWorkers = workers;
            while (!harvestPriority.isEmpty() && remainingWorkers > 0) {
                CropInfo crop = harvestPriority.poll();
                dailyStrategy.append("Harvest ").append(getCropName(crop.type))
                        .append(" at (").append(crop.row).append(",").append(crop.col).append("); ");
                remainingWorkers--;
                growthStages[crop.row * cols + crop.col] = 0; // Reset growth stage after harvesting
            }

            // Assign remaining workers to tend crops
            if (remainingWorkers > 0) {
                dailyStrategy.append("Assign ").append(remainingWorkers)
                        .append(" workers to tend other crops");
            }

            strategy.add(dailyStrategy.toString());
            day++;

            // Simulate growth for next day
            for (int i = 0; i < growthStages.length; i++) {
                if (growthStages[i] < 100) {
                    growthStages[i] += 5; // Increase growth stage by 5% each day
                    if (growthStages[i] > 100) growthStages[i] = 100;
                }
            }
        }

        return strategy.toArray(new String[0]);
    }

    private static int getWeatherImpact(String weather) {
        switch (weather) {
            case "Sunny": return 5;
            case "Cloudy": return 0;
            case "Rainy": return -5;
            default: return 0;
        }
    }

    private static String getCropName(char type) {
        switch (type) {
            case 'W': return "Wheat";
            case 'C': return "Corn";
            case 'T': return "Tomatoes";
            default: return "Unknown";
        }
    }

    private static class CropInfo {
        char type;
        int growthStage;
        int row;
        int col;

        CropInfo(char type, int growthStage, int row, int col) {
            this.type = type;
            this.growthStage = growthStage;
            this.row = row;
            this.col = col;
        }
    }
}
