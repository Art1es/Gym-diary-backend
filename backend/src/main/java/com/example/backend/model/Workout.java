package com.example.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    private Long id;
    private String name;
    private LocalDate date;
    private Long userId;
    private List<Exercise> exercises = new ArrayList<>();

    public Workout() {
    }

    public Workout(Long id, String name, LocalDate date, Long userId, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.userId = userId;
        this.exercises = exercises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}