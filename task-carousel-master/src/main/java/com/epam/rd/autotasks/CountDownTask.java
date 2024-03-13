package com.epam.rd.autotasks;

public class CountDownTask implements Task{

    private int countdown;

    public CountDownTask(int value) {
        countdown = value < 0 ? 0:value;
    }

    public int getValue() {
        return countdown;
    }


    @Override
    public void execute() {
        if(countdown>0) countdown--;
    }

    @Override
    public boolean isFinished() {
        return countdown == 0;
    }
}
