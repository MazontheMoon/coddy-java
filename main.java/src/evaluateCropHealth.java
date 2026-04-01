class EvaluateCropHealth {
    public static String evaluateCropHealth(boolean[] sensorData) {
        int count = 0;
        for (boolean sensor : sensorData) {
            count += sensor ? 1 : 0;
        }
        
        int percentage = (count * 100) / sensorData.length;
        
        if (percentage < 20) {
            return "Healthy";
        } else if (percentage <= 50) {
            return "Moderate";
        } else {
            return "Critical";
        }
    }
}
