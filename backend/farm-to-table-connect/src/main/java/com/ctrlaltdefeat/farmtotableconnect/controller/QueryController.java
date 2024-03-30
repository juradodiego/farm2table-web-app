package com.ctrlaltdefeat.farmtotableconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.Produce;
import com.ctrlaltdefeat.farmtotableconnect.service.QueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService queryService;

     @GetMapping("/produce")
    public List<Farm> queryByProduce(List<Produce> produce) throws Exception {
        try {
            List<Farm> farms = queryService.queryByProduce(produce);
            // TODO: Make custom exception
            if (farms == null) 
                throw new Exception("No farms");
            return farms;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }

    @GetMapping("/location")
    public List<Farm> queryByLocation(Integer zipcode) throws Exception {
        try {
            List<Farm> farms = queryService.queryByLocation(zipcode);
            // TODO: Make custom exception
            if (farms == null) 
                throw new Exception("No farms");
            return farms;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }

    @GetMapping("/locationAndProduce")
    public List<Farm> queryByProduceAndLocation(List<Produce> produce, Integer zipcode) throws Exception {
        try {
            List<Farm> farms = queryService.queryByProduceAndLocation(produce, zipcode);
            // TODO: Make custom exception
            if (farms == null) 
                throw new Exception("No farms");
            return farms;
        } catch (Exception e) {
            System.out.println("e");
        }
        return null;
    }
}
