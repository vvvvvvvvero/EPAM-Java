package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Objects;

public class Ticket {

    protected int id;
    protected String name;
    protected int estimateHoursToComplete;
    protected boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimateHoursToComplete = estimate;
        isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }

    public int getEstimate() {
        return estimateHoursToComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && estimateHoursToComplete == ticket.estimateHoursToComplete && isCompleted == ticket.isCompleted && Objects.equals(name, ticket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, estimateHoursToComplete, isCompleted);
    }
}
