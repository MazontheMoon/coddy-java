/*Create a function named culturalFestivalAnalyzer that receives names, ages, and cultures as its parameters.

Your task is to analyze the data of participants in a small town's annual cultural festival, celebrating the diversity of the community. The function should process the information and return a summary of the festival's statistics.

Implement the following steps in your function:

Create a custom hashing technique to assign a unique "festival ID" to each participant based on their name and age. For example, you could use a combination of ASCII values of the name characters and the age, then apply a modulo operation with a prime number.
Identify "special number" participants: those whose age is either a perfect square or a prime number.
Create a reversed array of cultural backgrounds, maintaining the original order of participants.
Calculate the required statistics and format the output string.
Parameters:

names (String[]): An array of strings representing participants' names.
ages (int[]): An array of integers representing participants' ages.
cultures (String[]): An array of strings representing participants' cultural backgrounds.
The function returns a string containing the following information, separated by semicolons:

The total number of participants
The number of "special number" participants
A comma-separated list of the reversed cultural backgrounds
The sum of all "festival IDs"
Note: Ensure that your implementation of prime number checking is efficient, considering the constraints of the challenge.*/

import java.util.Arrays;

class CulturalFestivalAnalyzer {
    public static String culturalFestivalAnalyzer(String[] names, int[] ages, String[] cultures) {
        int totalParticipants = names.length;
        int specialNumberParticipants = 0;
        long festivalIdSum = 0;
        
        for (int i = 0; i < totalParticipants; i++) {
            festivalIdSum += generateFestivalId(names[i], ages[i]);
            if (isPerfectSquare(ages[i]) || isPrime(ages[i])) {
                specialNumberParticipants++;
            }
        }
        
        String[] reversedCultures = new String[totalParticipants];
        for (int i = 0; i < totalParticipants; i++) {
            reversedCultures[i] = cultures[totalParticipants - 1 - i];
        }
        
        return String.format("%d;%d;%s;%d", 
            totalParticipants, 
            specialNumberParticipants, 
            String.join(",", reversedCultures),
            festivalIdSum);
    }
    
    private static long generateFestivalId(String name, int age) {
        long id = 0;
        for (char c : name.toCharArray()) {
            id += (int) c;
        }
        id *= age;
        return id % 1000000007; // Large prime number to avoid overflow
    }
    
    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
