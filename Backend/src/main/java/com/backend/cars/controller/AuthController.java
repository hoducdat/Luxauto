package com.backend.cars.controller;

import com.backend.cars.dto.request.auth.AuthRequestDto;
import com.backend.cars.dto.response.auth.AuthResponseDto;
import com.backend.cars.dto.response.ResponseDto;
import com.backend.cars.service.AutoCarsUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController extends GenController{

    private final AutoCarsUserService autoCarsUserService;

    public AuthController(AutoCarsUserService autoCarsUserService) {
        this.autoCarsUserService = autoCarsUserService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseDto> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        AuthResponseDto authResponseDto = autoCarsUserService.getRootUser(authRequestDto);
        if (authResponseDto == null) {
            return responseUtil.getBadRequestResponse("Login fail, check user_name/password");
        } else {
            return responseUtil.getSuccessResponse(authResponseDto);
        }
    }

}
