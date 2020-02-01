package com.parkinglot.objects;

public class ParkingTicketStatus extends ParkingTicket {
  private final int numberOfHoursCarParked;
  private int totalParkingCharge;

  public ParkingTicketStatus(ParkingTicket parkingTicket, int numberOfHoursCarParked) {
    super(parkingTicket.getRegistrationNumber(), parkingTicket.getAllocatedSlotNumber());
    this.numberOfHoursCarParked = numberOfHoursCarParked;
    calculateTotalParkingCharge();
  }

  public void setTotalParkingCharge(int totalParkingCharge) {
    this.totalParkingCharge = totalParkingCharge;
  }

  private void calculateTotalParkingCharge() {
    totalParkingCharge = 20 + (numberOfHoursCarParked - 2) * 10;
  }

  @Override
  public String toString() {
    return "ParkingTicketStatus{" +
      "registrationNumber='" + getRegistrationNumber() + '\'' +
      ", allocatedSlotNumber=" + getAllocatedSlotNumber() +
      "numberOfHoursCarParked=" + numberOfHoursCarParked +
      ", totalParkingCharge=" + totalParkingCharge +
      '}';
  }
}