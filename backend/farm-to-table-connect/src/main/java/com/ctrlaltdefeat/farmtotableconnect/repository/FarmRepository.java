
package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctrlaltdefeat.farmtotableconnect.model.Farm;

public interface FarmRepository extends JpaRepository<Farm, Integer>{

    
}