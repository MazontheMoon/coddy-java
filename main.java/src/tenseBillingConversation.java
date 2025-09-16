/*
Create a function named tenseBillingConversation that receives startNumber and endNumber as its parameters.

Imagine you're at a dinner table with friends, discussing recurring billing issues. The conversation is getting tense, and you decide to analyze the billing numbers to identify problematic patterns. Your task is to count the number of "special" transactions within a given range.

A number is considered "special" if it meets all of these criteria:
- It is divisible by 3 (representing a monthly billing cycle)
- It is not divisible by 5 (representing a problematic billing amount)
- The sum of its digits is greater than 10 (representing a high-stress conversation topic)
- Use a loop to iterate through the numbers in the given range. Use the continue statement to skip numbers that don't meet the first two criteria. Use the break statement to end the conversation prematurely if a number divisible by 100 is encountered (representing an abrupt end to the dinner due to extreme frustration).

Parameters:
- startNumber (int): The start of the range to analyze (inclusive).
- endNumber (int): The end of the range to analyze (inclusive).

The function returns an integer representing the count of special numbers found within the range.

Constraints:
- 1 ≤ startNumber ≤ endNumber ≤ 10000
- Your solution should use both continue and break statements.

Hint: To calculate the sum of digits, you can use a helper method or incorporate the logic directly in your main function.
*/

class TenseBillingConversation {
    public static int tenseBillingConversation(int startNumber, int endNumber) {
        int count = 0;
        for (int i = startNumber; i <= endNumber; i++) {
            if (i % 100 == 0) {
                break;
            }
            if (i % 3 != 0 || i % 5 == 0) {
                continue;
            }
            if (sumOfDigits(i) > 10) {
                count++;
            }
        }
        return count;
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}