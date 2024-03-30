package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface ProduceRepository extends JpaRepository<Produce, Integer>{
    
    @Query()
    List<Produce> getProduce();

    @Query()
    Map<Integer, Integer> getSelling();

}
