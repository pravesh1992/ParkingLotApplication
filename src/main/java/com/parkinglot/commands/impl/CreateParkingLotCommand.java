package com.parkinglot.commands.impl;

import com.parkinglot.ParkingLotApplication;
import com.parkinglot.commands.Command;
import com.parkinglot.objects.ParkingLotException;

public class CreateParkingLotCommand extends Command {
  public CreateParkingLotCommand(ParkingLotApplication parkingLotApplication) {
    super(parkingLotApplication);
  }

  @Override
  public String processCommand(String[] inputs) {
    String result = "";
    try {
      Integer size = Integer.parseInt(inputs[0]);
      getParkingLotApplication().createParkingLot(size);
      result = "Created parking lot with " + size + " slots";
    } catch (ParkingLotException e) {
      result = e.getMessage();
    }
    return result;
  }
}