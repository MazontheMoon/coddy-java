import java.util.Arrays;

class CalculateLandValue {
    public static int calculateLandValue(int[] plotDimensions, int soilQuality) {
        int totalValue = 0;
        
        for (int i = 0; i < plotDimensions.length; i += 2) {
            int length = plotDimensions[i];
            int width = plotDimensions[i + 1];
            int area = length * width;
            int plotValue = area * soilQuality;
            totalValue += plotValue;
        }
        
        return totalValue;
    }
}