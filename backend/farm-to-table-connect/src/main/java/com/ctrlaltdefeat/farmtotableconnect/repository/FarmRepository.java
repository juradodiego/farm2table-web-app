
package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface FarmRepository extends JpaRepository<Farm, Integer>{

    @Query()
    Optional<List<Farm>> queryByProduce(List<Produce> produce);

    @Query()
    Optional<List<Farm>> queryByLocation(Integer zipcode);

    @Query()
    Optional<List<Farm>> queryByProduceAndLocation(List<Produce> produce, Integer zipcode);

    
}