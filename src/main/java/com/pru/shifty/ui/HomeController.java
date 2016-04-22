package com.pru.shifty.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView homeView() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/schedule")
    public ModelAndView scheduleView() {
        ModelAndView view = new ModelAndView("schedule");

        //TODO: We could get a list of shifts for a specific period and send to the page like this.
        //TODO: Or we could just render the page and make an ajax call to our REST API via js from the page itself.
        String renderingDataExampleStr = "This is a string to render on schedule page";
        view.addObject("message", renderingDataExampleStr);

        return view;
    }
}
