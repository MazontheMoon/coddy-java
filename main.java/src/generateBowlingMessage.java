/*
Create a function named generateBowlingMessage that receives playerName and score as its parameters.

The function should generate a custom bowling scorecard message for a player at the local candlepin bowling alley. It will return a personalized message that includes a greeting, the player's score, and a fun comment based on their performance.

Use string manipulation and concatenation to create the message. The message should have three parts: a greeting with the player's name, their score, and a comment based on their performance.

Parameters:
 - playerName (String): The name of the player.
 - score (int): The player's bowling score (0-300).
 - The function returns a string containing the personalized message.
 - Use the following performance comments based on the score:
   - Score 0-50: "Keep practicing!"
   - Score 51-100: "Nice effort!"
   - Score 101-150: "Great job!"
   - Score 151-200: "Wow, you're a natural!"
   - Score 201-300: "Perfect game! You're a bowling champion!"
-Make sure to handle any leading or trailing whitespace in the player's name.
*/

class GenerateBowlingMessage {
    public static String generateBowlingMessage(String playerName, int score) {
        String trimmedName = playerName.trim();
        String greeting = "Hello, " + trimmedName + "!";
        String scoreMessage = "Your bowling score is: " + score;
        String comment;

        if (score >= 0 && score <= 50) {
            comment = "Keep practicing!";
        } else if (score <= 100) {
            comment = "Nice effort!";
        } else if (score <= 150) {
            comment = "Great job!";
        } else if (score <= 200) {
            comment = "Wow, you're a natural!";
        } else if (score <= 300) {
            comment = "Perfect game! You're a bowling champion!";
        } else {
            comment = "Invalid score";
        }

        return greeting + " " + scoreMessage + " " + comment;
    }
}