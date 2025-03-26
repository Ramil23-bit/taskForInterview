package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double numberOfCalories;

    private Double proteins;

    private Double fats;

    private Double carbohydrates;

    private LocalDate timeAdd;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserApp user;


    public Dishes(Long id, String name, Double numberOfCalories,
                  Double proteins, Double fats, Double carbohydrates) {
        this.id = id;
        this.name = name;
        this.numberOfCalories = numberOfCalories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;

    }

    public Dishes(String name, Double numberOfCalories, Double proteins, Double fats, Double carbohydrates) {
        this.name = name;
        this.numberOfCalories = numberOfCalories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Dishes(Long id, String name, Double numberOfCalories, Double proteins,
                  Double fats, Double carbohydrates, LocalDate timeAdd, UserApp userApp) {
        this.id = id;
        this.name = name;
        this.numberOfCalories = numberOfCalories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.timeAdd = timeAdd;
        this.user = userApp;
    }

    public Dishes() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(Double numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public LocalDate getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(LocalDate timeAdd) {
        this.timeAdd = timeAdd;
    }

    public UserApp getUsers() {
        return user;
    }

    public void setUsers(UserApp user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfCalories=" + numberOfCalories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", timeAdd=" + timeAdd +
                ", user=" + user +
                '}';
    }
}
