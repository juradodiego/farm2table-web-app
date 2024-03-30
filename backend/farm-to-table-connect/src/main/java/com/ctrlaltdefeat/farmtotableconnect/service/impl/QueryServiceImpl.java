package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;
import com.ctrlaltdefeat.farmtotableconnect.repository.ProduceRepository;
import com.ctrlaltdefeat.farmtotableconnect.repository.FarmRepository;
import com.ctrlaltdefeat.farmtotableconnect.service.QueryService;

public class QueryServiceImpl implements QueryService {

    @Autowired
    ProduceRepository produceRepository;

    @Autowired
    FarmRepository farmRepository;

    @Override
    public List<Farm> queryByProduce(List<Produce> produce) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryByProduce'");
    }

    @Override
    public List<Farm> queryByLocation(Integer zipcode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryByLocation'");
    }

    @Override
    public List<Farm> queryByProduceAndLocation(List<Produce> produce, Integer zipcode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryByProduceAndLocation'");
    }
    
}
