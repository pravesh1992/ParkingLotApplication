package com.parkinglot.commands.impl;

import com.parkinglot.ParkingLotApplication;
import com.parkinglot.commands.Command;

public class DefaultCommand extends Command {
  public DefaultCommand(ParkingLotApplication parkingLotApplication) {
    super(parkingLotApplication);
  }

  @Override
  public String processCommand(String[] inputs) {
    return "";
  }
}