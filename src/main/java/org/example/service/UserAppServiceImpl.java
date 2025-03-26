package org.example.service;

import org.example.entity.Dishes;
import org.example.entity.UserApp;
import org.example.enums.Gender;
import org.example.exception.UserAppNotFoundException;
import org.example.repository.UserAppJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private UserAppJpaRepository userAppJpaRepository;

    @Autowired
    private DishesService dishesService;


    @Override
    public UserApp getById(Long id) {
        return userAppJpaRepository.findById(id)
                .orElseThrow(() -> new UserAppNotFoundException("User by id " + id + " not found"));
    }

    @Override
    public UserApp createUser(UserApp userApp) {
        return userAppJpaRepository.save(userApp);
    }

    @Override
    public UserApp addDishesForUser(Long id, Long idDishes) {
        UserApp currentUser = getById(id);
        LocalDate dateTime = LocalDate.now();
        List<Dishes> dishesList = dishesService.getAll();

        for(Dishes dishes : dishesList){
            if(Objects.equals(dishes.getId(), idDishes)){
                currentUser.getDishesList().add(dishes);
                dishes.setTimeAdd(dateTime);
                dishes.setUsers(currentUser);
            }
        }
        return userAppJpaRepository.save(currentUser);
    }

    @Override
    public Double countCalories(Long id) {
        UserApp currentUser = getById(id);
        Double sumCalories = 0.0;
        List<Dishes> dishesList = currentUser.getDishesList();
        for (Dishes dishes : dishesList) {
            sumCalories += dishes.getNumberOfCalories();
        }
        return sumCalories;
    }

    @Override
    public Double caloriesForDay(Long id) {
        Double norma = normCalorie(id);
        Double currentCalories = countCalories(id);
        if (norma > currentCalories) {
            System.out.println(" Можно еще покушать");
            return norma - currentCalories;
        } else if (norma < currentCalories) {
            System.out.println(" Слишком много поел");
            return currentCalories - norma;
        } else {
            System.out.println("Уложился в норму");
            return norma;
        }
    }


    private Double normCalorie(Long id) {
        UserApp currentUser = getById(id);
        double caloriesForDay;
        if (currentUser.getGender().equals(Gender.MAN)) {
            caloriesForDay = 88.362 + (13.397 * currentUser.getWeight() +
                    (4.799 * currentUser.getHeight() - (5.677 * currentUser.getAge())));
        } else {
            caloriesForDay = 447.593 + (9.247 * currentUser.getWeight() +
                    (3.098 * currentUser.getHeight() - (4.330 * currentUser.getAge())));
        }
        return caloriesForDay;
    }
}
