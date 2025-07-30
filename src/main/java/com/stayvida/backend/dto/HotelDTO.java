// src/main/java/com/stayvida/backend/dto/HotelDTO.java
package com.stayvida.backend.dto;

public class HotelDTO {
    private int id;
    private String hotel;
    private String location;
    private int price;
    private boolean availability;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getHotel() { return hotel; }
    public void setHotel(String hotel) { this.hotel = hotel; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public boolean isAvailability() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }
}
