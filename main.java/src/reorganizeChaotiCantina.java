import java.util.Arrays;

class ReorganizeChaotiCantina {
    public static int[] reorganizeChaotiCantina(int[] inventory, int chaosFactor) {
        // Step 1: Calculate sum of even-indexed elements and multiply by chaosFactor
        int sum = 0;
        for (int i = 0; i < inventory.length; i += 2) {
            sum += inventory[i];
        }
        int reverseCount = Math.min(sum * chaosFactor, inventory.length);

        // Step 2 & 3: Reverse the calculated number of elements from the end
        reverse(inventory, inventory.length - reverseCount, inventory.length - 1);

        // Step 4: Replace prime-indexed elements
        for (int i = 2; i < inventory.length; i++) {
            if (isPrime(i)) {
                inventory[i] = (int) Math.pow(inventory[i], (i % 3) + 1);
            }
        }

        // Step 5: Calculate average of odd-indexed elements
        int oddSum = 0, oddCount = 0;
        for (int i = 1; i < inventory.length; i += 2) {
            oddSum += inventory[i];
            oddCount++;
        }
        int oddAverage = oddCount > 0 ? oddSum / oddCount : 0;

        // Step 6: Add average to elements at indices divisible by 3
        for (int i = 0; i < inventory.length; i += 3) {
            inventory[i] += oddAverage;
        }

        // Step 7: Find max value and circularly shift the array
        int maxValue = Arrays.stream(inventory).max().getAsInt();
        int shiftAmount = maxValue % inventory.length;
        circularShiftRight(inventory, shiftAmount);

        return inventory;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void circularShiftRight(int[] arr, int shift) {
        if (arr.length == 0) return;
        shift = shift % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, shift - 1);
        reverse(arr, shift, arr.length - 1);
    }
}
