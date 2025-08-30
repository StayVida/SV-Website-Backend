package com.stayvida.backend.controller;

import com.stayvida.backend.model.Hotel;
import com.stayvida.backend.repository.FeaturedListRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FeatureListController {

    private final FeaturedListRepository featuredListRepository;

    public FeatureListController(FeaturedListRepository featuredListRepository) {
        this.featuredListRepository = featuredListRepository;
    }

    @GetMapping("api/featurelist")
    public List<Hotel> getTopHotels() {
        return featuredListRepository.findTop3ByRating();
    }
}
