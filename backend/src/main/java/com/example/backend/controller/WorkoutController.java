package com.example.backend.controller;

import com.example.backend.model.Workout;
import com.example.backend.security.JwtUtil;
import com.example.backend.service.WorkoutService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;
    private final JwtUtil jwtUtil;

    public WorkoutController(WorkoutService workoutService, JwtUtil jwtUtil) {
        this.workoutService = workoutService;
        this.jwtUtil = jwtUtil;
    }

    private Long getUserId(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            return jwtUtil.extractUserId(token);
        }
        throw new RuntimeException("No token");
    }

    @GetMapping
    public List<Workout> getWorkouts(HttpServletRequest request) {
        return workoutService.getWorkoutsByUser(getUserId(request));
    }

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout, HttpServletRequest request) {
        workout.setUserId(getUserId(request));
        return workoutService.createWorkout(workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id, HttpServletRequest request) {
        workoutService.deleteWorkout(id, getUserId(request));
    }
}