package com.ctrlaltdefeat.farmtotableconnect.service;

import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface QueryService {
    
    List<Farm> queryByProduce(Integer produceId);
    List<Farm> queryByLocation(Integer zipcode, Double radius);

    /**
     * 
     * @param produce a single item the customer is searching for
     * @param zipcode in the USA
     * @param radius in miles
     * @return a list of farms that have the desired produce in the radius of the zipcode
     */
    List<Farm> queryByProduceAndLocation(Produce produce, Integer zipcode, Double radius);
    
}
