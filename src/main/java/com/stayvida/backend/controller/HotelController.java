package com.stayvida.backend.controller;

import com.stayvida.backend.dto.HotelSearchRequest;
import com.stayvida.backend.model.Hotel;
import com.stayvida.backend.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping("/search")
    public List<Hotel> searchHotels(@RequestBody HotelSearchRequest request) {
        return hotelRepository.searchHotels(
                request.getLocation(),
                request.getCheckIn(),
                request.getCheckOut(),
                request.getAdults(),
                request.getChildren()
        );
    }
}
