
package com.ctrlaltdefeat.farmtotableconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface FarmRepository extends JpaRepository<Farm, Integer>{

    @Query()
    List<Farm> queryByProduce(List<Produce> produce);

    @Query()
    List<Farm> queryByLocation(Integer zipcode);
    
    @Query()
    List<Farm> queryByProduceAndLocation(List<Produce> produce, Integer zipcode);

    
}