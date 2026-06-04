import java.util.*;

class ProcessSauceVerteDishes {
    public static String[] processSauceVerteDishes(String[] dishCodes, int[] prices) {
        List<Integer> svPrices = new ArrayList<>();
        
        // Filter dishes containing "SV" and collect their prices
        for (int i = 0; i < dishCodes.length; i++) {
            if (dishCodes[i].contains("SV")) {
                svPrices.add(prices[i]);
            }
        }
        
        // Sort prices in ascending order
        Collections.sort(svPrices);
        
        // Convert each price to binary string
        String[] result = new String[svPrices.size()];
        for (int i = 0; i < svPrices.size(); i++) {
            result[i] = Integer.toBinaryString(svPrices.get(i));
        }
        
        return result;
    }
}
