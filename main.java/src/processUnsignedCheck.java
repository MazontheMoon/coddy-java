import java.util.Arrays;

class ProcessUnsignedCheck {
    public static String processUnsignedCheck(String checkAmount, int[] checkDimensions, float checkAge, String[] geometricShapes, int foldCount) {
        // Convert check amount to double
        double amount = Double.parseDouble(checkAmount);

        // Step 1: Convert to fraction and multiply
        amount *= (checkAge + 1) / checkAge;

        // Step 2: Calculate surface area and volume
        int length = checkDimensions[0];
        int width = checkDimensions[1];
        int height = checkDimensions[2];
        double surfaceArea = 2 * (length * width + length * height + width * height);
        double volume = length * width * height;

        // Step 3: Apply 2% increase for each fold
        amount *= Math.pow(1.02, foldCount);

        // Step 4: Calculate areas of geometric shapes and adjust check value
        double totalShapeArea = 0;
        for (String shape : geometricShapes) {
            switch (shape) {
                case "triangle":
                    totalShapeArea += 0.5 * 10 * 10;
                    break;
                case "circle":
                    totalShapeArea += Math.PI * 5 * 5;
                    break;
                case "square":
                    totalShapeArea += 10 * 10;
                    break;
            }
        }
        amount += totalShapeArea;

        // Step 5: Raise to power of number of shapes, then take nth root
        amount = Math.pow(amount, geometricShapes.length);
        amount = Math.pow(amount, 1.0 / foldCount);

        // Step 6: Validate check
        boolean isValid = (length * width * height > 1000000) && (geometricShapes.length < 5);

        // Step 7: Calculate percentage
        double percentage = (amount / Double.parseDouble(checkAmount)) * 100;

        // Format the result
        return String.format("Adjusted Value: %.2f%%, Valid: %b, Surface Area: %.2f mm², Volume: %.2f mm³",
                percentage, isValid, surfaceArea, volume);
    }
}
