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
    private List<Reservation> reservations;

    private String imageUrl ;

    public Room(int roomNumber, String roomType, double pricePerNight, int numberOfBeds, int numberOfPeople, String imageUrl) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.numberOfBeds = numberOfBeds;
        this.numberOfPeople = numberOfPeople;
        this.reservations = new ArrayList<>();
        this.imageUrl = imageUrl;
    }

    public Room(int roomNumber, String roomType, double pricePerNight, int numberOfBeds, int numberOfPeople, User client, Date startDate, Date endDate, String imageUrl) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.numberOfBeds = numberOfBeds;
        this.numberOfPeople = numberOfPeople;
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

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }


    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

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
                return false;
            }
        }
        return true;
    }

    public String reserveRoom(Date startDate, Date endDate, User client) {

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

