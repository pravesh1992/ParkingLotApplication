package com.parkinglot;

public enum ParkingLotErrorCodes {
  INTERNAL_SERVER_ERROR(2001),
  INVALID_PARKING_SLOT_SIZE(2002),
  PARKING_LOT_NOT_CREATED(2003),
  PARKING_LOT_IS_FULL(2004),
  CAR_IS_ALREADY_PARKED(2005),
  INVALID_PARKED_TIME_VALUE(2006),
  CAR_NOT_PARKED(2007);

  int code;

  ParkingLotErrorCodes(int code) {
    this.code = code;
  }
}