package com.tracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Tracker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tracker_id;
    private String text;
    private String task_day;
    private boolean reminder;

    public Tracker() {
    }

    public Tracker(int tracker_id, String text, String task_day, boolean reminder) {
        this.tracker_id = tracker_id;
        this.text = text;
        this.task_day = task_day;
        this.reminder = reminder;
    }

    public int getTracker_id() {
        return tracker_id;
    }

    public void setTracker_id(int tracker_id) {
        this.tracker_id = tracker_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTask_day() {
        return task_day;
    }

    public void setTask_day(String task_day) {
        this.task_day = task_day;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tracker)) return false;
        Tracker tracker = (Tracker) o;
        return getTracker_id() == tracker.getTracker_id() && isReminder() == tracker.isReminder() && Objects.equals(getText(), tracker.getText()) && Objects.equals(getTask_day(), tracker.getTask_day());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTracker_id(), getText(), getTask_day(), isReminder());
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "tracker_id=" + tracker_id +
                ", text='" + text + '\'' +
                ", task_day='" + task_day + '\'' +
                ", reminder=" + reminder +
                '}';
    }
}
