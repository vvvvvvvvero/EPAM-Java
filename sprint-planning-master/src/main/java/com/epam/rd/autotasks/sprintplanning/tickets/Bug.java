package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Objects;

public class Bug extends Ticket {
    UserStory userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || !userStory.isCompleted())
        {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;

    }

    public UserStory getUserStory() {
        return userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + id + "]" + " " + userStory.name + ": " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bug bug = (Bug) o;
        return Objects.equals(userStory, bug.userStory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userStory);
    }
}
