package com.example.producingwebservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

class Hotel {
    private String name;
    private String address;

    private int stars;

    ArrayList<Room> rooms;

    public Hotel(String name, String address, int stars,  ArrayList<Room> rooms) {
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.rooms = rooms;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> findAvailableRooms(Date startDate, Date endDate, int numberOfPeople) {
        List<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isAvailable(startDate, endDate) && room.getNumberOfPeople() >= numberOfPeople) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }
    public String reserveRoom(int roomNumber, Date startDate, Date endDate, String firstName, String lastName, String creditCardNumber) {
        boolean roomFound = false;

        for (Room room : this.getRooms()) {
            if (room.getRoomNumber() == roomNumber) {
                roomFound = true;

                if (room.isAvailable(startDate, endDate)) {
//                    room.bookRoom();

                    User client = new User(firstName, lastName, creditCardNumber);
//                    room.setClient(client);
                    return(room.reserveRoom(startDate, endDate, client));
                } else {
                    return("Sorry, but the room " + roomNumber + " in " +  this.name + " is already reserved.");
                }
            }
        }

        if (!roomFound) {
            return("No room with the number " + roomNumber + " found in " + this.name + ".");
        }
        return "Unexpected error when trying to reserve room: " + roomNumber;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stars=" + stars +
                ", rooms=" + rooms.toString() +
                "}\n";
    }
}