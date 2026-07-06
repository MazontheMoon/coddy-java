import java.util.HashMap;

class ManageOfficeDay {
    private static class Node {
        String task;
        int priority;
        int duration;
        Node next;

        Node(String task, int priority, int duration) {
            this.task = task;
            this.priority = priority;
            this.duration = duration;
            this.next = null;
        }
    }

    private static class LinkedList {
        Node head;

        void insert(String task, int priority, int duration) {
            Node newNode = new Node(task, priority, duration);
            if (head == null || priority < head.priority) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null && current.next.priority <= priority) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public static String manageOfficeDay(String[] tasks, int[] priorities, int[] durations) {
        LinkedList schedule = new LinkedList();
        HashMap<String, Integer> frequency = new HashMap<>();

        int totalTasks = tasks.length;
        int totalDuration = 0;
        String mostFrequentTask = "";
        int maxFrequency = 0;
        String highestPriorityTask = "";
        int highestPriority = Integer.MAX_VALUE;

        for (int i = 0; i < totalTasks; i++) {
            schedule.insert(tasks[i], priorities[i], durations[i]);
            frequency.put(tasks[i], frequency.getOrDefault(tasks[i], 0) + 1);
            totalDuration += durations[i];

            if (frequency.get(tasks[i]) > maxFrequency) {
                maxFrequency = frequency.get(tasks[i]);
                mostFrequentTask = tasks[i];
            }

            if (priorities[i] < highestPriority) {
                highestPriority = priorities[i];
                highestPriorityTask = tasks[i];
            }
        }

        return String.format("Total tasks: %d\nMost frequent task: %s (%d times)\nHighest priority task: %s\nTotal duration: %d minutes",
                totalTasks, mostFrequentTask, maxFrequency, highestPriorityTask, totalDuration);
    }
}