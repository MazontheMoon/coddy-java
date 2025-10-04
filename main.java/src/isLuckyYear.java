/*
Create a function named isLuckyYear that receives birthYear and luckyNumber as parameters.

This function determines if a birth year is a "lucky year" based on the lucky number. A year is lucky if it is divisible by the lucky number.

To solve this:
- Check if birthYear is divisible by luckyNumber using the modulo operator (%).
- If the remainder is 0, return: "{birthYear} is a lucky year!".
- If the remainder is not 0, return: "{birthYear} is not a lucky year.".
R- eplace {birthYear} in the return strings with the actual value of the birthYear parameter.

Parameters:
- birthYear (int): The birth year of the person.
- luckyNumber (int): The person’s lucky number, a positive integer greater than 0.
The function returns a String: either "{birthYear} is a lucky year!" or "{birthYear} is not a lucky year.".
*/

class IsLuckyYear {
    public static String isLuckyYear(int birthYear, int luckyNumber) {
        if (luckyNumber <= 0) {
            throw new IllegalArgumentException("Lucky number must be a positive integer greater than 0.");
        }

        if (birthYear % luckyNumber == 0) {
            return birthYear + " is a lucky year!";
        } else {
            return birthYear + " is not a lucky year.";
        }
    }
}