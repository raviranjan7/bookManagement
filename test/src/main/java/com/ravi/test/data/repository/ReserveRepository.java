package com.ravi.test.data.repository;

import com.ravi.test.data.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    Reserve findByUserId(String userId);
    List<Reserve> findAll();
    List<Reserve> findAllByUserId(String userId);
    Reserve save(Reserve reserve);
}
