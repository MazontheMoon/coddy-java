class CountWildflowers {
    public static int countWildflowers(int[] path, int maxCount) {
        int totalFlowers = 0;
        int i = 0;

        while (i < path.length) {
            if (path[i] <= maxCount) {
                totalFlowers += path[i];
            } else {
                totalFlowers += maxCount;
            }
            i++;
        }

        return totalFlowers;
    }
}