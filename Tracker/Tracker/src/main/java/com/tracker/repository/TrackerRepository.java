package com.tracker.repository;

import com.tracker.entity.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Integer> {

}
