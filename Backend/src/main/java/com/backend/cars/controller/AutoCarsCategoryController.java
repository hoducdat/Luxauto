package com.backend.cars.controller;

import com.backend.cars.dto.request.category.CategoryRequestDto;
import com.backend.cars.dto.request.customer.CustomerRequestDto;
import com.backend.cars.dto.response.ResponseDto;
import com.backend.cars.model.AutoCarsCategory;
import com.backend.cars.model.AutoCarsCustomer;
import com.backend.cars.service.AutoCarsCategoryService;
import com.backend.cars.service.AutoCarsCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class AutoCarsCategoryController extends GenController {
    private final AutoCarsCustomerService autoCarsCustomerService;
    private final AutoCarsCategoryService autoCarsCategoryService;

    public AutoCarsCategoryController(AutoCarsCustomerService autoCarsCustomerService, AutoCarsCategoryService autoCarsCategoryService) {
        this.autoCarsCustomerService = autoCarsCustomerService;
        this.autoCarsCategoryService = autoCarsCategoryService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> createNewCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCategory autoCarsCategory = autoCarsCategoryService.createNewAutoCarsCategory(categoryRequestDto);
            return responseUtil.getSuccessResponse(autoCarsCategoryService.toResponseCategoryDto(autoCarsCategory));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCategory(@PathVariable("id") int id, @RequestParam("secret_key") String secretKey, @Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCategory autoCarsCategory = autoCarsCategoryService.getById(id);

            if (autoCarsCategory == null) {
                return responseUtil.getBadRequestResponse("not found category");
            }
            autoCarsCategory = autoCarsCategoryService.update(categoryRequestDto, autoCarsCategory);
            return responseUtil.getSuccessResponse(autoCarsCategoryService.toResponseCategoryDto(autoCarsCategory));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCategoryById(@PathVariable("id") int id) {
        try {

            AutoCarsCategory autoCarsCategory = autoCarsCategoryService.getById(id);

            if (autoCarsCategory == null) {
                return responseUtil.getBadRequestResponse("not found category");
            }
            return responseUtil.getSuccessResponse(autoCarsCategoryService.toResponseCategoryDto(autoCarsCategory));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> getAllCategory() {
        try {

            List<AutoCarsCategory> autoCarsCategoryList = autoCarsCategoryService.getList();
            return responseUtil.getSuccessResponse(autoCarsCategoryService.toResponseCategoryDtoList(autoCarsCategoryList));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCategory(@PathVariable("id") int id, @RequestParam("secret_key") String secretKey) {
        try {
            if (secretKey == null) {
                return responseUtil.getBadRequestResponse("secret_key is required");
            }
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCategory autoCarsCategory = autoCarsCategoryService.getById(id);
            if (autoCarsCategory == null) {
                return responseUtil.getBadRequestResponse("not found category");
            }
            autoCarsCategoryService.delete(autoCarsCategory);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

}
