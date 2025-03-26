package org.example.service;

import org.example.entity.Dishes;

import java.time.LocalDate;
import java.util.List;

public interface DishesService {

    Dishes createDishes(Dishes dishes);

    List<Dishes> getAll();

    void dishesForDay(Long id, LocalDate dateTime);
}
