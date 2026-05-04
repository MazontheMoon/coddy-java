import java.util.ArrayList;
import java.util.List;

class OptimizeStudyPlan {
    public static String[] optimizeStudyPlan(String[] dailySchedule, String[] studyTopics, int timeAvailable) {
        List<String> studyPlan = new ArrayList<>();
        int studyHoursUsed = 0;
        int topicIndex = 0;
        
        for (String event : dailySchedule) {
            if (event.equals("Study Time") && studyHoursUsed < timeAvailable) {
                String currentTopic = studyTopics[topicIndex];
                studyPlan.add(currentTopic);
                studyHoursUsed++;
                topicIndex++;
                
                if (topicIndex >= studyTopics.length) {
                    topicIndex = 0;
                }
            } else if (event.startsWith("Class:")) {
                String className = event.substring(7);
                
                for (int i = topicIndex; i < studyTopics.length; i++) {
                    if (studyTopics[i].toLowerCase().contains(className.toLowerCase()) && studyHoursUsed < timeAvailable) {
                        studyPlan.add(studyTopics[i]);
                        studyHoursUsed++;
                        topicIndex = (i + 1) % studyTopics.length;
                        break;
                    }
                }
            }
            
            if (studyHoursUsed == timeAvailable) {
                break;
            }
        }
        
        while (studyHoursUsed < timeAvailable && studyPlan.size() < studyTopics.length) {
            String currentTopic = studyTopics[topicIndex];
            studyPlan.add(currentTopic);
            studyHoursUsed++;
            topicIndex = (topicIndex + 1) % studyTopics.length;
        }
        
        return studyPlan.toArray(new String[0]);
    }
}
