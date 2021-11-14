package com.backend.cars.service;

import com.backend.cars.constant.State;
import com.backend.cars.dto.request.auth.AuthRequestDto;
import com.backend.cars.dto.response.auth.AuthResponseDto;
import com.backend.cars.model.AutoCarsUser;
import com.backend.cars.repository.AutoCarsUserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AutoCarsUserService {
    private final AutoCarsUserRepository autoCarsUserRepository;

    public AutoCarsUserService(AutoCarsUserRepository autoCarsUserRepository) {
        this.autoCarsUserRepository = autoCarsUserRepository;
    }

    public AuthResponseDto getRootUser(AuthRequestDto authRequestDto) {
        AuthResponseDto authResponseDto = null;
        AutoCarsUser autoCarsUser = autoCarsUserRepository.findByUsernameAndState(authRequestDto.getUserName(), State.ACTIVE.getId());
        if (autoCarsUser != null && BCrypt.checkpw(authRequestDto.getPassword(), autoCarsUser.getPassword())) {
            authResponseDto = new AuthResponseDto(autoCarsUser);
        }
        return authResponseDto;
    }

    public AutoCarsUser getUserBySecretKey(String key) {
        return autoCarsUserRepository.findBySecretKeyAndState(key, State.ACTIVE.getId());
    }
}
