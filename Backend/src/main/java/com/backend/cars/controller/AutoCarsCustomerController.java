package com.backend.cars.controller;

import com.backend.cars.dto.request.customer.CustomerRequestDto;
import com.backend.cars.dto.response.ResponseDto;
import com.backend.cars.model.AutoCarsCustomer;
import com.backend.cars.model.AutoCarsItem;
import com.backend.cars.model.AutoCarsUser;
import com.backend.cars.service.AutoCarsCustomerService;
import com.backend.cars.service.AutoCarsItemService;
import com.backend.cars.service.AutoCarsUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class AutoCarsCustomerController extends GenController {
    private final AutoCarsCustomerService autoCarsCustomerService;
    private final AutoCarsItemService autoCarsItemService;
    private final AutoCarsUserService autoCarsUserService;

    public AutoCarsCustomerController(AutoCarsCustomerService autoCarsCustomerService, AutoCarsItemService autoCarsItemService, AutoCarsUserService autoCarsUserService) {
        this.autoCarsCustomerService = autoCarsCustomerService;
        this.autoCarsItemService = autoCarsItemService;
        this.autoCarsUserService = autoCarsUserService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> createNewCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        try {

            AutoCarsItem autoCarsItem = autoCarsItemService.getAutoCarsItemById(customerRequestDto.getAutoCarsItemId());

            if (autoCarsItem == null) {
                return responseUtil.getBadRequestResponse("not found car");
            }
            AutoCarsCustomer autoCarsCustomer = autoCarsCustomerService.createNewCustomer(customerRequestDto, autoCarsItem);
            return responseUtil.getSuccessResponse(autoCarsCustomerService.toResponseCustomerDto(autoCarsCustomer));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCustomer(@PathVariable("id") int id, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCustomer autoCarsCustomer = autoCarsCustomerService.getById(id);

            if (autoCarsCustomer == null) {
                return responseUtil.getBadRequestResponse("not found customer");
            }
            autoCarsCustomer = autoCarsCustomerService.updateCustomer(autoCarsCustomer);
            return responseUtil.getSuccessResponse(autoCarsCustomerService.toResponseCustomerDto(autoCarsCustomer));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCustomerById(@PathVariable("id") int id, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCustomer autoCarsCustomer = autoCarsCustomerService.getById(id);

            if (autoCarsCustomer == null) {
                return responseUtil.getBadRequestResponse("not found customer");
            }
            return responseUtil.getSuccessResponse(autoCarsCustomerService.toResponseCustomerDto(autoCarsCustomer));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> getAllCustomer(@RequestParam("state") int state, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            List<AutoCarsCustomer> autoCarsCustomers = autoCarsCustomerService.getListCustomer(state);
            return responseUtil.getSuccessResponse(autoCarsCustomerService.toResponseCustomerDtoList(autoCarsCustomers));
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCustomer(@PathVariable("id") int id, @RequestParam("secret_key") String secretKey) {
        try {
            boolean isRootUser = autoCarsCustomerService.isRootUser(secretKey);
            if (!isRootUser) {
                return responseUtil.getUnauthorizedResponse();
            }
            AutoCarsCustomer autoCarsCustomer = autoCarsCustomerService.getById(id);
            if (autoCarsCustomer == null) {
                return responseUtil.getBadRequestResponse("not found customer");
            }
            autoCarsCustomerService.deleteCustomer(autoCarsCustomer);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return responseUtil.getInternalServerErrorResponse();
        }
    }

}
