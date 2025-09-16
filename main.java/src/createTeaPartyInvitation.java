/*
Create a function named createTeaPartyInvitation that receives guestName, date, and teaVarieties as its parameters.

Your task is to generate a personalized tea party invitation for a quaint English tea party in a rustic farmhouse garden. The invitation should include the guest's name, the date of the party, and a list of the available tea varieties.

Follow these steps to create the invitation:
- Start with a personalized greeting using the guest's name.
- Include the date of the tea party.
- Create a list of numbers from 1 to the number of tea varieties, formatted as ordinal numbers (1st, 2nd, 3rd, 4th, 5th, etc.).
- Add a closing message.
- Use a loop to generate the list of tea variety numbers, and employ string formatting to create the ordinal numbers and combine all parts of the invitation.

Parameters:
- guestName (String): The name of the guest being invited.
- date (String): The date of the tea party.
- teaVarieties (int): The number of tea varieties available at the party.

The function returns a single string containing the formatted invitation.
*/

import java.util.ArrayList;
import java.util.List;

class CreateTeaPartyInvitation {
    public static String createTeaPartyInvitation(String guestName, String date, int teaVarieties) {
        StringBuilder invitation = new StringBuilder();

        // Personalized greeting
        invitation.append("Dear ").append(guestName).append(",\n\n");

        // Date of the party
        invitation.append("You are cordially invited to a delightful tea party on ").append(date)
                .append(" at our rustic farmhouse garden.\n\n");

        // Tea varieties
        invitation.append("We are pleased to offer ").append(teaVarieties)
                .append(" exquisite tea varieties for your enjoyment:\n");

        // Generate list of ordinal numbers
        List<String> ordinalNumbers = generateOrdinalNumbers(teaVarieties);
        invitation.append(String.join(", ", ordinalNumbers)).append("\n\n");

        // Closing message
        invitation.append("We look forward to your company for an afternoon of tea and pleasant conversation.\n\n")
                .append("Yours sincerely,\nThe Tea Party Host");

        return invitation.toString();
    }

    private static List<String> generateOrdinalNumbers(int count) {
        List<String> ordinals = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            ordinals.add(getOrdinalSuffix(i));
        }
        return ordinals;
    }

    private static String getOrdinalSuffix(int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";
        }
        switch (number % 10) {
            case 1:
                return number + "st";
            case 2:
                return number + "nd";
            case 3:
                return number + "rd";
            default:
                return number + "th";
        }
    }
}