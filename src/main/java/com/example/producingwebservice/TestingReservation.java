package com.example.producingwebservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestingReservation {
    private Hotel hotel;
    private ArrayList<User> listOfUsers;

    DateParser dateParser = new DateParser("yyyy-MM-dd");
    public TestingReservation() throws ParseException {
        listOfUsers = new ArrayList<>();
        addUsers();
        addHotel();
    }


    public void addHotel() throws ParseException {
        ArrayList<Room> listOfRooms = new ArrayList<>();
        listOfRooms.add(new Room(101, "Single", 75.0, 1,2, "https://imageio.forbes.com/specials-images/imageserve/5cdb058a5218470008b0b00f/Nobu-Ryokan-Malibu/0x0.jpg?format=jpg&height=1009&width=2000"));
        listOfRooms.add(new Room(102, "Double", 100.0, 2,3, listOfUsers.get(2), dateParser.parseDate("2023-10-28"), dateParser.parseDate("2023-11-28"), "https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-articleLarge.jpg?quality=75&auto=webp&disable=upscale"));
        listOfRooms.add(new Room(103, "Single", 75.0, 1,2, "https://www.usatoday.com/gcdn/-mm-/05b227ad5b8ad4e9dcb53af4f31d7fbdb7fa901b/c=0-64-2119-1259/local/-/media/USATODAY/USATODAY/2014/08/13/1407953244000-177513283.jpg?width=2119&height=1195&fit=crop&format=pjpg&auto=webp"));
        listOfRooms.add(new Room(201, "Double", 100.0, 2,4, "https://www.europahotelbelfast.com/wp-content/uploads/2021/10/DSC_7769-Edit-1-1366x768-fp_mm-fpoff_0_0.png"));
        listOfRooms.add(new Room(202, "Suite", 150.0, 3,3, "https://sthotelsmalta.com/wp-content/uploads/2022/06/modern-luxury-bedroom-suite-and-bathroom-with-working-table-scaled.jpg"));
        listOfRooms.add(new Room(203, "Single", 75.0, 1,2, "https://www.parkregisbirmingham.co.uk/wp-content/uploads/2021/06/Untitled-design-15-2560x1280.jpg"));
        listOfRooms.add(new Room(301, "Double", 100.0, 2,2, " https://i0.wp.com/theluxurytravelexpert.com/wp-content/uploads/2014/03/trump-hotel-chicago-illinois-usa.jpg"));
        listOfRooms.add(new Room(302, "Suite", 150.0, 2,3, "https://www.bestwesternplusmeridian.com/Content/images/Queen-Room.jpg"));
        listOfRooms.add(new Room(303, "Single", 75.0, 1,2, listOfUsers.get(1), dateParser.parseDate("2023-11-25"), dateParser.parseDate("2023-11-30"), "https://www.theshelbourne.com/resourcefiles/roomssmallimages/heritage-parkview-guestroom.jpg?version=11102023091751"));
        hotel = new Hotel("Hotel A", "123 Main St, Paris, France", 4, new ArrayList<>(listOfRooms));

    }

    public void addUsers() {
        User user1 = new User("John", "Doe", "1234-5678-9012-3456");
        User user2 = new User("Alice", "Smith", "5678-1234-9012-3456");
        User user3 = new User("Bob", "Johnson", "9012-3456-1234-5678");

        listOfUsers.add(user1);
        listOfUsers.add(user2);
        listOfUsers.add(user3);
    }

    public static User findUserByFirstName(List<User> listOfUsers, String firstName) {
        for (User user : listOfUsers) {
            if (user.getFirstName().equals(firstName)) {
                return user;
            }
        }
        return null;
    }


    public String reserveRoom(int roomNumber, Date startDate, Date endDate, String firstName, String lastName, String creditCardNumber) {
        boolean roomFound = false;

        for (Room room : hotel.getRooms()) {
            if (room.getRoomNumber() == roomNumber) {
                roomFound = true;

                if (room.isAvailable(startDate, endDate)) {
//                    room.bookRoom();

                    User client = new User(firstName, lastName, creditCardNumber);
//                    room.setClient(client);
                    return(room.reserveRoom(startDate, endDate, client));
                } else {
                    return("Sorry, but the room " + roomNumber + " in " +  hotel.getName() + " is already reserved.");
                }
            }
        }

        if (!roomFound) {
            return("No room with the number " + roomNumber + " found in " + hotel.getName() + ".");
        }
        return "Unexpected error when trying to reserve room: " + roomNumber;
    }
    public List<Room> checkForAvailableRooms(Date startDate,Date endDate) {
        List<Room> availableRooms = hotel.findAvailableRooms(startDate, endDate, 2);
        return availableRooms;
    }
    public void printAllInfo() {
            System.out.println(hotel.toString());
        for (User element : listOfUsers) {
            System.out.println(element.toString());
        }
    }
}
