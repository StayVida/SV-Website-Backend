package com.stayvida.backend.controller;

import com.stayvida.backend.dto.HotelSearchRequest;
import com.stayvida.backend.model.Hotel;
import com.stayvida.backend.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<String, Object> map = new LinkedHashMap<>(); // ✅ Keeps key order

        // ✅ Insert keys in the exact order you want in JSON
        if (hotel.getImage() != null) {
            String base64Image = Base64.getEncoder().encodeToString(hotel.getImage());
            map.put("imageBase64", "data:image/jpeg;base64," + base64Image);
        } else {
            map.put("imageBase64", null);
        }
        map.put("id", hotel.getId());
        map.put("location", hotel.getLocation());
        map.put("hotel", hotel.getHotel());
        map.put("max_adults", hotel.getAdults());
        map.put("max_children", hotel.getchildren());
        map.put("price", hotel.getPrice());
        map.put("availability", hotel.isAvailability());
        map.put("rating", hotel.getRating());

        return map;
    }).collect(Collectors.toList());
}
}
