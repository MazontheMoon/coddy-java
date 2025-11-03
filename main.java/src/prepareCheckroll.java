/*
Create a function named prepareCheckroll that receives workerIds, hoursWorked, and hourlyWage as its parameters.

The function should prepare a checkroll for workers at a construction site using advanced hashing techniques and data structures. It will manage worker attendance, hours worked, and calculate wages efficiently.

Implement the following steps in your solution:
- Create a custom hash table to store worker information efficiently. Use a linked list to handle collisions in the hash table.
- Utilize the provided 2D array to store daily hours worked for each worker.
- Calculate the total hours worked and wages for each worker.
- Generate a checkroll report, combining data from multiple data structures.

Parameters:
- workerIds (int[]): An array of unique integer IDs representing each worker.
- hoursWorked (int[][]): A 2D array where each row represents a worker and each column represents the hours worked by that worker on a specific day of the month.
- hourlyWage (int): An integer representing the hourly wage rate for all workers.

The function returns a string array where each string represents the summary for a worker in the format: "Worker ID: <workerId>, Total Hours Worked: <totalHours>, Total Wages: <totalWages>".

Constraints:
- Each workerId in workerIds will be unique.
- The length of each row in hoursWorked will be the same and corresponds to the number of days in a month (assume 30 days).
- Hourly wage hourlyWage will be a positive integer.
- 1 ≤ number of workers ≤ 1000
- 0 ≤ hours worked per day ≤ 24


 */

import java.util.*;

class PrepareCheckroll {
    private static class Worker {
        int id;
        int totalHours;
        int totalWages;
        Worker next;

        Worker(int id) {
            this.id = id;
            this.totalHours = 0;
            this.totalWages = 0;
            this.next = null;
        }
    }

    private static class HashTable {
        private Worker[] table;
        private int size;

        HashTable(int size) {
            this.size = size;
            this.table = new Worker[size];
        }

        private int hash(int key) {
            return key % size;
        }

        void put(int id) {
            int index = hash(id);
            Worker newWorker = new Worker(id);
            if (table[index] == null) {
                table[index] = newWorker;
            } else {
                Worker current = table[index];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newWorker;
            }
        }

        Worker get(int id) {
            int index = hash(id);
            Worker current = table[index];
            while (current != null) {
                if (current.id == id) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }
    }

    public static String[] prepareCheckroll(int[] workerIds, int[][] hoursWorked, int hourlyWage) {
        HashTable workerTable = new HashTable(workerIds.length);

        for (int id : workerIds) {
            workerTable.put(id);
        }

        for (int i = 0; i < workerIds.length; i++) {
            Worker worker = workerTable.get(workerIds[i]);
            for (int hours : hoursWorked[i]) {
                worker.totalHours += hours;
            }
            worker.totalWages = worker.totalHours * hourlyWage;
        }

        String[] checkroll = new String[workerIds.length];
        for (int i = 0; i < workerIds.length; i++) {
            Worker worker = workerTable.get(workerIds[i]);
            checkroll[i] = String.format("Worker ID: %d, Total Hours Worked: %d, Total Wages: %d",
                    worker.id, worker.totalHours, worker.totalWages);
        }

        return checkroll;
    }
}