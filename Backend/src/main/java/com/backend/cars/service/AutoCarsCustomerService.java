package com.backend.cars.service;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.customer.CustomerRequestDto;
import com.backend.cars.dto.response.customer.CustomerResponseDto;
import com.backend.cars.model.AutoCarsCustomer;
import com.backend.cars.model.AutoCarsItem;
import com.backend.cars.model.AutoCarsUser;
import com.backend.cars.repository.AutoCarsCustomerRepository;
import com.backend.cars.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoCarsCustomerService {
    private final AutoCarsCustomerRepository autoCarsCustomerRepository;
    private final AutoCarsUserService autoCarsUserService;
    private final AutoCarsItemService autoCarsItemService;

    public AutoCarsCustomerService(AutoCarsCustomerRepository autoCarsCustomerRepository, AutoCarsUserService autoCarsUserService, AutoCarsItemService autoCarsItemService) {
        this.autoCarsCustomerRepository = autoCarsCustomerRepository;
        this.autoCarsUserService = autoCarsUserService;
        this.autoCarsItemService = autoCarsItemService;
    }

    public AutoCarsCustomer createNewCustomer(CustomerRequestDto customerRequestDto, AutoCarsItem autoCarsItem) {
        AutoCarsCustomer newCustomer = new AutoCarsCustomer(customerRequestDto);
        newCustomer.setAutoCarsItem(autoCarsItem);
        newCustomer = autoCarsCustomerRepository.save(newCustomer);
        return newCustomer;
    }

    public AutoCarsCustomer updateCustomer(AutoCarsCustomer autoCarsCustomer) {
        autoCarsCustomer.updateCustomer();
//        autoCarsCustomer.setAutoCarsItem(autoCarsItemService.getAutoCarsItemById(autoCarsCustomer.getAutoCarsItem().getId()));
        autoCarsCustomer = autoCarsCustomerRepository.save(autoCarsCustomer);
        return autoCarsCustomer;
    }

    public List<CustomerResponseDto> toResponseCustomerDtoList(List<AutoCarsCustomer> autoCarsCustomers) {
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        autoCarsCustomers.forEach(autoCarsCustomer -> customerResponseDtoList.add(toResponseCustomerDto(autoCarsCustomer)));
        return customerResponseDtoList;
    }

    public CustomerResponseDto toResponseCustomerDto(AutoCarsCustomer autoCarsCustomer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(autoCarsCustomer);
        customerResponseDto.setItemResponseDto(autoCarsItemService.toResponseDto(autoCarsCustomer.getAutoCarsItem()));
        return customerResponseDto;
    }

    public List<AutoCarsCustomer> getListCustomer (int state) {
        return autoCarsCustomerRepository.findByStateOrderByCreatedAsc(state);
    }

    public AutoCarsCustomer getById(int id) {
        return autoCarsCustomerRepository.findById(id);
    }

    public void deleteCustomer(AutoCarsCustomer autoCarsCustomer) {
        autoCarsCustomer.setState(State.DELETE.getId());
        autoCarsCustomer.setModified(DateUtils.getCurrentTimeSecond());
        autoCarsCustomerRepository.save(autoCarsCustomer);
    }

    public boolean isRootUser (String secretKey) {
        if (secretKey == null) {
            return false;
        }
        AutoCarsUser user = autoCarsUserService.getUserBySecretKey(secretKey);
        return user != null;
    }
}
