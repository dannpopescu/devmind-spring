package com.danpopescu;

public class Task {

    private int id;
    private String name;
    private int executionTime;

    private static int numberOfTasks = 0;
    private static int idSequence = 0;

    public void run() {
        try {
            System.out.println("Executing " + name + ". Needed time: " + executionTime + " seconds");
            Thread.sleep(executionTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        id = generateId();
        name = "Task " + id;
        executionTime = (int) (Math.random() * 5) + 1;
        numberOfTasks++;
        System.out.println("Created " + name);
    }

    private void destroy() {
        System.out.println("Destroyed task: " + name);
        numberOfTasks--;
    }

    public static int generateId() {
        return idSequence++;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }
}
