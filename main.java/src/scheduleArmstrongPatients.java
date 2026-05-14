import java.util.ArrayList;

class ScheduleArmstrongPatients {
    public static int[] scheduleArmstrongPatients(int[] studentIds, int maxCount) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int id : studentIds) {
            if (id <= 0) {
                continue;
            }
            
            if (isArmstrongNumber(id)) {
                result.add(id);
                if (result.size() >= maxCount) {
                    break;
                }
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private static boolean isArmstrongNumber(int number) {
        String numStr = String.valueOf(number);
        int numDigits = numStr.length();
        int sum = 0;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }
        
        return sum == number;
    }
}
