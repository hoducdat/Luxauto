package com.backend.cars.service;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.item.ItemRequestDto;
import com.backend.cars.dto.response.category.CategoryResponseDto;
import com.backend.cars.dto.response.item.ItemResponseDto;
import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsCategoryItem;
import com.backend.cars.model.AutoCarsItem;
import com.backend.cars.repository.AutoCarsItemRepository;
import com.backend.cars.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoCarsItemService {
    private final AutoCarsItemRepository autoCarsItemRepository;
    private final AutoCarsCategoryItemService autoCarsCategoryItemService;

    public AutoCarsItemService(AutoCarsItemRepository autoCarsItemRepository, AutoCarsCategoryItemService autoCarsCategoryItemService) {
        this.autoCarsItemRepository = autoCarsItemRepository;
        this.autoCarsCategoryItemService = autoCarsCategoryItemService;
    }

    public AutoCarsItem createAutoCarsItem(ItemRequestDto itemRequestDto, AutoCarsCategory autoCarsCategory) {
        AutoCarsItem autoCarsItem = new AutoCarsItem(itemRequestDto);
        autoCarsItem = autoCarsItemRepository.save(autoCarsItem);
        autoCarsCategoryItemService.create(autoCarsItem, autoCarsCategory);
        return autoCarsItem;
    }

    public AutoCarsItem update (ItemRequestDto itemRequestDto, AutoCarsItem autoCarsItem) {
        autoCarsItem.update(itemRequestDto);
        autoCarsItemRepository.save(autoCarsItem);
        return autoCarsItem;

    }
    public AutoCarsItem getAutoCarsItemById(int id) {
        return autoCarsItemRepository.findByIdAndState(id, State.ACTIVE.getId());
    }

    public List<AutoCarsItem> getList(int published) {
        return autoCarsItemRepository.findByStateAndPublished(State.ACTIVE.getId(), published);
    }

    public List<AutoCarsItem> getListWithFilter(String filter, int published) {
        return autoCarsItemRepository.findByFilter(filter, published);
    }

    public List<ItemResponseDto> toResponseDtoList (List<AutoCarsItem> autoCarsItemList) {
        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        autoCarsItemList.forEach(autoCarsItem -> itemResponseDtos.add(toResponseDto(autoCarsItem)));
        return itemResponseDtos;
    }

    public ItemResponseDto toResponseDto (AutoCarsItem autoCarsItem) {
        ItemResponseDto itemResponseDto = new ItemResponseDto(autoCarsItem);
        List<AutoCarsCategoryItem> autoCarsCategoryItemList = autoCarsCategoryItemService.getAutoCarsItemListByItem(autoCarsItem);
        List<AutoCarsCategory> autoCarsCategoryList = new ArrayList<>();
        autoCarsCategoryItemList.forEach(autoCarsCategoryItem -> autoCarsCategoryList.add(autoCarsCategoryItem.getAutoCarsCategory()));
        itemResponseDto.setCarsCategories(toResponseCategoryDto(autoCarsCategoryList));
        return itemResponseDto;
    }
    public List<Object> toResponseCategoryDto (List<AutoCarsCategory> autoCarsCategories) {
        List<Object> responseCategoryWithoutItem = new ArrayList<>();
        autoCarsCategories.forEach(autoCarsCategory -> {
            responseCategoryWithoutItem.add(new CategoryResponseDto(autoCarsCategory));
        });
        return responseCategoryWithoutItem;

    }

    public void delete(AutoCarsItem autoCarsItem) {
        autoCarsItem.setState(State.DELETE.getId());
        autoCarsItem.setModified(DateUtils.getCurrentTimeSecond());
        autoCarsItemRepository.save(autoCarsItem);
        autoCarsCategoryItemService.delete(autoCarsItem, null);
    }
}
