package com.tracker.service;

import com.tracker.entity.Tracker;
import com.tracker.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackerService {

    @Autowired
    TrackerRepository trackerRepository;

    public List<Tracker> getTracker(){
        return trackerRepository.findAll();
    }

    public Tracker getTrackerById(int id) throws Exception {
        Tracker update = trackerRepository.findById(id)
                .orElseThrow(() -> new Exception("Tracker does not exist with id: " + id));

        return  update;
    }

    public Tracker addTracker(Tracker tracker){
        return trackerRepository.save(tracker);
    }

    public Tracker updateTracker(Tracker tracker, int id) throws Exception {
        Tracker update = trackerRepository.findById(id)
                .orElseThrow(() -> new Exception("Tracker does not exist with id: " + id));
        update.setReminder(tracker.isReminder());
        update.setTracker_id(id);
        update.setText(tracker.getText());
        update.setTask_day(tracker.getTask_day());
        return trackerRepository.save(update);
    }

    public void deleteTracker(int id){
        trackerRepository.deleteById(id);
    }
}
