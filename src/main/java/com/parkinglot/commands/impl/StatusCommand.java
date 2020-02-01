package com.parkinglot.commands.impl;

import com.parkinglot.ParkingLotApplication;
import com.parkinglot.commands.Command;
import com.parkinglot.objects.ParkingTicket;

import java.util.ArrayList;
import java.util.List;

public class StatusCommand extends Command {
  public StatusCommand(ParkingLotApplication parkingLotApplication) {
    super(parkingLotApplication);
  }

  @Override
  public String processCommand(String[] inputs) {
    List<String> responses = new ArrayList<>();
    for (ParkingTicket parkingTicket : getParkingLotApplication().getParkingTickets()) {
      responses.add(parkingTicket.toString());
    }
    return String.join("\n", responses);
  }
}