package com.parkinglot;

import com.parkinglot.objects.ParkingLotException;
import com.parkinglot.objects.ParkingTicket;
import com.parkinglot.objects.ParkingTicketStatus;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {
  public static void main(String[] args) throws ParkingLotException {
    ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
    parkingLotApplication.createParkingLot(6);
    List<ParkingTicket> parkingTickets = new ArrayList<>();
    List<ParkingTicketStatus> parkingTicketStatuses = new ArrayList<>();
    parkingTickets.add(parkingLotApplication.parkCar("KA-01-HH-1234"));
    parkingTickets.add(parkingLotApplication.parkCar("KA-01-HH-9999"));
    parkingTickets.add(parkingLotApplication.parkCar("KA-01-BB-0001"));
    parkingTickets.add(parkingLotApplication.parkCar("KA-01-HH-7777"));
    parkingTickets.add(parkingLotApplication.parkCar("KA-01-HH-2701"));
    parkingTickets.add(parkingLotApplication.parkCar("KA-01-HH-3141"));
    for (ParkingTicket parkingTicket : parkingTickets) {
      System.out.println(parkingTicket);
    }
    parkingTicketStatuses.add(parkingLotApplication.leave("KA-01-HH-1234", 4));
    for (ParkingTicketStatus parkingTicketStatus : parkingTicketStatuses) {
      System.out.println(parkingTicketStatus);
    }
  }
}