import java.util.HashMap;

class ProcessButterFishSales {
    public static String processButterFishSales(int[] quantities, String[] times) {
        int totalSold = 0;
        StringBuilder binaryPattern = new StringBuilder();
        HashMap<Integer, Integer> hourSales = new HashMap<>();

        for (int i = 0; i < quantities.length; i++) {
            int quantity = quantities[i];
            totalSold += quantity;

            String binaryQuantity = String.format("%6s", Integer.toBinaryString(quantity)).replace(' ', '0');
            binaryPattern.append(binaryQuantity);

            int hour = Integer.parseInt(times[i].split(":")[0]);
            hourSales.put(hour, hourSales.getOrDefault(hour, 0) + quantity);
        }

        int peakHour = 0;
        int maxSales = 0;
        int i = 0;
        while (i < 24) {
            int sales = hourSales.getOrDefault(i, 0);
            if (sales > maxSales) {
                maxSales = sales;
                peakHour = i;
            }
            i++;
        }

        String totalBinary = Integer.toBinaryString(totalSold);

        StringBuilder result = new StringBuilder();
        result.append(totalSold).append("\n");
        result.append(totalBinary).append("\n");
        result.append(String.format("%02d:00", peakHour)).append("\n");
        result.append(binaryPattern.toString());

        return result.toString();
    }
}