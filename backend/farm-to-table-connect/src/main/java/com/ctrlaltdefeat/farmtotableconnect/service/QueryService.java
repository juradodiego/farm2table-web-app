package com.ctrlaltdefeat.farmtotableconnect.service;

import java.util.List;

import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;

public interface QueryService {
    
    List<Farm> queryByProduce(List<Produce> produce);
    List<Farm> queryByLocation(Integer zipcode);
    List<Farm> queryByProduceAndLocation(List<Produce> produce, Integer zipcode);
    
}
