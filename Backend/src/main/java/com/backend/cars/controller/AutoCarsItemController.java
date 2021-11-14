package com.backend.cars.controller;

import com.backend.cars.dto.request.item.ItemRequestDto;
import com.backend.cars.dto.response.ResponseDto;
import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsItem;
import com.backend.cars.service.AutoCarsCategoryService;
import com.backend.cars.service.AutoCarsCustomerService;
import com.backend.cars.service.AutoCarsItemService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class AutoCarsItemController extends GenController {
    private final AutoCarsCustomerService autoCarsCustomerService;
    private final AutoCarsItemService autoCarsItemService;
    private final AutoCarsCategoryService autoCarsCategoryService;

    public AutoCarsItemController(AutoCarsCustomerService autoCarsCustomerService, AutoCarsItemService autoCarsItemService, AutoCarsCategoryService autoCarsCategoryService) {
        this.autoCarsCustomerService = autoCarsCustomerService;
        this.autoCarsItemService = autoCarsItemService;
        this.autoCarsCategoryService = autoCarsCategoryService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> createCar(@Valid @RequestBody ItemRequestDto itemRequestDto, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCategory autoCarsCategory = autoCarsCategoryService.getById(itemRequestDto.getCategoryId());
            if (autoCarsCategory == null) {
                return responseUtil.getNotFoundResponse("not found category");
            }
            AutoCarsItem autoCarsItem = autoCarsItemService.createAutoCarsItem(itemRequestDto, autoCarsCategory);
            return responseUtil.getSuccessResponse(autoCarsItemService.toResponseDto(autoCarsItem));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCar(@PathVariable("id") int id, @Valid @RequestBody ItemRequestDto itemRequestDto, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsItem autoCarsItem = autoCarsItemService.getAutoCarsItemById(id);
            if (autoCarsItem == null) {
                return responseUtil.getNotFoundResponse("car");
            }
            autoCarsItem = autoCarsItemService.update(itemRequestDto, autoCarsItem);
            return responseUtil.getSuccessResponse(autoCarsItemService.toResponseDto(autoCarsItem));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCarElement(@PathVariable("id") int id) {
        try {
            AutoCarsItem autoCarsItem = autoCarsItemService.getAutoCarsItemById(id);
            if (autoCarsItem == null) {
                return responseUtil.getNotFoundResponse("car");
            }
            return responseUtil.getSuccessResponse(autoCarsItemService.toResponseDto(autoCarsItem));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> getCars(@RequestParam(name = "filter", required = false) String filter,
                                               @RequestParam(name = "published", required = false) Integer published) {
        try {
            if (published == null) {
                published = 1;
            }
            List<AutoCarsItem> autoCarsItemList = new ArrayList<>();
            if (filter == null) {
                autoCarsItemList = autoCarsItemService.getList(published);
            } else {
                autoCarsItemList = autoCarsItemService.getListWithFilter(filter, published);
            }
            return responseUtil.getSuccessResponse(autoCarsItemService.toResponseDtoList(autoCarsItemList));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCar(@PathVariable("id") int id, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsItem autoCarsItem = autoCarsItemService.getAutoCarsItemById(id);
            if (autoCarsItem == null) {
                return responseUtil.getNotFoundResponse("not found car");
            }
            autoCarsItemService.delete(autoCarsItem);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }
}
