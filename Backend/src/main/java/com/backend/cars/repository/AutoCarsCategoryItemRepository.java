package com.backend.cars.repository;

import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsCategoryItem;
import com.backend.cars.model.AutoCarsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoCarsCategoryItemRepository extends JpaRepository<AutoCarsCategoryItem, Integer> {
    List<AutoCarsCategoryItem> findByAutoCarsCategoryAndState(AutoCarsCategory autoCarsCategory, int state);
    List<AutoCarsCategoryItem> findByAutoCarsItemAndState(AutoCarsItem autoCarsItem, int state);
    List<AutoCarsCategoryItem> findByAutoCarsItemAndStateIsNot(AutoCarsItem autoCarsItem, int state);
    List<AutoCarsCategoryItem> findByAutoCarsCategoryAndStateIsNot(AutoCarsCategory autoCarsCategory, int state);

}
