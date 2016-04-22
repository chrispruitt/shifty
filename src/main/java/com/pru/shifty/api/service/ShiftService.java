package com.pru.shifty.api.service;

import com.pru.shifty.api.model.Shift;

import java.util.Date;
import java.util.List;

public interface ShiftService {
    Shift get(long id);
    void create(Shift user);
    void update(Shift user);
    void delete(long id);
    List<Shift> getShiftsByUserId(long userId);

    //TODO: Return shifts in order by startDate in a specific time frame for more efficient processing during analysis
    //TODO: We would be getting the shift if the shift.startDate or shift.endate is between the given dates
    List<Shift> getShiftsByPeriod(long userId, Date startDate, Date endDate);
}
