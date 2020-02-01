package com.parkinglot.commands.impl;

import com.parkinglot.ParkingLotApplication;
import com.parkinglot.commands.Command;
import com.parkinglot.commands.Commands;

public class CommandFactory {

  public static Command getCommand(String command, ParkingLotApplication parkingLotApplication) {
    if (command.equals(Commands.CREATE_PARKING_LOT_COMMAND.getValue()))
      return new CreateParkingLotCommand(parkingLotApplication);
    else if (command.equals(Commands.LEAVE_COMMAND.getValue()))
      return new LeaveParkingLotCommand(parkingLotApplication);
    else if (command.equals(Commands.STATUS_COMMAND.getValue()))
      return new StatusCommand(parkingLotApplication);
    else if (command.equals(Commands.PARK_COMMAND.getValue()))
      return new ParkCommand(parkingLotApplication);
    else return new DefaultCommand(parkingLotApplication);
  }
}
