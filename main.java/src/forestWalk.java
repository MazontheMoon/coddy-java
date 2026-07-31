import java.util.ArrayList;
import java.util.List;

class ForestWalk {
    public static int[] forestWalk(int[] treeHeights, int sliceFactor, int saplingHeight) {
        List<String> binaryTrees = new ArrayList<>();
        for (int height : treeHeights) {
            binaryTrees.add(Integer.toBinaryString(height));
        }

        int tallestTree = 0;
        int oddBranchedTrees = 0;
        int totalHeight = 0;

        for (int i = 0; i < binaryTrees.size(); i += sliceFactor) {
            int end = Math.min(i + sliceFactor, binaryTrees.size());
            List<String> subArray = binaryTrees.subList(i, end);

            String tallest = subArray.stream().max((a, b) -> Integer.compare(a.length(), b.length())).orElse("0");
            tallestTree = Math.max(tallestTree, Integer.parseInt(tallest, 2));

            oddBranchedTrees += subArray.stream().filter(tree -> Integer.bitCount(Integer.parseInt(tree, 2)) % 2 != 0).count();

            for (int j = 0; j < subArray.size(); j++) {
                String tree = subArray.get(j);
                tree = tree.substring(0, tree.lastIndexOf('1'));
                tree += Integer.toBinaryString(saplingHeight);
                subArray.set(j, tree);
                totalHeight += Integer.parseInt(tree, 2);
            }
        }

        return new int[]{tallestTree, oddBranchedTrees, totalHeight};
    }
}
