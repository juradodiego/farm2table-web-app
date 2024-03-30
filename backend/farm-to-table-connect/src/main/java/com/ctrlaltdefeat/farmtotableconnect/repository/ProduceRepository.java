package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface ProduceRepository extends JpaRepository<Produce, Integer>{
    
    // @Query()
    // Optional<List<Produce>> getProduce();

    // @Query()
    // Optional<Map<Integer, Integer>> getSelling();

}
