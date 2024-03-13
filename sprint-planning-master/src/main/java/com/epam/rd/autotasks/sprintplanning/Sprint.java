package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;


import java.util.Arrays;

public class Sprint {

    private int timeCapacity; //hours to complete capacity
    private int ticketsLimit;
    private Ticket[] tickets;
    private int ticketsAdded = 0;
    private int totalSizeOfTimeCapacity = 0; //total size of hours to complete of each ticket

    public Sprint(int capacity, int ticketsLimit) {
        this.timeCapacity = capacity;
        this.ticketsLimit = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if (addTicketCheck(userStory))
        {
            if (hasDependenciesInSprint(userStory))
            {
                addTicket(userStory);
                return true;
            }
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if (addTicketCheck(bugReport))
        {
            addTicket(bugReport);
            addUserStory(bugReport.getUserStory());
            return true;
        }
        return false;
    }

    private boolean addTicketCheck(Ticket ticket){
        if(ticket == null || ticket.isCompleted()) return false;
        if(ticket.getEstimate() + totalSizeOfTimeCapacity > timeCapacity) return false;
        if(ticketsAdded == ticketsLimit) return false;
        return true;
    }

    private boolean addTicket(Ticket ticket)
    {
        if (tickets == null)
        {
            tickets = new Ticket[1];
        }
        else
        {
            tickets = Arrays.copyOf(tickets, ticketsAdded + 1);
        }
        tickets[ticketsAdded++] = ticket;
        totalSizeOfTimeCapacity += ticket.getEstimate();
        return true;
    }



    public Ticket[] getTickets() {

        Ticket [] copy = new Ticket[tickets.length];
        int index = 0;
        for (Ticket ticket : tickets)
        {
            if (ticket instanceof UserStory)
            {
                UserStory userStory = (UserStory) ticket;
                copy[index++] = new UserStory(userStory.getId(), userStory.getName(), userStory.getEstimate());
            }
            else
            {
                Bug bug = (Bug) ticket;
                copy[index++] = Bug.createBug(bug.getId(), bug.getName(), bug.getEstimate(), bug.getUserStory());
            }

        }
        return copy;

    }

    private boolean hasDependenciesInSprint(UserStory userStory)
    {
        for (UserStory us : userStory.getDependencies())
        {
            if (!hasUserStory(us))
            {
                return false;
            }
        }
        return true;
    }

    private boolean hasUserStory(UserStory userStory)
    {
        if (tickets == null)
        {
            return false;
        }
        else
        {
            for (Ticket ticket : tickets)
            {
                if (ticket instanceof UserStory)
                {
                    UserStory us = (UserStory) ticket;
                    if (us.equals(userStory))
                    {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public int getTotalEstimate() {
        return totalSizeOfTimeCapacity;
    }




}
