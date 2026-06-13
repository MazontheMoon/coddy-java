class FindBoothInLayout {
    public static boolean findBoothInLayout(String boothName, String[][] layoutGrid) {
        for (int i = 0; i < layoutGrid.length; i++) {
            for (int j = 0; j < layoutGrid[i].length; j++) {
                if (layoutGrid[i][j].equals(boothName)) {
                    return true;
                }
            }
        }
        return false;
    }
}