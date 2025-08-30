    package com.stayvida.backend.repository;

    import com.stayvida.backend.model.Hotel;
    import org.springframework.data.jdbc.repository.query.Query;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;
    import java.util.List;

    @Repository
public interface FeaturedListRepository extends CrudRepository<Hotel, Integer> {

    @Query(value = "SELECT TOP (3) * FROM hotels ORDER BY \"rating\" DESC")
    List<Hotel> findTop3ByRating();
}
