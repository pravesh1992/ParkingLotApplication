package com.parkinglot.commands;

public enum Commands {

  //Arrays.asList(new String[]{"create_parking_lot", "park", "leave", "status"});
  CREATE_PARKING_LOT_COMMAND("create_parking_lot"),
  STATUS_COMMAND("status"),
  PARK_COMMAND("park"),
  LEAVE_COMMAND("leave");

  String value;

  public String getValue() {
    return value;
  }

  Commands(String code) {
    this.value = code;
  }
}
