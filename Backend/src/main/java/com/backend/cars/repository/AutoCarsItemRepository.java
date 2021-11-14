package com.backend.cars.repository;

import com.backend.cars.model.AutoCarsItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoCarsItemRepository extends JpaRepository<AutoCarsItem, Integer> {
    AutoCarsItem findByIdAndState(int id, int state);
    List<AutoCarsItem> findByStateAndPublished(int state, int published);

    @Query(value = "SELECT sci FROM AutoCarsItem sci " +
            "WHERE sci.state = 1 " +
            "AND sci.published = :published " +
            "AND (sci.title like %:filter% or sci.content like %:filter% or sci.description like %:filter%) ")
    List<AutoCarsItem> findByFilter(@Param("filter") String filter, @Param("published") int published);

}
