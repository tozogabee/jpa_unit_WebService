package com.foldik.split.persistence;

import com.foldik.split.persistence.model.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

    Iterable<Activity> findAllByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    @Query("select a from Activity a where (a.startTime between :start and :end) or (a.endTime between :start and :end)")
    List<Activity> findActivitiesBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}