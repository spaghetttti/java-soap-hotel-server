package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.CheckRoomAvailabilityRequest;
import io.spring.guides.gs_producing_web_service.CheckRoomAvailabilityResponse;
import io.spring.guides.gs_producing_web_service.MakeReservationRequest;
import io.spring.guides.gs_producing_web_service.MakeReservationResponse;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Endpoint
public class HotelEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private HotelRepository hotelRepository;

	@Autowired
	public HotelEndpoint(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkRoomAvailabilityRequest")
	@ResponsePayload
	public CheckRoomAvailabilityResponse displayHotel(@RequestPayload CheckRoomAvailabilityRequest request) throws ParseException {
		CheckRoomAvailabilityResponse response = new CheckRoomAvailabilityResponse();
		Date startDate = request.getStartDate().toGregorianCalendar().getTime();
		Date endDate = request.getEndDate().toGregorianCalendar().getTime();
		int numberOfPeople = request.getNumberOfPeople();
		if (!AgencyDiscountManager.isValidAgency(request.getAgencyId(), request.getAgencyPassword())) {
			response.getAvailableRooms().add("Agency credentials that you provided are invalid");
			return response;
		}
		List<Room> availableRoomsWithDiscount = AgencyDiscountManager.applyDiscount(hotelRepository.displayHotel("Hotel A").findAvailableRooms(startDate, endDate, numberOfPeople), request.getAgencyId(), request.getAgencyPassword());
		List<Room> allRoomsWithDiscount = AgencyDiscountManager.applyDiscount(hotelRepository.displayHotel("Hotel A").getRooms(), request.getAgencyId(), request.getAgencyPassword());
		response.getAvailableRooms().add("Available rooms  response: \n"  + "Rooms that are available between " + startDate.toString() + " and " + endDate.toString() + "\n" + availableRoomsWithDiscount.toString() + "\nAnd these are ALL rooms\n" + allRoomsWithDiscount.toString() + "\n");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "makeReservationRequest")
	@ResponsePayload
	public MakeReservationResponse makeReservation(@RequestPayload MakeReservationRequest request) throws ParseException {
		MakeReservationResponse response = new MakeReservationResponse();
		if (!AgencyDiscountManager.isValidAgency(request.getAgencyId(), request.getAgencyPassword())) {
			response.getReservationResponse().add("Agency credentials that you provided are invalid");
			return response;
		}
		Date startDate = request.getStartDate().toGregorianCalendar().getTime();
		Date endDate = request.getEndDate().toGregorianCalendar().getTime();
		response.getReservationResponse().add("Reservation response: \n" + hotelRepository.displayHotel(request.getHotelName()).reserveRoom(request.getRoomNumber(), startDate, endDate,request.getFirstName(), request.getLastName(),request.getCreditCardNumber()) +  "\n" );
		return response;
	}

}
