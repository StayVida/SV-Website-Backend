package com.stayvida.backend.controller;

import com.stayvida.backend.dto.HotelSearchRequest;
import com.stayvida.backend.model.Hotel;
import com.stayvida.backend.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Base64;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/search")
    public List<Map<String, Object>> searchHotels(@RequestBody HotelSearchRequest request) {
        List<Hotel> hotels = hotelRepository.searchHotels(  // ✅ Declare `hotels` here
                request.getLocation(),
                request.getCheckIn(),
                request.getCheckOut(),
                request.getAdults(),
                request.getChildren()
        );

        // Convert to a JSON-safe list with base64 image string
        return hotels.stream().map(hotel -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", hotel.getId());
            map.put("hotel", hotel.getHotel());
            map.put("location", hotel.getLocation());
            map.put("price", hotel.getPrice());
            map.put("availability", hotel.isAvailability());

            if (hotel.getImage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(hotel.getImage());
                map.put("imageBase64", "data:image/jpeg;base64," + base64Image); // Or image/png
            } else {
                map.put("imageBase64", null);
            }

            return map;
        }).collect(Collectors.toList());
    }
}
