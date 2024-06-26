package com.ctrlaltdefeat.farmtotableconnect.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ctrlaltdefeat.farmtotableconnect.model.Address;
import com.ctrlaltdefeat.farmtotableconnect.model.Farm;
import com.ctrlaltdefeat.farmtotableconnect.model.User;
import com.ctrlaltdefeat.farmtotableconnect.repository.FarmRepository;
import com.ctrlaltdefeat.farmtotableconnect.repository.UserRepository;
import com.ctrlaltdefeat.farmtotableconnect.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FarmRepository farmRepository;

    @Override
    public User getUserByUsername(String email, String password) {
        List<User> matchingUsers = userRepository.findAll().stream().filter(u -> u.getEmail().equals(email)).toList();
        return !matchingUsers.isEmpty() && matchingUsers.get(0).getPassword().equals(password) ? matchingUsers.get(0) : null;        
    }

    @Override
    public User getUserByUserId(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent() ? user.get() : null; 
    }

    @Override
    public User newUser(User user, Farm farm, Address address) {
        if (user != null) {
            if (farm != null && address != null){
                calculateLatAndLong(farm, address);
                farmRepository.save(farm);
                user.setFarmId(farm.getFarmId());
            }
    
            userRepository.save(user); 
        }

        return user;
        
    }
    
    private void calculateLatAndLong(Farm farm, Address address){
        String addressString = address.getAddressLine() + " " + address.getCity() + " " +  address.getState() + " " + address.getZipcode();
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
            
            farm.setLatitude(Double.parseDouble(latitude));
            farm.setLongitude(Double.parseDouble(longitude));

            // Close connection
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
