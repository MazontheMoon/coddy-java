import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        // Split the input by comma to get individual dishes
        String[] dishes = input.split(",");
        
        // Array to store hash values
        int[] hashValues = new int[dishes.length];
        
        // Calculate hash for each dish and print
        for (int i = 0; i < dishes.length; i++) {
            int hash = 0;
            String dish = dishes[i];
            
            // Sum ASCII values of all characters
            for (int j = 0; j < dish.length(); j++) {
                hash += (int) dish.charAt(j);
            }
            
            hashValues[i] = hash;
            System.out.println(dish + ": " + hash);
        }
        
        // Calculate festival capacity (first + last hash)
        int festivalCapacity = hashValues[0] + hashValues[hashValues.length - 1];
        System.out.println("Festival Capacity: " + festivalCapacity);
    }
}
