package com.foldik.split.service;

import com.foldik.split.persistence.ActivityRepository;
import com.foldik.split.persistence.model.Activity;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    public List<Activity> getActivities() {
        return Lists.newArrayList(activityRepository.findAll());
    }
}
