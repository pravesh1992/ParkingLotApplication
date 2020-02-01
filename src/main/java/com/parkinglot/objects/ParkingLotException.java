package com.parkinglot.objects;

import com.parkinglot.exception.ParkingLotErrorCodes;

public class ParkingLotException extends Exception {
  ParkingLotErrorCodes errorCode;
  String errorMessage;

  public ParkingLotException(ParkingLotErrorCodes errorCode, String errorMessage) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public ParkingLotException(ParkingLotErrorCodes errorCode, String errorMessage, Throwable throwable) {
    super(errorMessage, throwable);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public ParkingLotErrorCodes getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}