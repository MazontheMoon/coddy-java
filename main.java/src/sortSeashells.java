import java.util.*;

class SortSeashells {
    public static String[][] sortSeashells(String[] seashells, String sortingCriteria) {
        List<String[]> piles = new ArrayList<>();
        
        if (sortingCriteria.equals("size")) {
            Map<String, List<String>> sizeMap = new HashMap<>();
            for (String seashell : seashells) {
                String size = seashell.split("-")[0];
                sizeMap.putIfAbsent(size, new ArrayList<>());
                sizeMap.get(size).add(seashell);
            }
            for (List<String> pile : sizeMap.values()) {
                piles.add(pile.toArray(new String[0]));
            }
        } else if (sortingCriteria.equals("color")) {
            Map<String, List<String>> colorMap = new HashMap<>();
            for (String seashell : seashells) {
                String color = seashell.split("-")[1];
                colorMap.putIfAbsent(color, new ArrayList<>());
                colorMap.get(color).add(seashell);
            }
            for (List<String> pile : colorMap.values()) {
                piles.add(pile.toArray(new String[0]));
            }
        } else if (sortingCriteria.equals("size-and-color")) {
            Map<String, Map<String, List<String>>> sizeColorMap = new HashMap<>();
            for (String seashell : seashells) {
                String[] parts = seashell.split("-");
                String size = parts[0];
                String color = parts[1];
                sizeColorMap.putIfAbsent(size, new HashMap<>());
                sizeColorMap.get(size).putIfAbsent(color, new ArrayList<>());
                sizeColorMap.get(size).get(color).add(seashell);
            }
            for (Map<String, List<String>> colorMap : sizeColorMap.values()) {
                for (List<String> pile : colorMap.values()) {
                    piles.add(pile.toArray(new String[0]));
                }
            }
        }
        
        return piles.toArray(new String[0][]);
    }
}
