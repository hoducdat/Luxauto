package com.backend.cars.repository;

import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoCarsCategoryRepository  extends JpaRepository<AutoCarsCategory, Integer> {
    Long countByState(int state);
    AutoCarsCategory findByIdAndState(int id, int state);
    List<AutoCarsCategory> findByState(int state);

    @Query(value = "SELECT scc FROM AutoCarsCategory scc" +
            " LEFT JOIN scc.sellCarCategoryItem scci " +
            " WHERE scci.autoCarsItem = :autoCarsItem " +
            " AND scci.state = 1 " +
            " AND scc.state = 1 " )
    List<AutoCarsCategory> findByAutoCarsItem(AutoCarsItem autoCarsItem);
}
