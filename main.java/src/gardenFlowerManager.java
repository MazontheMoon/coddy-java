import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Task 1: Find kth most expensive flower using quickselect
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        int kthLargest = findKthLargest(prices, k);
        System.out.println(kthLargest);
        
        // Task 2: Reorganize flower codes
        String flowerCodes = scanner.nextLine();
        String reorganized = reorganizeFlowers(flowerCodes);
        System.out.println(reorganized);
        
        // Task 3: Sum of even-denomination bills up to limit
        String[] billsStr = scanner.nextLine().split(" ");
        int[] bills = new int[billsStr.length - 1];
        for (int i = 0; i < bills.length; i++) {
            bills[i] = Integer.parseInt(billsStr[i]);
        }
        int maxValue = Integer.parseInt(billsStr[billsStr.length - 1]);
        
        int evenSum = sumEvenBills(bills, maxValue);
        System.out.println(evenSum);
    }
    
    // Quickselect algorithm to find kth largest element
    private static int findKthLargest(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        return quickSelect(copy, 0, copy.length - 1, copy.length - k);
    }
    
    private static int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }
        
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);
        
        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }
    
    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        swap(nums, right, storeIndex);
        return storeIndex;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // Reorganize flower codes so no two adjacent are identical
    private static String reorganizeFlowers(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Check if reorganization is possible
        int maxFreq = 0;
        for (int count : freq.values()) {
            maxFreq = Math.max(maxFreq, count);
        }
        
        if (maxFreq > (s.length() + 1) / 2) {
            return "impossible";
        }
        
        // Use priority queue to reorganize
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(freq.entrySet());
        
        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> current = pq.poll();
            result.append(current.getKey());
            current.setValue(current.getValue() - 1);
            
            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }
            
            prev = current;
        }
        
        return result.toString();
    }
    
    // Sum even-denomination bills up to maxValue
    private static int sumEvenBills(int[] bills, int maxValue) {
        int sum = 0;
        for (int bill : bills) {
            if (bill <= maxValue && bill % 2 == 0) {
                sum += bill;
            }
        }
        return sum;
    }
}