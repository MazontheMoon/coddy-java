class DistributeAid {
    public static int[][] distributeAid(int[][] needs, int[][] inventory, int maxDistance) {
        int numCommunities = needs.length;
        int numSupplyTypes = needs[0].length;
        int numStorageLocations = inventory[0].length;

        int[][] distributionPlan = new int[numCommunities][numSupplyTypes];

        // Calculate the total available supplies for each type
        int[] totalSupplies = new int[numSupplyTypes];
        for (int i = 0; i < numSupplyTypes; i++) {
            for (int j = 0; j < numStorageLocations; j++) {
                totalSupplies[i] += inventory[i][j];
            }
        }

        // Iterate through each community
        for (int i = 0; i < numCommunities; i++) {
            int[] communityNeeds = needs[i];

            // Allocate supplies to the community based on availability
            for (int j = 0; j < numSupplyTypes; j++) {
                int neededSupplies = communityNeeds[j];
                int allocatedSupplies = Math.min(neededSupplies, totalSupplies[j]);
                distributionPlan[i][j] = allocatedSupplies;
                totalSupplies[j] -= allocatedSupplies;
            }
        }

        // Optimize delivery routes (not implemented in this example)
        // You can add your own implementation here based on the specific requirements

        return distributionPlan;
    }
}
