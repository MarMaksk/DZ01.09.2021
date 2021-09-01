package com.company.task2;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private String heading, description, whoExecute;
    private int priority;
    private Date dateStart, dateEnd;
    private boolean done = false;

    public Task(String heading, String description, int priority, String whoExecute, String dateStart, String dateEnd) {
        this.heading = heading;
        this.description = description;
        this.priority = priority;
        this.whoExecute = whoExecute;
        try {
            this.dateStart = sdf.parse(dateStart);
            this.dateEnd = sdf.parse(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhoExecute() {
        return whoExecute;
    }

    public void setWhoExecute(String whoExecute) {
        this.whoExecute = whoExecute;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Задача:" +
                " название'" + heading + '\'' +
                ", описание='" + description + '\'' +
                ", для кого='" + whoExecute + '\'' +
                ", приоритет=" + priority +
                ", дата начала=" + dateStart +
                ", дата окончания=" + dateEnd +
                ", статус=" + done;
    }
}

