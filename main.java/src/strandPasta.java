import java.util.Arrays;

class StrandPasta {
    public static String strandPasta(String[] pastaTypes, String chefAction) {
        String joinedPasta = joinPastaTypes(pastaTypes);
        String scene = "In a bustling kitchen, the clumsy chef ";
        String outcome = " Chaos ensues as pasta flies everywhere!";
        
        return scene + chefAction + " while straining " + joinedPasta + "." + outcome;
    }
    
    private static String joinPastaTypes(String[] pastaTypes) {
        if (pastaTypes.length == 0) {
            return "";
        } else if (pastaTypes.length == 1) {
            return pastaTypes[0];
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < pastaTypes.length - 1; i++) {
                result.append(pastaTypes[i]);
                if (i < pastaTypes.length - 2) {
                    result.append(", ");
                }
            }
            result.append(" and ").append(pastaTypes[pastaTypes.length - 1]);
            return result.toString();
        }
    }
}
