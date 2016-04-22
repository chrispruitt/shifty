package com.pru.shifty.api.controller;

import com.pru.shifty.api.basic.RestError;
import com.pru.shifty.api.basic.RestResponse;
import com.pru.shifty.api.model.DutyHourAnalysis;
import com.pru.shifty.api.model.User;
import com.pru.shifty.api.service.DutyHourAnalysisService;
import com.pru.shifty.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/user/{userId}")
public class DutyHourAnalysisController {

    @Autowired
    UserService userService;
    @Autowired
    DutyHourAnalysisService dutyHourAnalysisService;

    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public RestResponse<DutyHourAnalysis> getDutyHourAnalysis(
            @PathVariable("userId") long userId,
            @RequestParam("startDate") Date startDate) {

        RestResponse<DutyHourAnalysis> response = new RestResponse<DutyHourAnalysis>();
        User user = userService.get(userId);
        if (user == null) {
            response.addRestError(new RestError("User not found"));
            return response;
        }

        DutyHourAnalysis dutyHourAnalysis = dutyHourAnalysisService.get(userId, startDate);
        response.addResponse(dutyHourAnalysis);
        return response;
    }

    /*TODO: Add Other operations if needed.
            When an admin requests an analysis for multiple residents, I may handle it on the front end to make
            multiple calls. However if there is too much overhead I could add a rest method here to take in a
            list of userIds and return a DutyHourAnalysis list.
    */
}