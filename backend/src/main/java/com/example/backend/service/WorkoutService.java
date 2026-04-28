package com.example.backend.service;

import com.example.backend.model.Workout;
import com.example.backend.repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getWorkoutsByUser(Long userId) {
        return workoutRepository.findByUserId(userId);
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long id, Long userId) {
        Workout w = workoutRepository.findById(id);
        if (w == null || !w.getUserId().equals(userId)) {
            throw new RuntimeException("Workout not found or not owned");
        }
        workoutRepository.deleteById(id);
    }
}