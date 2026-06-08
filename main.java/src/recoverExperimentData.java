class RecoverExperimentData {
    public static int[] recoverExperimentData(int[] originalData, int[] corruptedData) {
        int n = originalData.length;
        int m = corruptedData.length;
        
        // Step 1: Correct sign-flipped elements
        for (int i = 0; i < m; i++) {
            if (Math.abs(corruptedData[i]) != Math.abs(originalData[i % n])) {
                corruptedData[i] = -corruptedData[i];
            }
        }
        
        // Step 2: Swap elements back to their original positions
        for (int i = 0; i < m; i++) {
            if (corruptedData[i] != originalData[i % n]) {
                for (int j = i + 1; j < m; j++) {
                    if (corruptedData[j] == originalData[i % n]) {
                        int temp = corruptedData[i];
                        corruptedData[i] = corruptedData[j];
                        corruptedData[j] = temp;
                        break;
                    }
                }
            }
        }
        
        // Step 3: Remove random values that do not belong to the original array
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (index < n && corruptedData[i] == originalData[index]) {
                result[index] = corruptedData[i];
                index++;
            }
        }
        
        return result;
    }
}
