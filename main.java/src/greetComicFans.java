import java.util.Arrays;

class GreetComicFans {
    public static String greetComicFans(String[] visitorNames, boolean isSpecialEvent) {
        StringBuilder result = new StringBuilder();
        String specialEventGreeting = "Welcome to our special event! ";

        for (String name : visitorNames) {
            if (isSpecialEvent) {
                result.append(specialEventGreeting);
            }

            if (startsWithVowel(name)) {
                result.append("Oh, hi there, ").append(name).append("!");
            } else if (name.endsWith("y") || name.endsWith("Y")) {
                result.append("Hey, ").append(name).append(", my name-twin!");
            } else {
                result.append("Welcome, ").append(name).append(", to the comic book paradise!");
            }

            result.append("\n");
        }

        return result.toString().trim();
    }

    private static boolean startsWithVowel(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        char firstChar = Character.toLowerCase(name.charAt(0));
        return "aeiou".indexOf(firstChar) != -1;
    }
}
