package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.enums.Gender;
import org.example.enums.Target;


public class UserAppCreateDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("age")
    private Long age;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("target")
    private Target target;
    @JsonProperty("gender")
    private Gender gender;

    public UserAppCreateDto(String name, String email, Long age, Double weight, Double height,
                            Target target, Gender gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.target = target;
        this.gender = gender;
    }


    public UserAppCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
