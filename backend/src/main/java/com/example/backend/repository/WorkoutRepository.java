package com.example.backend.repository;

import com.example.backend.model.Workout;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class WorkoutRepository {
    private final ConcurrentHashMap<Long, Workout> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Workout save(Workout workout) {
        if (workout.getId() == null) {
            workout.setId(idGenerator.getAndIncrement());
        }
        storage.put(workout.getId(), workout);
        return workout;
    }

    public List<Workout> findByUserId(Long userId) {
        return storage.values().stream()
                .filter(w -> w.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public Workout findById(Long id) {
        return storage.get(id);
    }
}