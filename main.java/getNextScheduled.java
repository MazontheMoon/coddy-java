import java.util.ArrayList;

class GetNextScheduled {
    public static String[] getNextScheduled(String[] queue, boolean[] scheduled, int seats) {
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < queue.length && result.size() < seats; i++) {
            if (scheduled[i]) {
                result.add(queue[i]);
            }
        }
        
        return result.toArray(new String[0]);
    }
}