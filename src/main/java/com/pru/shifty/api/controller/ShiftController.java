package com.pru.shifty.api.controller;

import com.pru.shifty.api.basic.RestError;
import com.pru.shifty.api.basic.RestResponse;
import com.pru.shifty.api.model.Shift;
import com.pru.shifty.api.model.User;
import com.pru.shifty.api.service.ShiftService;
import com.pru.shifty.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/{userId}")
public class ShiftController {

    @Autowired
    ShiftService shiftService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/shift", method = RequestMethod.GET)
    public RestResponse<List<Shift>> getShifts(@PathVariable("userId") long userId) {
        RestResponse<List<Shift>> response = new RestResponse<List<Shift>>();
        User user = userService.get(userId);
        if (user == null) {
            response.addRestError(new RestError("User not found"));
            return response;
        }
        List<Shift> shifts = shiftService.getShiftsByUserId(userId);
        response.addResponse(shifts);
        return response;
    }

    //TODO: Add shift CRUD operations like in UserController
}
