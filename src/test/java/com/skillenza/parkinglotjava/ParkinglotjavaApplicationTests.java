package com.skillenza.parkinglotjava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotjavaApplicationTests {

	@Autowired
	ParkingLotImpl impl;

	private ParkingLot createParkingRequest() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.setLot(1);
		parkingLot.setParking_amount(10);
		parkingLot.setParking_duration(65);
		parkingLot.setVehicle_number(1);
		return parkingLot;
	}

	@Test
	public void testParkingLot() {
		ParkingLot parkingLot = createParkingRequest();
		Assert.assertNotNull(parkingLot);
		Assert.assertNotNull(parkingLot.getLot());
		Assert.assertNotNull(parkingLot.getVehicle_number());
		Assert.assertNotNull(parkingLot.getParking_duration());
	}

	@Test
	public void testPreparedParking() {
		ParkingLot parkingLot = createParkingRequest();
		Assert.assertNotNull(impl.prepareParkingLot(parkingLot));
		ParkingLot preparedParkingLot = impl.prepareParkingLot(parkingLot);
		Assert.assertEquals(parkingLot.getLot(), preparedParkingLot.getLot());
		Assert.assertEquals(parkingLot.getParking_duration(), preparedParkingLot.getParking_duration());
		Assert.assertEquals(parkingLot.getVehicle_number(), preparedParkingLot.getVehicle_number());
		Assert.assertEquals(parkingLot.getParking_amount(), preparedParkingLot.getParking_amount());
	}

	@Test
	public void testCalcParkingCharge() {
		ParkingLot parkingLot = createParkingRequest();
		Assert.assertNotNull(parkingLot);
		int preparedParkingLot = impl.calcParkingCharge(parkingLot);
		Assert.assertEquals(22, preparedParkingLot);

	}
}
