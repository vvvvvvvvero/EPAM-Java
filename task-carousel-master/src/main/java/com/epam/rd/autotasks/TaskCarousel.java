package com.epam.rd.autotasks;

public class TaskCarousel {

    private Task[] tasks;
    private int pointer = 0;
    private int size = 0;

    public TaskCarousel(int capacity) {
        tasks = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if(task == null || task.isFinished() || isFull()) return false;
        int curr = 0;

        while (tasks[curr] != null)curr++;
        tasks[curr] = task;
        size++;
        return true;
    }

    public boolean execute(){
        if(isEmpty()) return false;
        Task task;
        while((task = tasks[pointer % tasks.length]) == null) pointer++;

        task.execute();
        if(task.isFinished()) {
            tasks[pointer % tasks.length] = null;
            size--;
        }
        pointer++;
        return true;
    }

    public boolean isFull() {
        return size == tasks.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
