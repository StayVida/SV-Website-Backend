package com.stayvida.backend.dto;

public class HotelAvailabilityDTO {
    private int id;
    private String hotel;
    private String location;
    private int price;
    private boolean availability;
    private int adult;
    private int children;


    public HotelAvailabilityDTO(int id, String hotel, String location, int price, boolean availability,int adult, int children) {
        this.id = id;
        this.hotel = hotel;
        this.location = location;
        this.price = price;
        this.availability = availability;
        this.adult=adult;
        this.children=children;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getHotel() { return hotel; }
    public String getLocation() { return location; }
    public int getPrice() { return price; }
    public int getAdults() { return adult; }
    public int getchildren() { return children; }
    public boolean isAvailability() { return availability; }

}
