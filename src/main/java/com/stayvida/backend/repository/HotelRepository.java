package com.stayvida.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;
import com.stayvida.backend.model.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HotelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Search hotels by location and check availability
    public List<Hotel> searchHotels(String destination, String checkIn, String checkOut, int adultCapacity, int childrenCapacity) {
        String sql = "SELECT * FROM hotels WHERE location = ?";

        List<Hotel> hotels = jdbcTemplate.query(
    sql,
        new RowMapper<Hotel>() {
            @Override
            public Hotel mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setHotel(rs.getString("hotel"));
                hotel.setLocation(rs.getString("location"));
                hotel.setPrice(rs.getInt("price"));
                hotel.setAdult(rs.getInt("max_adults"));
                hotel.setchildren(rs.getInt("max_children"));
                hotel.setImage(rs.getBytes("image")); // 👈 Set image blob 
                hotel.setRating(rs.getDouble("rating")); // Set rating

                return hotel;
            }
        },
        destination // <-- this is passed as a vararg (instead of Object[])
);

        // Check availability for each hotel
        for (Hotel hotel : hotels) {
            boolean isAvailable = isHotelAvailable(hotel.getId(), checkIn, checkOut);
            hotel.setAvailability(isAvailable);
        }

        return hotels;
    }

    // Check if the hotel is available for the given dates
    public boolean isHotelAvailable(int hotelId, String checkIn, String checkOut) {
        String sql = "SELECT COUNT(*) FROM bookings " +
                     "WHERE hotel_id = ? AND (check_in_date < ? AND check_out_date > ?)";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, hotelId, checkOut, checkIn);

        return count == null || count == 0; // Available if no overlapping bookings
    }
}
