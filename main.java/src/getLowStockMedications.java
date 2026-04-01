import java.util.ArrayList;

class GetLowStockMedications {
    public static String[] getLowStockMedications(String[] medications, int[] stockCounts, int threshold) {
        ArrayList<String> lowStockMeds = new ArrayList<>();
        
        for (int i = 0; i < medications.length; i++) {
            if (stockCounts[i] < threshold) {
                lowStockMeds.add(medications[i]);
            }
        }
        
        return lowStockMeds.toArray(new String[0]);
    }
}
