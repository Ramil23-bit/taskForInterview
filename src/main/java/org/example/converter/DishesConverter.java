package org.example.converter;

import org.example.dto.DishesCreateDto;
import org.example.dto.DishesResponseDto;
import org.example.entity.Dishes;
import org.springframework.stereotype.Component;

@Component
public class DishesConverter implements Converter<Dishes, DishesCreateDto, DishesResponseDto>{
    @Override
    public DishesResponseDto toDto(Dishes dishes) {
        return new DishesResponseDto(dishes.getName(), dishes.getNumberOfCalories());
    }

    @Override
    public Dishes toEntity(DishesCreateDto dishesCreateDto) {
        return new Dishes(dishesCreateDto.getName(), dishesCreateDto.getNumberOfCalories(),
                dishesCreateDto.getProteins(), dishesCreateDto.getFats(), dishesCreateDto.getCarbohydrates());
    }
}
