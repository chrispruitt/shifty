package com.pru.shifty.api.model;

import com.pru.shifty.api.util.Violation;

//Contains shiftId to associate the shift with the violation.
//Here the shiftId is not a primitive type since not all violations will have a shift associated.
public class ViolationAnalysis {
    private Violation violation;
    private Long shiftId;

    public ViolationAnalysis(Violation violation, Long shiftId) {
        this.violation = violation;
        this.shiftId = shiftId;
    }

    public ViolationAnalysis(Violation violation) {
        this.violation = violation;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }
}
