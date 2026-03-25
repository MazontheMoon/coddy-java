import java.util.Arrays;

class PlayWithYoYo {
    public static String[] playWithYoYo(int[] yoyoString, int basicMotions, int aroundTheWorld, int walkTheDog) {
        for (int i = 0; i < basicMotions; i++) {
            yoyoString = basicMotion(yoyoString);
        }
        
        for (int i = 0; i < aroundTheWorld; i++) {
            yoyoString = aroundTheWorldTrick(yoyoString);
        }
        
        for (int i = 0; i < walkTheDog; i++) {
            yoyoString = walkTheDogTrick(yoyoString);
        }
        
        return Arrays.stream(yoyoString)
                     .mapToObj(String::valueOf)
                     .toArray(String[]::new);
    }
    
    private static int[] basicMotion(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i] + 1;
        }
        return reversed;
    }
    
    private static int[] aroundTheWorldTrick(int[] arr) {
        int[] rotated = new int[arr.length];
        rotated[0] = arr[arr.length - 1] - 1;
        for (int i = 1; i < arr.length; i++) {
            rotated[i] = arr[i - 1] - 1;
        }
        return rotated;
    }
    
    private static int[] walkTheDogTrick(int[] arr) {
        int thirdSize = arr.length / 3;
        int[] result = Arrays.copyOf(arr, arr.length);
        
        for (int i = thirdSize; i < 2 * thirdSize; i++) {
            result[i] = 0;
        }
        
        for (int i = 0; i < thirdSize; i++) {
            result[i] += 2;
        }
        
        for (int i = 2 * thirdSize; i < arr.length; i++) {
            result[i] += 2;
        }
        
        return result;
    }
}

