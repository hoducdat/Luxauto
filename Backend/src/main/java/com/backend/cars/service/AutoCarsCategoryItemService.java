package com.backend.cars.service;

import com.backend.cars.constant.State;
import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsCategoryItem;
import com.backend.cars.model.AutoCarsItem;
import com.backend.cars.repository.AutoCarsCategoryItemRepository;
import com.backend.cars.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoCarsCategoryItemService {
    private final AutoCarsCategoryItemRepository autoCarsCategoryItemRepository;

    public AutoCarsCategoryItemService(AutoCarsCategoryItemRepository autoCarsCategoryItemRepository) {
        this.autoCarsCategoryItemRepository = autoCarsCategoryItemRepository;
    }

    public AutoCarsCategoryItem create(AutoCarsItem autoCarsItem, AutoCarsCategory autoCarsCategory) {
        AutoCarsCategoryItem autoCarsCategoryItem = new AutoCarsCategoryItem(autoCarsItem, autoCarsCategory);
        autoCarsCategoryItem = autoCarsCategoryItemRepository.save(autoCarsCategoryItem);
        return autoCarsCategoryItem;
    }

    public List<AutoCarsCategoryItem> getAutoCarsItemListByCategory(AutoCarsCategory autoCarsCategory) {
        return autoCarsCategoryItemRepository.findByAutoCarsCategoryAndState(autoCarsCategory, State.ACTIVE.getId());
    }

    public List<AutoCarsCategoryItem> getAutoCarsItemListByItem(AutoCarsItem autoCarsItem) {
        return autoCarsCategoryItemRepository.findByAutoCarsItemAndState(autoCarsItem, State.ACTIVE.getId());
    }

    public void delete(AutoCarsItem autoCarsItem, AutoCarsCategory autoCarsCategory) {
        List<AutoCarsCategoryItem> autoCarsCategoryItemList = new ArrayList<>();
        if (autoCarsItem != null) {
            autoCarsCategoryItemList = autoCarsCategoryItemRepository.findByAutoCarsItemAndStateIsNot(autoCarsItem, State.DELETE.getId());
        } else if (autoCarsCategory != null) {
            autoCarsCategoryItemList = autoCarsCategoryItemRepository.findByAutoCarsCategoryAndStateIsNot(autoCarsCategory, State.DELETE.getId());
        }
        autoCarsCategoryItemList.forEach(autoCarsCategoryItem -> {
            autoCarsCategoryItem.setModified(DateUtils.getCurrentTimeSecond());
            autoCarsCategoryItem.setState(State.DELETE.getId());
        });
        autoCarsCategoryItemRepository.saveAll(autoCarsCategoryItemList);

    }
}
