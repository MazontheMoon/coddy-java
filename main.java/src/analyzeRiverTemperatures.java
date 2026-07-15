import java.util.Arrays;

class AnalyzeRiverTemperatures {
    public static String analyzeRiverTemperatures(float[] rawTemperatures, int numSensors, float fogDensity) {
        // Split rawTemperatures into subarrays
        float[][] sensorData = new float[numSensors][rawTemperatures.length / numSensors];
        for (int i = 0; i < rawTemperatures.length; i++) {
            sensorData[i / (rawTemperatures.length / numSensors)][i % (rawTemperatures.length / numSensors)] = rawTemperatures[i];
        }

        float[] means = new float[numSensors];
        float[] stdDevs = new float[numSensors];
        float[] adjustedMeans = new float[numSensors];
        float overallMin = Float.MAX_VALUE;
        float overallMax = Float.MIN_VALUE;

        for (int i = 0; i < numSensors; i++) {
            means[i] = calculateMean(sensorData[i]);
            stdDevs[i] = calculateStdDev(sensorData[i], means[i]);
            adjustedMeans[i] = means[i] + (means[i] * fogDensity * 0.1f);

            for (float temp : sensorData[i]) {
                overallMin = Math.min(overallMin, temp);
                overallMax = Math.max(overallMax, temp);
            }
        }

        float temperatureGradient = adjustedMeans[numSensors - 1] - adjustedMeans[0];

        // Polynomial regression
        float[] x = new float[numSensors];
        for (int i = 0; i < numSensors; i++) {
            x[i] = i;
        }
        float[] coefficients = polynomialRegression(x, adjustedMeans, 2);

        // Generate report
        StringBuilder report = new StringBuilder();
        report.append(String.format("Number of sensors: %d\n", numSensors));
        report.append(String.format("Fog density: %.2f\n\n", fogDensity));

        for (int i = 0; i < numSensors; i++) {
            report.append(String.format("Sensor %d:\n", i + 1));
            report.append(String.format("  Mean temperature: %.2f°C\n", means[i]));
            report.append(String.format("  Standard deviation: %.2f°C\n", stdDevs[i]));
            report.append(String.format("  Adjusted mean temperature: %.2f°C\n\n", adjustedMeans[i]));
        }

        report.append(String.format("Overall minimum temperature: %.2f°C\n", overallMin));
        report.append(String.format("Overall maximum temperature: %.2f°C\n", overallMax));
        report.append(String.format("Temperature gradient: %.2f°C\n\n", temperatureGradient));

        report.append("Polynomial regression model:\n");
        report.append(String.format("  y = %.4fx^2 + %.4fx + %.4f\n", coefficients[0], coefficients[1], coefficients[2]));

        return report.toString();
    }

    private static float calculateMean(float[] data) {
        float sum = 0;
        for (float value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    private static float calculateStdDev(float[] data, float mean) {
        float sum = 0;
        for (float value : data) {
            sum += Math.pow(value - mean, 2);
        }
        return (float) Math.sqrt(sum / data.length);
    }

    private static float[] polynomialRegression(float[] x, float[] y, int degree) {
        int n = x.length;
        float[][] matrix = new float[degree + 1][degree + 2];

        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= degree; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    matrix[i][j] += Math.pow(x[k], i + j);
                }
            }

            matrix[i][degree + 1] = 0;
            for (int k = 0; k < n; k++) {
                matrix[i][degree + 1] += Math.pow(x[k], i) * y[k];
            }
        }

        gaussianElimination(matrix);

        float[] coefficients = new float[degree + 1];
        for (int i = degree; i >= 0; i--) {
            coefficients[i] = matrix[i][degree + 1];
            for (int j = i + 1; j <= degree; j++) {
                coefficients[i] -= matrix[i][j] * coefficients[j];
            }
            coefficients[i] /= matrix[i][i];
        }

        return coefficients;
    }

    private static void gaussianElimination(float[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = k;
                }
            }

            float[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;

            for (int k = i + 1; k < n; k++) {
                float factor = matrix[k][i] / matrix[i][i];
                for (int j = i; j <= n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }
    }
}