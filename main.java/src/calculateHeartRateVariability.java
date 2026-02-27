import java.util.Arrays;

class CalculateHeartRateVariability {
    private static final double PHI = (1 + Math.sqrt(5)) / 2;
    private static final double E = Math.E;
    private static final double PI = Math.PI;

    public static int[] calculateHeartRateVariability(int baselineHeartRate, int anxietyLevel, int waitingTimeMinutes, int injectionMoment) {
        int[] hrv = new int[waitingTimeMinutes];
        int encodedAnxiety = (anxietyLevel << 8) | waitingTimeMinutes;

        for (int minute = 0; minute < waitingTimeMinutes; minute++) {
            double naturalFluctuation = 5 * Math.sin(minute * 0.1) + 3 * Math.cos(minute * 0.05) + 2 * Math.tan(minute * 0.03);
            double anxietyEffect = Math.pow(E, (double) minute / injectionMoment) * anxietyLevel;
            double goldenRatioEffect = PHI * minute % 5;

            int bitwise = (encodedAnxiety ^ (minute << 2)) >> 1;
            double bitwiseEffect = bitwise % 7 - 3;

            double postInjectionEffect = minute > injectionMoment ? Math.log(minute - injectionMoment + 1) * 5 : 0;

            int seed = (baselineHeartRate * 1103515245 + 12345) & 0x7fffffff;
            double pseudoRandom = (seed % 10) - 5;

            double eulerPiEffect = (E * minute % 3) * (PI * minute % 2);

            int heartRate = (int) (baselineHeartRate + naturalFluctuation + anxietyEffect + goldenRatioEffect + bitwiseEffect - postInjectionEffect + pseudoRandom + eulerPiEffect);
            hrv[minute] = Math.max(40, Math.min(200, heartRate));
        }

        return hrv;
    }
}
