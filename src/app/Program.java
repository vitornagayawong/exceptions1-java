package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.println("Checkin date(dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.println("Check-OUT date(dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.println("Check-in date(dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());

			System.out.println("Check-OUT date(dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();
	}

}
