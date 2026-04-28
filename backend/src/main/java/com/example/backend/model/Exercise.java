package com.example.backend.model;

public class Exercise {
    private Long id;
    private String name;
    private int sets;
    private int reps;
    private Integer weight; // может быть null


    public Exercise() {}


    public Exercise(Long id, String name, int sets, int reps, Integer weight) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }

    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }
}