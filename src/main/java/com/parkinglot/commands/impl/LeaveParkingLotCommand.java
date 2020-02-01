package com.parkinglot.commands.impl;

import com.parkinglot.ParkingLotApplication;
import com.parkinglot.commands.Command;
import com.parkinglot.objects.ParkingLotException;
import com.parkinglot.objects.ParkingTicketStatus;

public class LeaveParkingLotCommand extends Command {
  public LeaveParkingLotCommand(ParkingLotApplication parkingLotApplication) {
    super(parkingLotApplication);
  }

  @Override
  public String processCommand(String[] inputs) {
    String result = "";
    try {
      ParkingTicketStatus parkingTicketStatus = getParkingLotApplication().leave(inputs[0], Integer.parseInt(inputs[1]));
      result = "Registration number " + parkingTicketStatus.getRegistrationNumber() + " with Slot Number " + parkingTicketStatus.getAllocatedSlotNumber() + " is free with Charge " + parkingTicketStatus.getTotalParkingCharge();
    } catch (ParkingLotException e) {
      result = e.getMessage();
    }
    return result;
  }
}