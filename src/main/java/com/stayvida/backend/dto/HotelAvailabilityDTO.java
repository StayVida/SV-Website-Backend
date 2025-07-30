package com.stayvida.backend.dto;

public class HotelAvailabilityDTO {
    private int id;
    private String hotel;
    private String location;
    private int price;
    private boolean availability;

    public HotelAvailabilityDTO(int id, String hotel, String location, int price, boolean availability) {
        this.id = id;
        this.hotel = hotel;
        this.location = location;
        this.price = price;
        this.availability = availability;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getHotel() { return hotel; }
    public String getLocation() { return location; }
    public int getPrice() { return price; }
    public boolean isAvailability() { return availability; }
}
