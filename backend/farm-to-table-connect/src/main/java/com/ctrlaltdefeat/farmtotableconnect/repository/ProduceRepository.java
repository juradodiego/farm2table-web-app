package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;
@Repository
public interface ProduceRepository extends JpaRepository<Produce, Integer>{
    
}
