import java.text.DecimalFormat;

class SimulateDasylirionGrowth {
    public static String simulateDasylirionGrowth(int initialHeight, int days, int dailyGrowth, int waterSupply) {
        double currentHeight = initialHeight;
        int remainingWater = waterSupply;
        DecimalFormat df = new DecimalFormat("#.##");

        for (int day = 0; day < days; day++) {
            if (remainingWater > 0) {
                currentHeight += dailyGrowth / 10.0;
                remainingWater -= 50;
            } else {
                break;
            }
        }

        if (remainingWater < 0) {
            remainingWater = 0;
        }

        String finalHeight = df.format(currentHeight);
        String message = "";

        if (currentHeight > initialHeight * 1.5) {
            message = "Hoot hoot! The Dasylirion has grown impressively tall!";
        } else if (currentHeight > initialHeight * 1.2) {
            message = "Hoot! The Dasylirion has shown good growth.";
        } else {
            message = "Hoot... The Dasylirion's growth was limited.";
        }

        return "Final height: " + finalHeight + " cm, Remaining water: " + remainingWater + " ml. " + message;
    }
}


