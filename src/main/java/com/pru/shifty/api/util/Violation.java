package com.pru.shifty.api.util;

public enum Violation {
    MAX_HOURS_WEEK_AVG("Average is over 80 hours per week."),
    MIN_OFF_HOURS_WEEK_AVG("Average is under 24 hours off per week."),
    MAX_SHIFT_HOURS("Over 24 hours of continuous work."),
    MIN_OFF_HOURS_BETWEEN_SHIFTS("Under 8 hours between shifts.");

    private String discription;

    Violation(String description) {
        this.discription = description;
    }

    public String getDiscription() {
        return discription;
    }
}
