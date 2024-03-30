package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrlaltdefeat.farmtotableconnect.model.Address;
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

    private static final double EARTH_RADIUS = 6371.0;

    @Override
    public List<Farm> queryByProduce(Integer produceId) {
        return farmRepository.findAll().stream().filter(f -> f.getSelling().contains(produceId)).toList();

    }

    @Override
    public List<Farm> queryByLocation(Integer zipcode, Double radius) {
        String addressString = zipcode.toString();
        String apiKey = "AIzaSyDIjS7dqMBpTshDwI_SbI1l5aTkvP7mkiA"; 

        try {
            // Create a URL for the Geocoding API request
            String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(addressString, "UTF-8") + "&key=" + apiKey;

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response
            // Here you would typically use a JSON library like Jackson or Gson for more robust parsing
            // For simplicity, we'll just use string manipulation here
            String jsonResponse = response.toString();
            int latIndex = jsonResponse.indexOf("\"lat\"") + 6;
            int lngIndex = jsonResponse.indexOf("\"lng\"") + 6;
            String latitude = jsonResponse.substring(latIndex, jsonResponse.indexOf(",", latIndex));
            String longitude = jsonResponse.substring(lngIndex, jsonResponse.indexOf("}", lngIndex));
            
            Double lat = Double.parseDouble(latitude);
            Double lon = Double.parseDouble(longitude);

            // Close connection
            connection.disconnect();
            
            return farmRepository.findAll().stream().filter(f -> validFarm(f, lat, lon)).toList();


        } catch (IOException e) {
            e.printStackTrace();
        }
        farmRepository.findAll().stream().filter(null)

    }

    @Override
    public List<Farm> queryByProduceAndLocation(List<Produce> produce, Integer zipcode, Double radius) {
        return queryByLocation(zipcode, radius).stream().filter(f -> f.getSelling().contains(produce)).toList();
    }

    private Boolean validFarm(Farm farm, Double lat, Double lon, Double radius){
        Double lat1 = farm.getLatitude();
        Double lon1 = farm.getLongitude();
        Double lat2 = lat;
        Double lon2 = lon;


        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);
        
        // Calculate differences between latitudes and longitudes
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        
        // Calculate the Haversine of half the differences
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        
        // Calculate the central angle between the two points
        double centralAngle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        // Calculate the distance
        double distance = EARTH_RADIUS * centralAngle * 0.621371;
        
        return distance <= radius;

    }
    
}
