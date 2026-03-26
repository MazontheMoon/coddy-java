import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Task 1: Count donations matching the first donation
        int n = scanner.nextInt();
        int[] donations = new int[n];
        for (int i = 0; i < n; i++) {
            donations[i] = scanner.nextInt();
        }
        
        int firstDonation = donations[0];
        int matchCount = 0;
        for (int donation : donations) {
            if (donation == firstDonation) {
                matchCount++;
            }
        }
        
        // Task 2: Sort volunteer shift codes (M before A)
        int m = scanner.nextInt();
        String[] shifts = new String[m];
        for (int i = 0; i < m; i++) {
            shifts[i] = scanner.next();
        }
        
        // Count Ms and As
        int mCount = 0;
        int aCount = 0;
        for (String shift : shifts) {
            if (shift.equals("M")) {
                mCount++;
            } else if (shift.equals("A")) {
                aCount++;
            }
        }
        
        // Build sorted string with all Ms first, then all As
        StringBuilder sortedShifts = new StringBuilder();
        for (int i = 0; i < mCount; i++) {
            if (i > 0) sortedShifts.append(" ");
            sortedShifts.append("M");
        }
        for (int i = 0; i < aCount; i++) {
            if (mCount > 0 || i > 0) sortedShifts.append(" ");
            sortedShifts.append("A");
        }
        
        // Task 3: Check if goal and actual differ by at most $5
        int goal = scanner.nextInt();
        int actual = scanner.nextInt();
        
        int difference = Math.abs(goal - actual);
        String goalMet = (difference <= 5) ? "Goal met" : "Goal not met";
        
        // Print results
        System.out.println(matchCount);
        System.out.println(sortedShifts.toString());
        System.out.println(goalMet);
        
        scanner.close();
    }
}