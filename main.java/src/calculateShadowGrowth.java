import java.util.Arrays;

class CalculateShadowGrowth {
    public static int[] calculateShadowGrowth(int[] lightIntensity, String[] plantTypes, int days) {
        int[] growth = new int[lightIntensity.length];
        
        for (int day = 1; day <= days; day++) {
            if (day % 5 == 1 && day > 1) {
                reverseArray(lightIntensity);
            }
            
            for (int i = 0; i < lightIntensity.length; i++) {
                int dailyGrowth = calculateDailyGrowth(lightIntensity[i]);
                double growthModifier = getGrowthModifier(plantTypes[i]);
                growth[i] += (int) (dailyGrowth * growthModifier);
            }
        }
        
        return growth;
    }
    
    private static int calculateDailyGrowth(int lightIntensity) {
        if (lightIntensity < 5) {
            return 2;
        } else if (lightIntensity <= 10) {
            return 1;
        } else {
            return 0;
        }
    }
    
    private static double getGrowthModifier(String plantType) {
        switch (plantType) {
            case "Shadeleaf":
                return 1.5;
            case "Nightbloom":
                return 1.2;
            case "Moonflower":
                return 1.0;
            default:
                return 0.8;
        }
    }
    
    private static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
