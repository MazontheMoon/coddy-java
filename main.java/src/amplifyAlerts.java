class AmplifyAlerts {
    public static int[] amplifyAlerts(int[] signals, int threshold, int amplificationFactor) {
        int[] result = new int[signals.length];
        
        for (int i = 0; i < signals.length; i++) {
            if (signals[i] > threshold) {
                result[i] = signals[i] * amplificationFactor;
            } else {
                result[i] = signals[i];
            }
        }
        
        return result;
    }
}
