package org.example.service;

import org.example.dto.UserAppCreateDto;
import org.example.entity.Dishes;
import org.example.entity.UserApp;
import org.example.enums.Gender;
import org.example.enums.Target;
import org.example.exception.UserAppNotFoundException;
import org.example.repository.UserAppJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAppServiceImplTest {
    @Mock
    private UserAppJpaRepository userAppJpaRepository;

    @InjectMocks
    private UserAppServiceImpl userAppService;

    private UserAppCreateDto userAppCreateDto;


    @Test
    public void getByIdUserWhenUserExist(){
        Long userId = 1L;
        UserApp expectedUser = new UserApp();
        expectedUser.setId(userId);

        Mockito.when(userAppJpaRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        UserApp actualUser = userAppService.getById(userId);
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser, "User must match the expected result");
    }

    @Test
    public void getByIdUserWhenUserNotExist() {
        Long userId = 1L;

        Mockito.when(userAppJpaRepository.findById(userId))
                .thenThrow(new UserAppNotFoundException("User not Found"));

        assertThrows(UserAppNotFoundException.class, () -> userAppService.getById(userId));
    }

    @Test
    public void createUserReturnSavedUser() {
        UserApp userExpected = new UserApp("Igor", "igor@igor.com", 23L, 176.0, 74.4,
                Target.MAINTENANCE, Gender.MAN);
        Mockito.when(userAppJpaRepository.save(userExpected))
                .thenReturn(userExpected);

        UserApp userActual = userAppService.createUser(userExpected);

        assertNotNull(userActual, "User must not be null");
        assertEquals("Igor", userActual.getName(), "Username must be Igor");
        Mockito.verify(userAppJpaRepository, times(1)).save(userExpected);
    }

    @Test
    public void updateUserWhenUserNotFound() {
        List<Dishes> meal = new ArrayList<>();
        String name = "";

        when(userAppJpaRepository.findById(1L)).thenReturn(Optional.empty());

        UserAppNotFoundException userNotFoundException = assertThrows(UserAppNotFoundException.class, () -> {
            userAppService.addDishesForUser(1L, 1L);
        });

        assertEquals("User by id 1 not found", userNotFoundException.getMessage());
    }

    @Test
    public void countCaloriesWhenUserNotFound(){
        Long userId = 1L;

        Mockito.when(userAppJpaRepository.findById(userId))
                .thenThrow(new UserAppNotFoundException("User not Found"));

        assertThrows(UserAppNotFoundException.class, () -> userAppService.countCalories(userId));
    }

    @Test
    public void countCaloriesWhenUserExist(){
        Long id = 1L;
        UserApp userApp = new UserApp(id,"Igor", "igor@igor.com", 23L, 176.0, 74.4,
                Target.MAINTENANCE, Gender.MAN);
        List<Dishes> meal = new ArrayList<>();
        Dishes dishesApple = new Dishes("Apple", 230.2, 23.0, 12.4, 3.6);
        Dishes dishesMeat = new Dishes("Meat", 460.0, 54.0, 87.9, 34.8);
        meal.add(dishesApple);
        meal.add(dishesMeat);
        userApp.setDishesList(meal);

        Mockito.when(userAppJpaRepository.findById(id)).thenReturn(Optional.of(userApp));

        Double count = userAppService.countCalories(id);
        assertNotNull(userApp);
        assertEquals(count, 690.2);
    }

    @Test
    public void caloriesForDayWhenUserNotFound(){
        Long userId = 1L;

        Mockito.when(userAppJpaRepository.findById(userId))
                .thenThrow(new UserAppNotFoundException("User not Found"));

        assertThrows(UserAppNotFoundException.class, () -> userAppService.caloriesForDay(userId));
    }

    @Test
    public void caloriesForDayWhenUserExist(){
        Long id = 1L;
        UserApp userApp = new UserApp(id,"Igor", "igor@igor.com", 23L, 176.0, 74.4,
                Target.MAINTENANCE, Gender.MAN);

        Mockito.when(userAppJpaRepository.findById(id)).thenReturn(Optional.of(userApp));

        assertEquals(userAppService.caloriesForDay(id), 2672.7086);
    }
}
