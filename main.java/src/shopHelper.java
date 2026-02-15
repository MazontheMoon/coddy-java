class ShopHelper {
    public static String shopHelper(String taskType, String input1, String input2, String input3) {
        if (taskType.equals("unique_labels")) {
            return uniqueLabels(input1);
        } else if (taskType.equals("popularity_digits")) {
            return popularityDigits(input1, input2, input3);
        } else if (taskType.equals("calorie_needs")) {
            return calorieNeeds(input1, input2);
        }
        return "";
    }
    
    private static String uniqueLabels(String labels) {
        if (labels.isEmpty()) {
            return "";
        }
        
        String[] words = labels.split(" ");
        java.util.Map<String, Integer> wordCount = new java.util.LinkedHashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        java.util.List<String> uniqueWords = new java.util.ArrayList<>();
        for (java.util.Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        
        return String.join(" ", uniqueWords);
    }
    
    private static String popularityDigits(String baseStr, String exponentStr, String kStr) {
        int base = Integer.parseInt(baseStr);
        int exponent = Integer.parseInt(exponentStr);
        int k = Integer.parseInt(kStr);
        
        java.math.BigInteger result = java.math.BigInteger.valueOf(base).pow(exponent);
        String resultStr = result.toString();
        
        String firstKDigits = resultStr.substring(0, Math.min(k, resultStr.length()));
        return String.valueOf(Integer.parseInt(firstKDigits));
    }
    
    private static String calorieNeeds(String weightStr, String activityLevel) {
        int weight = Integer.parseInt(weightStr);
        int multiplier;
        
        if (activityLevel.equals("low")) {
            multiplier = 24;
        } else if (activityLevel.equals("medium")) {
            multiplier = 30;
        } else {
            multiplier = 35;
        }
        
        int calories = weight * multiplier;
        return String.valueOf(calories);
    }
}
