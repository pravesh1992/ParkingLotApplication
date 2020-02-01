package com.parkinglot.objects;

import java.io.Serializable;
import java.util.Objects;

public class ParkingTicket implements Serializable {
  private final String registrationNumber;
  private final int allocatedSlotNumber;

  public ParkingTicket(String registrationNumber, int allocatedSlotNumber) {
    this.registrationNumber = registrationNumber;
    this.allocatedSlotNumber = allocatedSlotNumber;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public int getAllocatedSlotNumber() {
    return allocatedSlotNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ParkingTicket)) return false;
    ParkingTicket that = (ParkingTicket) o;
    return Objects.equals(getRegistrationNumber(), that.getRegistrationNumber());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRegistrationNumber());
  }

  @Override
  public String toString() {
    return allocatedSlotNumber + " " + registrationNumber;
  }
}
