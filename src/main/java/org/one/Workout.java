package org.one;

class Workout {
    /**
     * This class represents a single workout session for a member.
     * Each object of the Workout class has a
     * ID, as well as
     * a start time and end time that are represented in the number
     * of minutes spent from the start of the day.
     */

    private int id;
    public int startTime;
    public int endTime;

    public Workout(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDuration() {
        return endTime - startTime;
    }
}
