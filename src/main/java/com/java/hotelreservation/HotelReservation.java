package com.java.hotelreservation;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import javax.naming.spi.DirStateFactory.Result;


public class HotelReservation {
	int count;
    static Scanner scanner = new Scanner(System.in);
    
    static ArrayList<Hotel> hotels = new ArrayList<>();
    private static final DateTimeFormatter DATE_RANGE_FORMAT = DateTimeFormatter.ofPattern("ddMMMyyyy");
	public static final String AddHotel = null;

/*uc1 add Hotel in a Hotel
Reservation System with Name and
rates for Regular Customer...*/
	 public static boolean AddHotel() {
		 Hotel hotel = new Hotel();
	        System.out.println("Enter hotel name: ");
	        hotel.setName(scanner.next());
	        System.out.println("Enter hotel rate: ");
	        hotel.setRatings(scanner.nextInt());
	        hotels.add(hotel);
	        System.out.println("Hotel Added");
			return false;
	 }
	 public static void display1() {
	        for (Hotel data : hotels)
	            System.out.println(data);
	 }
	 
	 /*uc2 find the
cheapest Hotel for a
given Date Range*/
	 
	 private static final DateTimeFormatter DATE_RANGE_FORMAT1 = DateTimeFormatter.ofPattern("ddMMMyyyy");

		public static boolean findcheapestHotel(String initialDateRange, String endDateRange) {
			AddHotel();
			LocalDate startDate1 = LocalDate.parse(initialDateRange, DATE_RANGE_FORMAT);
			LocalDate endDate1 = LocalDate.parse(endDateRange, DATE_RANGE_FORMAT);
			long days = ChronoUnit.DAYS.between(initialDateRange, endDateRange);

			List<Hotel> rates = hotels.stream().map(hotelData -> {
				Hotel result = new Hotel();
				result.setName(hotelData.getName());
				result.setTotalrate(hotelData.getRatings());
				return result;
			}).sorted(Comparator.comparing(Hotel::getTotalrate)).collect(Collectors.toList());

			System.out.printf("The total days are : %d\n", days);
			rates.forEach(System.out::println);
			return true;

		}
		/*uc3add weekday
and weekend rates for
each Hotel */
		public static boolean addweekdayweekend() {

			System.out.println("Enter how many hotels :");
			Scanner scan;
			int val = scan.nextInt();
			for (int i = 0; i < val; i++) {
				System.out.println("Enter the hotel name :");
				String name = scan.next();
				System.out.println("Enter the weekday rate :");
				int weekday = scan.nextInt();
				System.out.println("Enter the weekend rate :");
				int weekend = scan.nextInt();
				//uc5
				System.out.println("Enter the hotel ratings :");
				int ratings = scan.nextInt();
				Hotel h1 = new Hotel(name, weekday, weekend, ratings);
				hotels.add(h1);
				System.out.println(hotels.toString());
			}
			return true;
		}
		/*uc4 the cheapest
Hotel for a given Date
Range based on weekday
and weekend - I/P – 11Sep2020, 12Sep2020 - O/P – Lakewood and Bridgewood*/
		private static final DateTimeFormatter DATE_FORMAT1 = DateTimeFormatter.ofPattern("ddMMMyyyy");

		public static boolean cheapesthotelweekdayweekend(String startDate, String endDate) {
			addweekdayweekend();
			LocalDate startDate2 = LocalDate.parse(startDate, DATE_FORMAT1);
			LocalDate endDate2 = LocalDate.parse(endDate, DATE_FORMAT1);
			int days = (int) ChronoUnit.DAYS.between(startDate2, endDate2);

			List<Hotel> rates = hotels.stream().map(hotelData -> {
				Hotel res = new Hotel();

				if (startDate2.getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| endDate2.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
//					res.setTotalrate(hotelData.getWeekendRate() * days);
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				} else {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				}
				res.setWeekdayRate(hotelData.getWeekdayRate());
				res.setWeekendRate(hotelData.getWeekendRate());
				
				res.setName(hotelData.getName());
				return res;
			}).sorted(Comparator.comparing(Hotel::getTotalrate)).collect(Collectors.toList());

			System.out.printf("The total days are : %d\n", days);
			rates.forEach(System.out::println);
			return true;
		}
		/*uc5 the cheapest
Hotel for a given Date
Range based on weekday
and weekend - I/P – 11Sep2020, 12Sep2020 - O/P – Lakewood and Bridgewood*/
		private static final DateTimeFormatter DATE_FORMAT5 = DateTimeFormatter.ofPattern("ddMMMyyyy");

