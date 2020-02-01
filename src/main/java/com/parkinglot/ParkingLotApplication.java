package com.parkinglot;

import com.parkinglot.objects.ParkingLotException;
import com.parkinglot.objects.ParkingTicket;
import com.parkinglot.objects.ParkingTicketStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ParkingLotApplication {
  private Set<ParkingTicket> parkingTickets = null;
  private int size;
  private ArrayList<Integer> allocatedParkingSlotNumbers;

  public void createParkingLot(int totalParkingSlots) throws ParkingLotException {
    if (totalParkingSlots <= 0)
      throw new ParkingLotException(ParkingLotErrorCodes.INVALID_PARKING_SLOT_SIZE, "Parking lot can't be created with size :" + totalParkingSlots);
    this.size = totalParkingSlots;
    this.allocatedParkingSlotNumbers = new ArrayList<>();
    parkingTickets = new HashSet<>(this.size);
  }


  public ParkingTicket parkCar(String registrationNumber) throws ParkingLotException {
    if (!isParkingSlotCreated())
      throw new ParkingLotException(ParkingLotErrorCodes.PARKING_LOT_NOT_CREATED, "Parking lot is not created, please created parking lot first and park your car");
    if (!isParkingAvailable())
      throw new ParkingLotException(ParkingLotErrorCodes.PARKING_LOT_IS_FULL, "Sorry, parking lot is full");
    int availableParkingSlotNumber = getAvailableParkingSlotNumber();
    ParkingTicket parkingTicket = new ParkingTicket(registrationNumber, availableParkingSlotNumber);
    if (parkingTickets.contains(parkingTicket))
      throw new ParkingLotException(ParkingLotErrorCodes.CAR_IS_ALREADY_PARKED, "Car with registration number:" + registrationNumber + " is already parked");
    allocatedParkingSlotNumbers.add(availableParkingSlotNumber);
    parkingTickets.add(parkingTicket);
    return parkingTicket;
  }

  public ParkingTicketStatus leave(String registrationNumber, int numberOfHoursCarParked) throws ParkingLotException {
    if (numberOfHoursCarParked <= 0)
      throw new ParkingLotException(ParkingLotErrorCodes.INVALID_PARKED_TIME_VALUE, "Number Of hours car parked can't be less the zero");
    int dummyParkingSLot = Integer.MAX_VALUE;
    ParkingTicket parkingTicket = new ParkingTicket(registrationNumber, dummyParkingSLot);
    if (!parkingTickets.contains(parkingTicket))
      throw new ParkingLotException(ParkingLotErrorCodes.CAR_NOT_PARKED, "Car with registration number:" + registrationNumber + " is not parked in parking slot");
    ParkingTicket actualParkingTicket = getParkingTicket(registrationNumber);
    parkingTickets.remove(actualParkingTicket);
    allocatedParkingSlotNumbers.remove(actualParkingTicket.getAllocatedSlotNumber());
    return new ParkingTicketStatus(actualParkingTicket, numberOfHoursCarParked);
  }


  private boolean isParkingSlotCreated() {
    return parkingTickets != null;
  }

  private boolean isParkingAvailable() {
    return parkingTickets.size() < size;
  }

  int getAvailableParkingSlotNumber() {
    int slotNumber = 1;
    for (int i = 1; i <= size; i++) {
      if (!this.allocatedParkingSlotNumbers.contains(i)) {
        return i;
      }
    }
    return slotNumber;
  }

  public ParkingTicket getParkingTicket(String registrationNumber) throws ParkingLotException {
    Optional optional = parkingTickets.stream().filter(parkedCar -> parkedCar.getRegistrationNumber().equals(registrationNumber)).findFirst();
    if (optional.isPresent()) return (ParkingTicket) optional.get();
    else
      throw new ParkingLotException(ParkingLotErrorCodes.CAR_NOT_PARKED, "Car with registration number:" + registrationNumber + " is not parked in parking slot");
  }
}
