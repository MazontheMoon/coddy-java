import java.util.*;

class OptimizeSurveyRoute {
    public static String[] optimizeSurveyRoute(String[] houseResponses) {
        // Create a list to store responses with their hash values
        List<ResponseWithHash> responsesWithHashes = new ArrayList<>();
        
        // Calculate hash for each response and store it
        for (String response : houseResponses) {
            String address = response.split(":")[0];
            int hash = (address.length() * 31 + address.charAt(0)) % 1000;
            responsesWithHashes.add(new ResponseWithHash(response, hash));
        }
        
        // Sort by hash values in descending order
        responsesWithHashes.sort((a, b) -> Integer.compare(b.hash, a.hash));
        
        // Extract the responses in sorted order
        String[] result = new String[houseResponses.length];
        for (int i = 0; i < responsesWithHashes.size(); i++) {
            result[i] = responsesWithHashes.get(i).response;
        }
        
        return result;
    }
    
    private static class ResponseWithHash {
        String response;
        int hash;
        
        ResponseWithHash(String response, int hash) {
            this.response = response;
            this.hash = hash;
        }
    }
}