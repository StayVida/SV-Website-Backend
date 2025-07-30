// src/main/java/com/stayvida/backend/dto/HotelSearchRequest.java
package com.stayvida.backend.dto;

public class HotelSearchRequest {
    private String location;
    private String checkIn;
    private String checkOut;
    private int adults;
    private int children;

    // Getters and setters
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCheckIn() { return checkIn; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }

    public String getCheckOut() { return checkOut; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }

    public int getAdults() { return adults; }
    public void setAdults(int adults) { this.adults = adults; }

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }
}
