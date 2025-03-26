package org.example.controller;

import org.example.converter.Converter;
import org.example.dto.DishesCreateDto;
import org.example.dto.DishesResponseDto;
import org.example.entity.Dishes;
import org.example.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/dishes")
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @Autowired
    private Converter<Dishes, DishesCreateDto, DishesResponseDto> converter;


    @PostMapping
    public ResponseEntity<DishesResponseDto> createDishes(@RequestBody DishesCreateDto dto){
        Dishes dishes = converter.toEntity(dto);
        Dishes saveDishes = dishesService.createDishes(dishes);
        DishesResponseDto responseDto = converter.toDto(saveDishes);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public void dayDishes(@PathVariable("id") Long id, @RequestParam("time") String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateTime = LocalDate.parse(time, formatter);
        dishesService.dishesForDay(id, dateTime);
    }
}
