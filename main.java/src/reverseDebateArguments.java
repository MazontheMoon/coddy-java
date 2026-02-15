import java.util.Arrays;

class ReverseDebateArguments {
    public static String[][] reverseDebateArguments(String[][] debateTopics) {
        String[][] reversedTopics = new String[debateTopics.length][];
        
        for (int i = 0; i < debateTopics.length; i++) {
            String[] topic = debateTopics[i];
            String[] reversedTopic = new String[topic.length];
            
            // Copy the topic (first element)
            reversedTopic[0] = topic[0];
            
            // Reverse the arguments
            for (int j = 1; j < topic.length; j++) {
                reversedTopic[j] = topic[topic.length - j];
            }
            
            reversedTopics[i] = reversedTopic;
        }
        
        return reversedTopics;
    }
}
