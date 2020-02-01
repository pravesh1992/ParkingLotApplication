package com.parkinglot.commands;

import com.parkinglot.ParkingLotApplication;

public abstract class Command {
  ParkingLotApplication parkingLotApplication;

  public Command(ParkingLotApplication parkingLotApplication) {
    this.parkingLotApplication = parkingLotApplication;
  }

  public ParkingLotApplication getParkingLotApplication() {
    return parkingLotApplication;
  }

  public abstract String processCommand(String[] inputs);
}