import java.util.ArrayList;
import java.util.List;

class MistyGraveyard {
    public static String[] mistyGraveyard(String[] names, String[] epitaphs) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < names.length; i++) {
            result.add("[" + names[i] + "]");
            result.add("~");
            result.add(epitaphs[i] + "...");
        }
        
        return result.toArray(new String[0]);
    }
}
