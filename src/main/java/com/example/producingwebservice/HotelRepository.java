package com.example.producingwebservice;

import jakarta.annotation.PostConstruct;

import java.text.ParseException;
import java.util.ArrayList;

//import io.spring.guides.gs_producing_web_service.Country;
//import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class HotelRepository {
	private Hotel hotel;
	ArrayList<User> listOfUsers = new ArrayList<>();


	DateParser dateParser = new DateParser("yyyy-MM-dd");

	@PostConstruct
	public void initData() throws ParseException {
		User user1 = new User("John", "Doe", "1234-5678-9012-3456");
		User user2 = new User("Alice", "Smith", "5678-1234-9012-3456");
		User user3 = new User("Bob", "Johnson", "9012-3456-1234-5678");
		System.out.println(listOfUsers);
		listOfUsers.add(user1);
		listOfUsers.add(user2);
		listOfUsers.add(user3);
		System.out.println(listOfUsers);
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

	public Hotel displayHotel(String name) {
		Assert.notNull(name, "The hotel's name must not be null");
		return hotel;
	}
}
