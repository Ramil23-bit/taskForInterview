package org.example.service;

import org.example.entity.Dishes;
import org.example.entity.UserApp;
import org.example.enums.Gender;
import org.example.enums.Target;
import org.example.repository.DishesJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class DishesServiceImplTest {

    @Mock
    private DishesJpaRepository dishesJpaRepository;

    @InjectMocks
    private DishesServiceImpl dishesService;

    @Test
    public void createDishesReturnSavedDishes() {
        Dishes dishesApple = new Dishes("Apple", 230.2, 23.0, 12.4, 3.6);
        Mockito.when(dishesJpaRepository.save(dishesApple))
                .thenReturn(dishesApple);

        Dishes dishesActual = dishesService.createDishes(dishesApple);

        assertNotNull(dishesActual, "Dishes must not be null");
        assertEquals("Apple", dishesActual.getName(), "Dishes name must be Apple");
        Mockito.verify(dishesJpaRepository, times(1)).save(dishesApple);
    }
}
