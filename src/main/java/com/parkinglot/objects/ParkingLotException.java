package com.parkinglot.objects;

import com.parkinglot.ParkingLotErrorCodes;

public class ParkingLotException extends Exception {
  ParkingLotErrorCodes errorCode;
  String errorMessage;

  public ParkingLotException(ParkingLotErrorCodes errorCode, String errorMessage) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  ParkingLotException(ParkingLotErrorCodes errorCode, String errorMessage, Throwable throwable) {
    super(errorMessage, throwable);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}