import java.util.ArrayList;
import java.util.List;

class ExcavateFossils {
    public static int[] excavateFossils(int[][] digSite, int minAge, int maxExtract) {
        List<Fossil> valuableFossils = new ArrayList<>();

        // Iterate through the dig site
        for (int i = 0; i < digSite.length; i++) {
            for (int j = 0; j < digSite[i].length; j++) {
                int age = digSite[i][j];
                if (age > minAge) {
                    int score = age * (i + 1) * (j + 1);
                    valuableFossils.add(new Fossil(age, score));
                }
            }
        }

        // Sort valuable fossils using quicksort
        quickSort(valuableFossils, 0, valuableFossils.size() - 1);

        // Extract top N fossils
        int[] result = new int[Math.min(maxExtract, valuableFossils.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = valuableFossils.get(i).age;
        }

        return result;
    }

    private static void quickSort(List<Fossil> fossils, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(fossils, low, high);
            quickSort(fossils, low, partitionIndex - 1);
            quickSort(fossils, partitionIndex + 1, high);
        }
    }

    private static int partition(List<Fossil> fossils, int low, int high) {
        Fossil pivot = fossils.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (fossils.get(j).score >= pivot.score) {
                i++;
                swap(fossils, i, j);
            }
        }

        swap(fossils, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Fossil> fossils, int i, int j) {
        Fossil temp = fossils.get(i);
        fossils.set(i, fossils.get(j));
        fossils.set(j, temp);
    }

    private static class Fossil {
        int age;
        int score;

        Fossil(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }
}
