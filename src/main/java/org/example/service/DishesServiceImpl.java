package org.example.service;

import org.example.entity.Dishes;
import org.example.repository.DishesJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DishesServiceImpl implements DishesService {

    @Autowired
    private DishesJpaRepository dishesJpaRepository;


    @Override
    public Dishes createDishes(Dishes dishes) {
        return dishesJpaRepository.save(dishes);
    }

    @Override
    public List<Dishes> getAll() {
        return dishesJpaRepository.findAll();
    }

    @Override
    public void dishesForDay(Long id, LocalDate dateTime) {
        List<Object[]> list = dishesJpaRepository.findDishesForDay(id, dateTime);

        for(Object[] dishesDay : list){
            String name = nameDishes(dishesDay);
            System.out.println(name + " dishes");
        }
    }

    private String nameDishes(Object[] dishesDay) {
        return (String) dishesDay[0];
    }
}
