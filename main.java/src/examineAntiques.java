import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExamineAntiques {
    public static String[] examineAntiques(String[] objects, int rotations) {
        List<String> result = new ArrayList<>();
        List<String> objectsList = new ArrayList<>(Arrays.asList(objects));

        for (int i = 0; i < rotations && !objectsList.isEmpty(); i++) {
            // Reverse the objects array
            reverseList(objectsList);

            // Examine each object
            for (String object : objectsList) {
                if (object.length() > 5) {
                    result.add(object);
                }
                if (object.toLowerCase().contains("rare")) {
                    break;
                }
                if (startsWithVowel(object)) {
                    continue;
                }
            }

            // Remove the last object after each rotation
            if (!objectsList.isEmpty()) {
                objectsList.remove(objectsList.size() - 1);
            }
        }

        return result.toArray(new String[0]);
    }

    private static void reverseList(List<String> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            String temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    private static boolean startsWithVowel(String str) {
        if (str.isEmpty()) return false;
        char firstChar = Character.toLowerCase(str.charAt(0));
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';
    }
}
