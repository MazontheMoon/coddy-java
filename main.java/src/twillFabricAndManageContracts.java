import java.util.ArrayList;
import java.util.List;

class TwillFabricAndManageContracts {
    public static String[] twillFabricAndManageContracts(int[][] fabricPattern, int[] twillPattern, int[] contractLengths) {
        List<String> result = new ArrayList<>();
        
        // Apply twill pattern to fabric
        for (int i = 0; i < fabricPattern.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < fabricPattern[i].length; j++) {
                // Skip certain columns based on twill pattern
                if ((j + i) % twillPattern.length == 0) {
                    continue;
                }
                
                int shiftAmount = twillPattern[(i + j) % twillPattern.length];
                int newValue = (fabricPattern[i][j] + shiftAmount - 1) % 9 + 1;
                
                row.append(newValue);
                if (j < fabricPattern[i].length - 1) {
                    row.append(" ");
                }
            }
            result.add(row.toString());
        }
        
        // Manage contracts
        for (int i = 0; i < contractLengths.length; i++) {
            contractLengths[i]--;
            String status = contractLengths[i] <= 0 ? "Terminable" : contractLengths[i] + " days left";
            result.add("Contract " + (i + 1) + ": " + status);
        }
        
        return result.toArray(new String[0]);
    }
}

