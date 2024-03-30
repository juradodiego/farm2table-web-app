
package com.ctrlaltdefeat.farmtotableconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctrlaltdefeat.farmtotableconnect.model.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer>{

    
}
