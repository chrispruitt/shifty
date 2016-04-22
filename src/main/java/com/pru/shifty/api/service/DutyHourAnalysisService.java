package com.pru.shifty.api.service;

import com.pru.shifty.api.model.DutyHourAnalysis;

import java.util.Date;

public interface DutyHourAnalysisService {

    DutyHourAnalysis get(long userId, Date startDate);

}
