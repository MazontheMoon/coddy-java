import java.util.Arrays;

class TeaShopProfitAndDisplay {
    public static String teaShopProfitAndDisplay(String[] teaNames, int[] profits) {
        int totalProfit = Arrays.stream(profits).sum();
        
        String floralDisplay = String.join("ߌ袬 teaNames);
        
        return String.format("Total profit: $%d | Floral Display: %s", totalProfit, floralDisplay);
    }
}