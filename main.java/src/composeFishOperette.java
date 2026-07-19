import java.util.Arrays;

class ComposeFishOperette {
    public static String composeFishOperette(String[] fishNames, String[] musicalTerms) {
        StringBuilder operette = new StringBuilder();
        
        for (int i = 0; i < fishNames.length; i++) {
            if (i > 0) {
                operette.append(i == fishNames.length - 1 ? " and " : ", ");
            }
            operette.append("the ").append(fishNames[i]).append(" swims ").append(musicalTerms[i]);
        }
        
        String result = operette.toString();
        result = Character.toUpperCase(result.charAt(0)) + result.substring(1) + ".";
        
        result += " Oh, what a symphony of aquatic life! The tropical fish are truly a marvel to behold!";
        
        return result;
    }
}