		public static boolean addratingseachhotel(String startDate, String endDate) {
			addweekdayweekend();
			LocalDate startDate2 = LocalDate.parse(startDate, DATE_FORMAT5);
			LocalDate endDate2 = LocalDate.parse(endDate, DATE_FORMAT5);
			int days = (int) ChronoUnit.DAYS.between(startDate2, endDate2);

			List<Hotel> rates = hotels.stream().map(hotelData -> {
				Hotel res = new Hotel();

				if (startDate2.getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| endDate2.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				} else {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				}
				res.setWeekdayRate(hotelData.getWeekdayRate());
				res.setWeekendRate(hotelData.getWeekendRate());
				res.setRatings(hotelData.getRatings());
				res.setName(hotelData.getName());
				return res;
			}).sorted(Comparator.comparing(Hotel::getTotalrate)).collect(Collectors.toList());

			System.out.printf("The total days are : %d\n", days);
			rates.forEach(System.out::println);
			return true;
		}
		
		private static final DateTimeFormatter DATE_FORMAT2 = DateTimeFormatter.ofPattern("ddMMMyyyy");
		public static boolean cheapesthoteltobest(String startDate, String endDate) {
			addweekdayweekend();
			LocalDate startDate2 = LocalDate.parse(startDate, DATE_FORMAT2);
			LocalDate endDate2 = LocalDate.parse(endDate, DATE_FORMAT2);
			int days = (int) ChronoUnit.DAYS.between(startDate2, endDate2);

			List<Hotel> rates = hotels.stream().map(hotelData -> {
				Hotel res = new Hotel();

				if (startDate2.getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| endDate2.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				} else {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				}
				res.setWeekdayRate(hotelData.getWeekdayRate());
				res.setWeekendRate(hotelData.getWeekendRate());
				res.setRatings(hotelData.getRatings());
				res.setName(hotelData.getName());
				return res;
			}).sorted(Comparator.comparing(Hotel::getRatings).thenComparing(Hotel::getTotalrate)).collect(Collectors.toList());

			System.out.printf("The total days are : %d\n", days);
			rates.forEach(System.out::println);
			return true;
		}
		
		private static final DateTimeFormatter DATE_FORMAT3 = DateTimeFormatter.ofPattern("ddMMMyyyy");
		public static boolean bestratedhotel(String startDate, String endDate) {
			addweekdayweekend();
			LocalDate startDate2 = LocalDate.parse(startDate, DATE_FORMAT3);
			LocalDate endDate2 = LocalDate.parse(endDate, DATE_FORMAT3);
			int days = (int) ChronoUnit.DAYS.between(startDate2, endDate2);

			List<Hotel> rates = hotels.stream().map(hotelData -> {
				Hotel res = new Hotel();

				if (startDate2.getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| endDate2.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				} else {
					res.setTotalrate(hotelData.getWeekdayRate() + hotelData.getWeekendRate() * days);
				}
				res.setWeekdayRate(hotelData.getWeekdayRate());
				res.setWeekendRate(hotelData.getWeekendRate());
				res.setRatings(hotelData.getRatings());
				res.setName(hotelData.getName());
				return res;
			}).sorted(Comparator.comparing(Hotel::getRatings).reversed()).collect(Collectors.toList());

			System.out.printf("The total days are : %d\n", days);
			rates.forEach(System.out::println);
			return true;
		}
		
		public boolean addspecialrates() {

			System.out.println("Enter the how many hotel you want to add :");
			Scanner scan;
			int val = scan.nextInt();
			for (int i = 0; i < val; i++) {
				System.out.println("Enter the hotel name :");
				String name = scan.next();
				System.out.println("Enter the regularweekday rate :");
				int regweekday = scan.nextInt();
				System.out.println("Enter the regularweekend rate :");
				int regweekend = scan.nextInt();
				System.out.println("Enter the rewardweekday rate :");
				int rewardweekday = scan.nextInt();
				System.out.println("Enter the rewardweekend rate :");
				int rewardweekend = scan.nextInt();
				System.out.println("Enter the hotel ratings :");
				int ratings = scan.nextInt();
				Hotel h2 = new Hotel(name,ratings,regweekday,regweekend,rewardweekday,rewardweekend);
				hotels.add(h2);
				System.out.println(hotels.toString());
				
			}
			return true;
		}
		public static void main(String args[]) {

			Hotel obj = new Hotel();
			obj.Hotel();
		}
}

}

