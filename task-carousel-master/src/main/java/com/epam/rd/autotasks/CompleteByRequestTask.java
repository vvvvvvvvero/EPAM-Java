package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean completed = false;
    private boolean executed = false;

    @Override
    public void execute() {
        if(completed) executed = true;
    }

    @Override
    public boolean isFinished(){
        return executed;
    }

    public void complete() {
        completed = true;
    }
}
