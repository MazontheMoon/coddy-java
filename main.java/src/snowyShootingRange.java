import java.util.Arrays;

class SnowyShootingRange {
    public static String snowyShootingRange(String shooterName, int targetDistance, int windSpeed, String windDirection, int temperature, boolean isSnowing, int[] shotCoordinates) {
        StringBuilder result = new StringBuilder();

        // Greeting
        result.append(String.format("Welcome to the Snowy Shooting Range, %s!\n\n", shooterName));

        // Weather description
        result.append("Weather conditions:\n");
        result.append(String.format("- Target distance: %d meters\n", targetDistance));
        result.append(String.format("- Wind: %d km/h from the %s\n", windSpeed, windDirection));
        result.append(String.format("- Temperature: %d°C\n", temperature));
        result.append(String.format("- Snowing: %s\n\n", isSnowing ? "Yes" : "No"));

        // Calculate shot accuracies
        double[] distances = new double[3];
        double totalDistance = 0;
        result.append("Shot analysis:\n");
        for (int i = 0; i < 3; i++) {
            int x = shotCoordinates[i * 2];
            int y = shotCoordinates[i * 2 + 1];
            distances[i] = Math.sqrt(x * x + y * y);
            totalDistance += distances[i];
            result.append(String.format("- Shot %d: (%.2f, %.2f) - Distance from center: %.2f\n", i + 1, (double)x, (double)y, distances[i]));
        }

        // Calculate average distance and determine performance rating
        double avgDistance = totalDistance / 3;
        String performanceRating;
        if (avgDistance <= 1) {
            performanceRating = "Excellent";
        } else if (avgDistance <= 2) {
            performanceRating = "Good";
        } else if (avgDistance <= 3) {
            performanceRating = "Fair";
        } else {
            performanceRating = "Poor";
        }

        result.append(String.format("\nOverall performance: %s (Average distance: %.2f)\n\n", performanceRating, avgDistance));

        // Generate suggestions
        result.append("Suggestions for improvement:\n");
        if (windSpeed > 20) {
            result.append("- Consider wind compensation techniques for strong winds\n");
        }
        if (temperature < 0) {
            result.append("- Be aware of the effects of cold temperature on your equipment\n");
        }
        if (isSnowing) {
            result.append("- Practice shooting in snowy conditions to improve visibility adaptation\n");
        }
        if (targetDistance > 500) {
            result.append("- Focus on long-range shooting techniques\n");
        }
        if (avgDistance > 2) {
            result.append("- Work on improving your aim and stability\n");
        }

        return result.toString();
    }
}
