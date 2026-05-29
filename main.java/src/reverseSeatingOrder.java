class ReverseSeatingOrder {
    public static String[][] reverseSeatingOrder(String[][] tables) {
        String[][] result = new String[tables.length][];
        
        for (int i = 0; i < tables.length; i++) {
            result[i] = new String[tables[i].length];
            for (int j = 0; j < tables[i].length; j++) {
                result[i][j] = tables[i][tables[i].length - 1 - j];
            }
        }
        
        return result;
    }
}
