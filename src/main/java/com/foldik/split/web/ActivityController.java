package com.foldik.split.web;

import com.foldik.split.persistence.model.Activity;
import com.foldik.split.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping("/activities")
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }
}
