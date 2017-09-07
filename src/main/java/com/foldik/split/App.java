package com.foldik.split;

import com.foldik.split.persistence.ActivityRepository;
import com.foldik.split.persistence.model.Activity;
import com.foldik.split.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ActivityRepository activityRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                /*activityRepository.save(activity(
                        "Programming" + UUID.randomUUID().toString(),
                        "2017-09-07T17:00:00",
                        "2017-09-07T18:00:00"));*/
               User user=addUser("TOZOGABEE");

            }
        }, 100, 250);




    }

    private Activity activity(String name, String start, String end,User user) {
        Activity activity = new Activity();
        activity.setActivityName(name);
        activity.setStartTime(LocalDateTime.parse(start));
        activity.setEndTime(LocalDateTime.parse(end));
        activity.setUser(user);
        return activity;
    }

    private User addUser(String name,List<Activity> activities)
    {
        User user1=new User();
        user1.setName(name);
        user1.setActivityList(activities);
        return user1;
    }
}
