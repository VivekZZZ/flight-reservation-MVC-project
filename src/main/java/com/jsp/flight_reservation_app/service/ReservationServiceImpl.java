package com.jsp.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.flight_reservation_app.dto.ReservationRequest;
import com.jsp.flight_reservation_app.entity.Flight;
import com.jsp.flight_reservation_app.entity.Passenger;
import com.jsp.flight_reservation_app.entity.Reservation;
import com.jsp.flight_reservation_app.entity.User;
import com.jsp.flight_reservation_app.repository.FlightRepository;
import com.jsp.flight_reservation_app.repository.PassengerRepository;
import com.jsp.flight_reservation_app.repository.ReservationRepository;
import com.jsp.flight_reservation_app.util.EmailUtil;
import com.jsp.flight_reservation_app.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());

		passengerRepo.save(passenger);
		long flightId = request.getFlightId();

		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);

		reservationRepo.save(reservation);

		String filePath = "C:\\Users\\vivek\\Desktop\\SPRING-PROJECT\\flight_reservation_app\\tickets\\reservations"
				+ reservation.getId() + ".pdf";

		pdfGenerator.generatePdf(reservation, filePath);
		
		String attachement = "reservations" + reservation.getId() + ".pdf";
		
		emailUtil.sendTicketsEmail(passenger.getEmail(), "Flight Ticket Booking details",
				"Thanks for Booking the tickets \\n Happy Journey !!!  ",attachement, filePath);
		System.out.println("Email sent successfully");
		return reservation;
	}

}
