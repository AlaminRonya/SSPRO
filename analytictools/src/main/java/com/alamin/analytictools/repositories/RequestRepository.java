package com.alamin.analytictools.repositories;

import com.alamin.analytictools.model.RequestTracker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
public class RequestRepository {
    private final List<RequestTracker> trackers = new CopyOnWriteArrayList<>();
    public void addTracker(RequestTracker tracker) {
        trackers.add(tracker);
    }
    public List<RequestTracker> getTrackers() {
        log.info("-----------------------------------");
        trackers.forEach(tracker -> log.info(tracker.toString()));
        log.info("-----------------------------------");
        return List.copyOf(this.trackers);
    }
}
