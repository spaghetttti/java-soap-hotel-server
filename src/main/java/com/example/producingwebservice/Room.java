package com.example.producingwebservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private int numberOfBeds;
    private  int numberOfPeople;
//    private boolean isAvailable;
    private List<Reservation> reservations;

    private String imageUrl ;
//    private User client;

    public Room(int roomNumber, String roomType, double pricePerNight, int numberOfBeds, int numberOfPeople, String imageUrl) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
//        this.isAvailable = true;
        this.numberOfBeds = numberOfBeds;
        this.numberOfPeople = numberOfPeople;
//        this.client = null;
        this.reservations = new ArrayList<>();
        this.imageUrl = imageUrl;
    }

    public Room(int roomNumber, String roomType, double pricePerNight, int numberOfBeds, int numberOfPeople, User client, Date startDate, Date endDate, String imageUrl) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
//        this.isAvailable = false;
        this.numberOfBeds = numberOfBeds;
        this.numberOfPeople = numberOfPeople;
//        this.client = client;
        reservations = new ArrayList<>();
        reservations.add(new Reservation(startDate, endDate, client));
        this.imageUrl = imageUrl;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

//    public boolean isAvailable() {
//        return isAvailable;
//    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

//    public void bookRoom() {
//        isAvailable = false;
//    }
//
//    public void releaseRoom() {
//        isAvailable = true;
//    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

//    public User getClient() {
//        return client;
//    }
//
//    public void setClient(User client) {
//        this.client = client;
//    }


//    public String CheckForClient() {
//        if (this.getClient() == null) {
//            return "No client";
//        } else {
//            return this.getClient().toString();
//        }
//    }


//    public void setAvailable(boolean available) {
//        isAvailable = available;
//    }


    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getReservations() {
        if (reservations.isEmpty()) return "no reservations for this room";
        return reservations.toString();
    }

    public boolean isAvailable(Date startDate, Date endDate) {
        if (reservations == null) return true;
        for (Reservation reservation : reservations) {
            if (reservation.overlaps(startDate, endDate)) {
                return false; // Room is already booked for this period
            }
        }
        return true; // Room is available for the given dates
    }

    public String reserveRoom(Date startDate, Date endDate, User client) {
//        if (!this.isAvailable(startDate, endDate)) {
//            return "nope, room can't be reserved for these dates it's already reserved for another client :(";
//        }
        Reservation reservation = new Reservation(startDate,endDate, client);
        this.reservations.add(reservation);
        return "Congratulations, room # " + this.roomNumber + " is reserved for you from " + startDate.toString() + " to " + endDate.toString() + "\nYour reservation ID: " + reservation.getReservation_id();
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", numberOfBeds=" + numberOfBeds +
                ", numberOfPeople= " + numberOfPeople +
                ", reservations= " + getReservations() +
                ", image url= " + imageUrl +
                "}\n";
    }
}

