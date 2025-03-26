package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DishesCreateDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("numberOfCalories")
    private Double numberOfCalories;

    @JsonProperty("proteins")
    private Double proteins;

    @JsonProperty("fats")
    private Double fats;

    @JsonProperty("carbohydrates")
    private Double carbohydrates;

    public DishesCreateDto(String name, Double numberOfCalories,
                           Double proteins, Double fats, Double carbohydrates) {
        this.name = name;
        this.numberOfCalories = numberOfCalories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public DishesCreateDto() {
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
}
