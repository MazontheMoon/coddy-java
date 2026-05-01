import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Task 1: Check if donation ID is a disarium number
        String donationId = scanner.nextLine();
        int number = Integer.parseInt(donationId);
        
        // Calculate sum of digits raised to their positions
        int sum = 0;
        int length = donationId.length();
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(donationId.charAt(i));
            sum += Math.pow(digit, i + 1);
        }
        
        if (sum == number) {
            System.out.println("Priority");
        } else {
            System.out.println("Standard");
        }
        
        // Task 2: Calculate projected monthly expense
        String dailySpendingStr = scanner.nextLine();
        double dailySpending = Double.parseDouble(dailySpendingStr);
        double monthlyExpense = dailySpending * 30;
        System.out.println(String.format("%.2f", monthlyExpense));
        
        // Task 3: Check middle digit of shelf code
        String shelfCode = scanner.nextLine();
        int middleDigit = Character.getNumericValue(shelfCode.charAt(1));
        
        if (middleDigit % 2 == 0) {
            System.out.println("Refrigerated");
        } else {
            System.out.println("Dry Storage");
        }
        
        scanner.close();
    }
}
