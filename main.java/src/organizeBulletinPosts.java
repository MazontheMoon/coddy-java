import java.util.*;

class OrganizeBulletinPosts {
    public static int[][] organizeBulletinPosts(int[] postIds) {
        // Sort the post IDs in ascending order
        int[] sortedIds = postIds.clone();
        Arrays.sort(sortedIds);
        
        // Find prime numbers from the sorted list
        List<Integer> primeList = new ArrayList<>();
        for (int id : sortedIds) {
            if (isPrime(id)) {
                primeList.add(id);
            }
        }
        
        // Convert prime list to array
        int[] primeIds = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            primeIds[i] = primeList.get(i);
        }
        
        // Return 2D array with sorted IDs and prime IDs
        return new int[][]{sortedIds, primeIds};
    }
    
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
