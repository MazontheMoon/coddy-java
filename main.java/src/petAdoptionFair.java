import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read booth number
        int boothNumber = Integer.parseInt(scanner.nextLine());
        
        // Read dictionary size and words
        int dictSize = Integer.parseInt(scanner.nextLine());
        String[] dictWords = scanner.nextLine().split(" ");
        
        // Read compound names to validate
        String[] compoundNames = scanner.nextLine().split(" ");
        
        // Read queue size K
        int k = Integer.parseInt(scanner.nextLine());
        
        // Read number of viewing events
        int numEvents = Integer.parseInt(scanner.nextLine());
        
        // Read viewing events
        String[] viewingEvents = scanner.nextLine().split(" ");
        
        // Task 1: Check if booth number is power of 2
        boolean isPowerOf2 = checkPowerOf2(boothNumber);
        if (isPowerOf2) {
            System.out.println("Premium booth");
        } else {
            System.out.println("Standard booth");
        }
        
        // Task 2: Validate compound names
        Set<String> dictionary = new HashSet<>();
        for (String word : dictWords) {
            dictionary.add(word);
        }
        
        List<String> validCompounds = new ArrayList<>();
        for (String compound : compoundNames) {
            if (isValidCompound(compound, dictionary)) {
                validCompounds.add(compound);
            }
        }
        
        if (validCompounds.isEmpty()) {
            System.out.println("No valid compounds");
        } else {
            System.out.println(String.join(" ", validCompounds));
        }
        
        // Task 3: Maintain viewing queue
        LinkedHashSet<String> viewingQueue = new LinkedHashSet<>();
        
        for (String animal : viewingEvents) {
            // If animal already in queue, remove it (will be re-added at front)
            if (viewingQueue.contains(animal)) {
                viewingQueue.remove(animal);
            }
            
            // Add to front (in LinkedHashSet, we add and it goes to end, 
            // but we'll reverse for output)
            viewingQueue.add(animal);
            
            // If size exceeds K, remove oldest (first element)
            if (viewingQueue.size() > k) {
                Iterator<String> it = viewingQueue.iterator();
                it.next();
                it.remove();
            }
        }
        
        // Convert to list and reverse to show most recent first
        List<String> finalQueue = new ArrayList<>(viewingQueue);
        Collections.reverse(finalQueue);
        System.out.println(String.join(" ", finalQueue));
    }
    
    // Check if a number is a power of 2
    private static boolean checkPowerOf2(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    
    // Check if a compound name can be formed from dictionary words
    private static boolean isValidCompound(String compound, Set<String> dictionary) {
        int n = compound.length();
        if (n == 0) return false;
        
        // dp[i] = true if compound[0..i-1] can be formed from dictionary
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    String word = compound.substring(j, i);
                    if (dictionary.contains(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        // Must use at least 2 words (not just the whole string as one word)
        if (dp[n]) {
            // Check if it's not just a single dictionary word
            if (dictionary.contains(compound)) {
                // It's in dictionary as single word, check if it can also be formed by 2+ words
                // We need to verify there's at least one valid split
                for (int i = 1; i < n; i++) {
                    if (dp[i]) {
                        String remaining = compound.substring(i);
                        if (dictionary.contains(remaining)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        
        return false;
    }
}
