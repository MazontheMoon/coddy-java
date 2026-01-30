class UpdateSketchProgress {
    public static String updateSketchProgress(String currentSketch, int artistEnergy, boolean isDarkening) {
        if (artistEnergy < 20) {
            return "Taking a break";
        }
        
        if (isDarkening && !currentSketch.equals("almost complete")) {
            return "Finishing for today";
        }
        
        switch (currentSketch) {
            case "outline":
                if (artistEnergy > 50) {
                    return "half-done";
                }
                break;
            case "half-done":
                if (artistEnergy > 30) {
                    return "almost complete";
                }
                break;
            case "almost complete":
                if (artistEnergy > 10) {
                    return "masterpiece finished";
                }
                break;
        }
        
        return currentSketch;
    }
}
