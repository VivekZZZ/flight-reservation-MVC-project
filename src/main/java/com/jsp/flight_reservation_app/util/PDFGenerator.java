package com.jsp.flight_reservation_app.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.jsp.flight_reservation_app.entity.Reservation;

@Component
public class PDFGenerator {

	public void generatePdf(Reservation reservation, String filePath) {
		Document document = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();

			// Create a Font object with a specific font type and size
			Font fontTop = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLDITALIC);

			// Create a Paragraph with the specified font size
			Paragraph paragraph1 = new Paragraph("Flight Reservation Ticket", fontTop);

			paragraph1.setSpacingBefore(10f); // Space before the paragraph
			paragraph1.setSpacingAfter(10f); // Space after the paragraph
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph1);

			// Create a LineSeparator and set its properties
			LineSeparator line = new LineSeparator();
			line.setLineColor(BaseColor.BLACK); // Set the line color
			line.setLineWidth(1); // Set the line width (adjust as needed)

			// Add the horizontal line to the document
			document.add(line);

			// Flight Header
			Font fontHeader = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			Paragraph paragraph2 = new Paragraph("Flight details", fontHeader);

			paragraph2.setSpacingBefore(20f); // Space before the paragraph
			paragraph2.setSpacingAfter(20f); // Space after the paragraph

			PdfPTable table = new PdfPTable(2); // Create a table with 3 columns

			// Add table cells

			table.addCell("Flight Number");
			table.addCell(reservation.getFlight().getFlightName());

			table.addCell("Operating Airlines");
			table.addCell(reservation.getFlight().getOperatingAirlines());

			table.addCell("Departure City");
			table.addCell(reservation.getFlight().getDepartureCity());

			table.addCell("Arrival City");
			table.addCell(reservation.getFlight().getArrivalCity());

			table.addCell("Departure Date");
			table.addCell(reservation.getFlight().getDateOfDeparture().toString());

			table.addCell("Estimated Departure Date & Time");
			table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

			// Passenger Details Header
			Paragraph paragraph3 = new Paragraph("Passenger details", fontHeader);

			paragraph3.setSpacingBefore(10f); // Space before the paragraph
			paragraph3.setSpacingAfter(20f); // Space after the paragraph

			PdfPTable table1 = new PdfPTable(2); // Create a table with 3 columns

			// Add table cells
			table1.addCell("Passenger Name");
			table1.addCell(reservation.getPassenger().getFirstName() + " " + reservation.getPassenger().getMiddleName()
					+ " " + reservation.getPassenger().getLastName());

			table1.addCell("Mobile Number");
			table1.addCell(reservation.getPassenger().getPhone());

			table1.addCell("Email Id");
			table1.addCell(reservation.getPassenger().getEmail());

			// Add the table to the document
			document.add(paragraph2);
			document.add(table);
			document.add(paragraph3);
			document.add(table1);

			document.close();
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
