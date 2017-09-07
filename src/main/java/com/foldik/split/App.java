package com.foldik.split;

import com.foldik.split.persistence.ActivityRepository;
import com.foldik.split.persistence.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

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
                activityRepository.save(activity(
                        "Programming" + UUID.randomUUID().toString(),
                        "2017-09-07T17:00:00",
                        "2017-09-07T18:00:00"));
            }
        }, 100, 250);
    }

    private Activity activity(String name, String start, String end) {
        Activity activity = new Activity();
        activity.setActivityName(name);
        activity.setStartTime(LocalDateTime.parse(start));
        activity.setEndTime(LocalDateTime.parse(end));
        return activity;
    }
}
