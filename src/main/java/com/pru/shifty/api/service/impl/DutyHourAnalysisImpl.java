package com.pru.shifty.api.service.impl;

import com.pru.shifty.api.model.DutyHourAnalysis;
import com.pru.shifty.api.model.Shift;
import com.pru.shifty.api.model.ViolationAnalysis;
import com.pru.shifty.api.service.DutyHourAnalysisService;
import com.pru.shifty.api.service.ShiftService;
import com.pru.shifty.api.util.Violation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.pru.shifty.api.util.ShiftDateUtils.getEndWeeksEnd;
import static com.pru.shifty.api.util.ShiftDateUtils.getStartOfDay;
import static com.pru.shifty.api.util.TimeUtils.hoursToMillis;

@Service("dutyHourAnalysisService")
public class DutyHourAnalysisImpl implements DutyHourAnalysisService{

    //TODO: Add these to a properties file or DB so they are configurable
    private static final int SHIFT_WEEKS = 4;
    private static final int MIN_HOURS_BETWEEN_SHIFTS = 8;
    private static final int TWENTY_FOUR_HOURS = 24;
    private static final int WEEK_MAX_HOURS = 80;
    private static final int SHIFT_MAX_HOURS = SHIFT_WEEKS * WEEK_MAX_HOURS;

    @Autowired
    ShiftService shiftService;

    public DutyHourAnalysis get(long userId, Date startDate) {
        DutyHourAnalysis dha = new DutyHourAnalysis(userId);
        dha.setStartDate(getStartOfDay(startDate));
        dha.setEndDate(getEndWeeksEnd(startDate, SHIFT_WEEKS));

        List<Shift> shifts = shiftService.getShiftsByPeriod(userId, dha.getStartDate(), dha.getEndDate());
        dha.setViolations(calculateViolations(shifts, dha.getStartDate(), dha.getEndDate()));

        return dha;
    }

    //Having these violations calculated in a single loop will speed up performance,
    // however in some cases it may be better to split each violation out into its own method to increase readability.
    private List<ViolationAnalysis> calculateViolations(List<Shift> shifts, Date analysisStart, Date analysisEnd){
        List<ViolationAnalysis> violations = new ArrayList<ViolationAnalysis>();
        int twentyFourHourBreakCount = 0;
        long totalShiftTime = 0;

        for(int i = 0; i < shifts.size(); i++) {
            long shiftTime = shiftTimeOnClock(shifts.get(i), analysisStart, analysisEnd);
            if(shiftTime > hoursToMillis(TWENTY_FOUR_HOURS)) {
                violations.add(new ViolationAnalysis(Violation.MAX_SHIFT_HOURS, shifts.get(i).getId()));
            }
            if(totalShiftTime > hoursToMillis(SHIFT_MAX_HOURS)) {
                violations.add(new ViolationAnalysis(Violation.MAX_HOURS_WEEK_AVG, shifts.get(i).getId()));
            }
            if(i+1 < shifts.size()) {
                long breakTime = shifts.get(i+1).getStartTime().getTime() - shifts.get(i).getEndTime().getTime();
                if(breakTime < hoursToMillis(MIN_HOURS_BETWEEN_SHIFTS)) {
                    violations.add(new ViolationAnalysis(Violation.MIN_OFF_HOURS_BETWEEN_SHIFTS, shifts.get(i).getId()));
                }
                if(breakTime >= hoursToMillis(TWENTY_FOUR_HOURS)) {
                    twentyFourHourBreakCount++;
                }
            }
        }

        if(twentyFourHourBreakCount < SHIFT_WEEKS) {
            violations.add(new ViolationAnalysis(Violation.MIN_OFF_HOURS_WEEK_AVG));
        }

        return violations;
    }

    private long shiftTimeOnClock(Shift shift, Date analysisStart, Date analysisEnd) {
        if(shift.getStartTime().compareTo(analysisStart)<0){
            return analysisStart.getTime() - shift.getEndTime().getTime();
        } else if(shift.getEndTime().compareTo(analysisEnd)<0) {
            return shift.getEndTime().getTime() - shift.getStartTime().getTime();
        } else {
            return analysisEnd.getTime() - shift.getStartTime().getTime();
        }
    }
}
