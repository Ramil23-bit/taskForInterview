package org.example.dto;


public class DishesResponseDto {

    private String name;

    private Double numberOfCalories;

    public DishesResponseDto(String name, Double numberOfCalories) {
        this.name = name;
        this.numberOfCalories = numberOfCalories;
    }

    public DishesResponseDto() {
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
}
