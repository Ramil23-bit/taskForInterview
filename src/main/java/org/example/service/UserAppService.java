package org.example.service;


import org.example.entity.UserApp;

public interface UserAppService {

    UserApp getById(Long id);

    UserApp createUser(UserApp userApp);

    UserApp addDishesForUser(Long id, Long idDishes);

    Double countCalories(Long id);

    Double caloriesForDay(Long id);
}
