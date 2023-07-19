package com.tracker.controller;

import com.tracker.entity.Tracker;
import com.tracker.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/tracker")
public class TrackerController {

    @Autowired
    TrackerService trackerService;

    @GetMapping("/all")
    public ResponseEntity<List<Tracker>> getAllTracks(){
        return new ResponseEntity<>(trackerService.getTracker(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tracker> getTrackerById(@PathVariable("id") String id) throws Exception {
        int realid = Integer.parseInt(id);
        return new ResponseEntity<>(trackerService.getTrackerById(realid), HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<Tracker> addTracker(@RequestBody Tracker tracker) throws Exception {
        Tracker newTracker = trackerService.addTracker(tracker);
        if (newTracker == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(newTracker, HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/update/{id}", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<Tracker> updateTracker(@PathVariable("id") String id, @RequestBody Tracker tracker) throws Exception {
        int realid = Integer.parseInt(id);
        return new ResponseEntity<>(trackerService.updateTracker(tracker, realid), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTracker(@PathVariable int id){
        trackerService.deleteTracker(id);
    }
}
