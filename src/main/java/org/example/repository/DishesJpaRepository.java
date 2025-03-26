package org.example.repository;

import org.example.entity.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DishesJpaRepository extends JpaRepository<Dishes, Long> {

    @Query("SELECT d.name From Dishes d " +
            "JOIN d.user us WHERE us.id = :id  AND d.timeAdd = :date")
    List<Object[]> findDishesForDay(@Param("id") Long id, @Param("date") LocalDate date);
}
