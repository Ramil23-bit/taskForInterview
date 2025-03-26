package org.example.controller;

import org.example.converter.Converter;
import org.example.dto.UserAppCreateDto;
import org.example.dto.UserAppResponseDto;

import org.example.entity.UserApp;
import org.example.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_app")
public class UserAppController {

    @Autowired
    private UserAppService userAppService;

    @Autowired
    private Converter<UserApp, UserAppCreateDto, UserAppResponseDto> converter;


    @PostMapping("/create")
    public ResponseEntity<UserAppResponseDto> createUser(@RequestBody UserAppCreateDto userAppCreateDto){
        UserApp userApp = converter.toEntity(userAppCreateDto);
        UserApp userSaved = userAppService.createUser(userApp);
        UserAppResponseDto userAppResponseDto = converter.toDto(userSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAppResponseDto);
    }

    @PutMapping("/add_meal/{id}")
    public ResponseEntity<UserAppResponseDto> update(@PathVariable("id") Long id, @RequestBody Long idDishes){
        UserApp userSaved = userAppService.addDishesForUser(id,idDishes);
        UserAppResponseDto userAppResponseDto = converter.toDto(userSaved);
        return ResponseEntity.status(HttpStatus.OK).body(userAppResponseDto);
    }

    @GetMapping("/count_calories/{id}")
    public Double calories(@PathVariable("id") Long id){
        return userAppService.countCalories(id);
    }

    @GetMapping("/norma/{id}")
    private Double normaCalories(@PathVariable("id") Long id){
        return userAppService.caloriesForDay(id);
    }

}
