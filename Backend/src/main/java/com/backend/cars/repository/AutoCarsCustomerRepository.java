package com.backend.cars.repository;

import com.backend.cars.model.AutoCarsCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoCarsCustomerRepository  extends JpaRepository<AutoCarsCustomer, Integer> {
    @Query(value = "SELECT scc FROM AutoCarsCustomer scc " +
            "LEFT JOIN scc.autoCarsItem sci " +
            " WHERE scc.state = :state " )
    List<AutoCarsCustomer> findByStateOrderByCreatedAsc(int state);

    @Query(value = "SELECT scc FROM AutoCarsCustomer scc " +
            "LEFT JOIN scc.autoCarsItem sci " +
            " WHERE scc.id = :id " )
    AutoCarsCustomer findById(int id);
}
