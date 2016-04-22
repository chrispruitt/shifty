package com.pru.shifty.api.model;

import java.util.Date;
import java.util.List;

public class DutyHourAnalysis {
    private long id;
    private long userId;
    private Date startDate;
    private Date endDate;
    private List<ViolationAnalysis> violations;

    public DutyHourAnalysis() {
    }

    public DutyHourAnalysis(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<ViolationAnalysis> getViolations() {
        return violations;
    }

    public void setViolations(List<ViolationAnalysis> violations) {
        this.violations = violations;
    }
}
