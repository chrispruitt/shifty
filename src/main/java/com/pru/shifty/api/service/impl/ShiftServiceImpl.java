package com.pru.shifty.api.service.impl;

import com.pru.shifty.api.model.Shift;
import com.pru.shifty.api.service.ShiftService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("shiftService")
@Transactional
public class ShiftServiceImpl implements ShiftService{
    public Shift get(long id) {
        //TODO: Get from datasource
        return null;
    }

    public void create(Shift user) {
        //TODO: Add to datasource
    }

    public void update(Shift user) {
        //TODO: Update to datasource
    }

    public void delete(long id) {
        //TODO: Delete from datasource
    }

    public List<Shift> getShiftsByUserId(long userId) {
        //TODO: Return shifts if order by start date
        return null;
    }

    public List<Shift> getShiftsByPeriod(long userId, Date startDate, Date endDate) {
        //TODO: Return shifts in order by startDate in a specific time frame for more efficient processing during analysis
        //TODO: We would be getting the shift if the shift.startDate or shift.endate is between the given dates
        return null;
    }
}
