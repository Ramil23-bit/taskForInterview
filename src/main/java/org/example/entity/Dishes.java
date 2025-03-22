package org.example.entity;

import jakarta.persistence.*;
import org.example.entity.UserApp;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private UserApp userApp;

    public Dishes(Long id, String name, Double numberOfCalories,
                  Double proteins, Double fats, Double carbohydrates, UserApp userApp) {
        this.id = id;
        this.name = name;
        this.numberOfCalories = numberOfCalories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.userApp = userApp;
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

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
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
                '}';
    }
}
