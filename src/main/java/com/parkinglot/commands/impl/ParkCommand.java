package com.parkinglot.commands.impl;

import com.parkinglot.ParkingLotApplication;
import com.parkinglot.commands.Command;
import com.parkinglot.objects.ParkingLotException;
import com.parkinglot.objects.ParkingTicket;

public class ParkCommand extends Command {
  public ParkCommand(ParkingLotApplication parkingLotApplication) {
    super(parkingLotApplication);
  }

  @Override
  public String processCommand(String[] inputs) {
    String result = "";
    try {
      ParkingTicket parkingTicket = getParkingLotApplication().parkCar(inputs[0]);
      result = "Allocated slot number: " + parkingTicket.getAllocatedSlotNumber();
    } catch (ParkingLotException e) {
      result = e.getMessage();
    }
    return result;
  }
}