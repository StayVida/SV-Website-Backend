package com.stayvida.backend.model;

public class Hotel {
    private int id;
    private String hotel;
    private String location;
    private int price;
    private boolean availability; // <- add this
    private byte[] image; // 👈 Store raw image as byte array

    // Getters and Setters
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

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }
}