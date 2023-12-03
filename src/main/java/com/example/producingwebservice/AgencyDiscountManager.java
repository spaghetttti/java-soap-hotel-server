package com.example.producingwebservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AgencyDiscountManager {

    private static final Map<String, String> AGENCY_CREDENTIALS = Map.of(
            "agency1", "password1",
            "agency2", "password2",
            "agency3", "password3"
    );
    private static final Map<String, Double> AGENCY_DISCOUNTS = Map.of(
            "agency1", 0.10,
            "agency2", 0.15,
            "agency3", 0.05

    );

    public static List<Room> applyDiscount(List<Room> rooms, String agencyId, String agencyPassword) {
        if (isValidAgency(agencyId, agencyPassword)) {
            double discount = AGENCY_DISCOUNTS.getOrDefault(agencyId, 0.0);
            applyDiscountToRooms(rooms, discount);
        }
        return rooms;
    }

    public static boolean isValidAgency(String agencyId, String agencyPassword) {
        return AGENCY_CREDENTIALS.containsKey(agencyId) && AGENCY_CREDENTIALS.get(agencyId).equals(agencyPassword);
    }

    private static void applyDiscountToRooms(List<Room> rooms, double discount) {
        for (Room room : rooms) {
            double discountedPrice = room.getPricePerNight() * (1 - discount);
            room.setPricePerNight(Math.floor(discountedPrice));
        }
    }
}

