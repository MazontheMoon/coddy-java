import java.util.*;

class OptimizeBuildingDesign {
    public static int[] optimizeBuildingDesign(int[][] roomSets, String[] operations) {
        if (roomSets == null || roomSets.length == 0 || operations == null || operations.length == 0) {
            return new int[0];
        }

        Set<Integer> result = new HashSet<>(toSet(roomSets[0]));
        int setIndex = 1;

        for (String operation : operations) {
            Set<Integer> nextSet = toSet(roomSets[setIndex]);
            result = applyOperation(result, nextSet, operation);
            setIndex = (setIndex + 1) % roomSets.length;
        }

        return setToSortedArray(result);
    }

    private static Set<Integer> toSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        return set;
    }

    private static Set<Integer> applyOperation(Set<Integer> set1, Set<Integer> set2, String operation) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> universe = new HashSet<>(set1);
        universe.addAll(set2);

        switch (operation) {
            case "XOR":
                for (int num : universe) {
                    if (set1.contains(num) ^ set2.contains(num)) {
                        result.add(num);
                    }
                }
                break;
            case "NAND":
                for (int num : universe) {
                    if (!(set1.contains(num) && set2.contains(num))) {
                        result.add(num);
                    }
                }
                break;
            case "NOR":
                for (int num : universe) {
                    if (!set1.contains(num) && !set2.contains(num)) {
                        result.add(num);
                    }
                }
                break;
            case "IMPLIES":
                for (int num : universe) {
                    if (!set1.contains(num) || set2.contains(num)) {
                        result.add(num);
                    }
                }
                break;
            case "BICONDITIONAL":
                for (int num : universe) {
                    if (set1.contains(num) == set2.contains(num)) {
                        result.add(num);
                    }
                }
                break;
        }
        return result;
    }

    private static int[] setToSortedArray(Set<Integer> set) {
        int[] array = new int[set.size()];
        int index = 0;
        for (int num : set) {
            array[index++] = num;
        }
        Arrays.sort(array);
        return array;
    }
}