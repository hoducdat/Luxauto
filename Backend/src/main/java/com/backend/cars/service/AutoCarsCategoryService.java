package com.backend.cars.service;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.category.CategoryRequestDto;
import com.backend.cars.dto.response.category.CategoryResponseDto;
import com.backend.cars.dto.response.item.ItemResponseDto;
import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsCategoryItem;
import com.backend.cars.model.AutoCarsItem;
import com.backend.cars.repository.AutoCarsCategoryRepository;
import com.backend.cars.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoCarsCategoryService {
    private final AutoCarsCategoryRepository autoCarsCategoryRepository;
    private final AutoCarsCategoryItemService autoCarsCategoryItemService;

    public AutoCarsCategoryService(AutoCarsCategoryRepository autoCarsCategoryRepository, AutoCarsCategoryItemService autoCarsCategoryItemService) {
        this.autoCarsCategoryRepository = autoCarsCategoryRepository;
        this.autoCarsCategoryItemService = autoCarsCategoryItemService;
    }

    public AutoCarsCategory createNewAutoCarsCategory (CategoryRequestDto categoryRequestDto) {
        AutoCarsCategory autoCarsCategory = new AutoCarsCategory(categoryRequestDto);
        long count = autoCarsCategoryRepository.countByState(State.ACTIVE.getId());
        autoCarsCategory.setSortOrder((int)count + 1);
        autoCarsCategory = autoCarsCategoryRepository.save(autoCarsCategory);
        return autoCarsCategory;
    }

    public AutoCarsCategory update (CategoryRequestDto categoryRequestDto, AutoCarsCategory carsCategory) {
        carsCategory.update(categoryRequestDto);
        carsCategory = autoCarsCategoryRepository.save(carsCategory);
        return carsCategory;
    }

    public AutoCarsCategory getById(int id) {
        return autoCarsCategoryRepository.findByIdAndState(id, State.ACTIVE.getId());
    }

    public List<AutoCarsCategory> getList() {
        return autoCarsCategoryRepository.findByState(State.ACTIVE.getId());
    }

    public void delete (AutoCarsCategory autoCarsCategory) {
        autoCarsCategory.setState(State.DELETE.getId());
        autoCarsCategory.setModified(DateUtils.getCurrentTimeSecond());
        autoCarsCategoryRepository.save(autoCarsCategory);
        autoCarsCategoryItemService.delete(null, autoCarsCategory);
    }

    public List<CategoryResponseDto> toResponseCategoryDtoList(List<AutoCarsCategory> autoCarsCategory) {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        autoCarsCategory.forEach(autoCarsCategory1 -> {
            categoryResponseDtos.add(toResponseCategoryDto(autoCarsCategory1));
        });
        return categoryResponseDtos;
    }

    public CategoryResponseDto toResponseCategoryDto (AutoCarsCategory autoCarsCategory) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto(autoCarsCategory);
        List<AutoCarsCategoryItem> autoCarsCategoryItems = autoCarsCategoryItemService.getAutoCarsItemListByCategory(autoCarsCategory);
        List<Object> autoCarsItemList = new ArrayList<>();
        autoCarsCategoryItems.forEach(autoCarsCategoryItem -> autoCarsItemList.add(toResponseItemDto(autoCarsCategoryItem.getAutoCarsItem())));
        categoryResponseDto.setAutoCarsItemList(autoCarsItemList);
        categoryResponseDto.setNumberCar(autoCarsCategoryItems.size());
        return categoryResponseDto;
    }

    public ItemResponseDto toResponseItemDto (AutoCarsItem autoCarsItem) {
        return new ItemResponseDto(autoCarsItem);
    }
}
