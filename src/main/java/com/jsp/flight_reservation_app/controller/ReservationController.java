package com.jsp.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.flight_reservation_app.dto.ReservationRequest;
import com.jsp.flight_reservation_app.entity.Reservation;
import com.jsp.flight_reservation_app.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());

		return "confirmReservation";
	}

}
