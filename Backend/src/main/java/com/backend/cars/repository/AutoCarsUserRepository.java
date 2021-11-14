package com.backend.cars.repository;

import com.backend.cars.model.AutoCarsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoCarsUserRepository extends JpaRepository<AutoCarsUser, Integer> {
    AutoCarsUser findByUsernameAndState(String userName, int state);
    AutoCarsUser findBySecretKeyAndState(String key, int state);
}
