import com.parkinglot.ParkingLotApplication;
import com.parkinglot.exception.ParkingLotErrorCodes;
import com.parkinglot.objects.ParkingLotException;
import org.junit.Assert;
import org.junit.Test;

public class ParkingApplicationTest {

  @Test
  public void test1_createParkingLotTest() {
    try {
      new ParkingLotApplication().createParkingLot(6);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void test2_createParkingLotTest_with_0_size() {
    try {
      new ParkingLotApplication().createParkingLot(0);
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.INVALID_PARKING_SLOT_SIZE);
    }
  }

  @Test
  public void test3_parkTest() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.createParkingLot(6);
      parkingLotApplication.parkCar("KA-01-HH-1234");
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void test4_parkTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.parkCar("KA-01-HH-1234");
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.PARKING_LOT_NOT_CREATED);
    }
  }

  @Test
  public void test5_parkTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.createParkingLot(6);
      parkingLotApplication.parkCar("KA-01-HH-1234");
      parkingLotApplication.parkCar("KA-02-HH-1234");
      parkingLotApplication.parkCar("KA-03-HH-1234");
      parkingLotApplication.parkCar("KA-04-HH-1234");
      parkingLotApplication.parkCar("KA-05-HH-1234");
      parkingLotApplication.parkCar("KA-06-HH-1234");
      parkingLotApplication.parkCar("KA-07-HH-1234");
      parkingLotApplication.parkCar("KA-08-HH-1234");
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.PARKING_LOT_IS_FULL);
    }
  }

  @Test
  public void test6_parkTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.createParkingLot(6);
      parkingLotApplication.parkCar("KA-01-HH-1234");
      parkingLotApplication.parkCar("KA-01-HH-1234");
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.CAR_IS_ALREADY_PARKED);
    }
  }

  @Test
  public void test7_leaveTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.createParkingLot(6);
      parkingLotApplication.parkCar("KA-01-HH-1234");
      parkingLotApplication.leave("KA-01-HH-1234", 4);
    } catch (ParkingLotException e) {
      Assert.fail();
    }
  }

  @Test
  public void test8_leaveTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.createParkingLot(6);
      parkingLotApplication.parkCar("KA-01-HH-1234");
      parkingLotApplication.leave("KA-01-HH-123545", 4);
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.CAR_NOT_PARKED);
    }
  }

  @Test
  public void test9_leaveTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.createParkingLot(6);
      parkingLotApplication.parkCar("KA-01-HH-1234");
      parkingLotApplication.leave("KA-01-HH-1234", 0);
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.INVALID_PARKED_TIME_VALUE);
    }
  }

  @Test
  public void test10_leaveTestFailed() {
    try {
      ParkingLotApplication parkingLotApplication = new ParkingLotApplication();
      parkingLotApplication.leave("KA-01-HH-1234", 9);
    } catch (ParkingLotException e) {
      Assert.assertEquals(e.getErrorCode(), ParkingLotErrorCodes.PARKING_LOT_NOT_CREATED);
    }
  }
}