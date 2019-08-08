package com.skillenza.parkinglotjava;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotImpl {

	@Autowired
	ParkingLotRepository parkingLotRepository;

	/**
	 * Retrieving parking data
	 * 
	 * @return
	 */
	public List<ParkingLot> findAll() {
		List<ParkingLot> parkingLots = parkingLotRepository.findAll();
		return parkingLots;
	}

	/**
	 * Adding Parking data
	 * 
	 * @param entity
	 * @return
	 */
	public ParkingLot addParkingLot(ParkingLot entity) {
		ParkingLot parkingLot = new ParkingLot();
		try {
			parkingLot = parkingLotRepository.save(entity);
		} catch (Exception e) {
			throw new DupicateParkingLotOrVechicleException("Parking lot and vechicle number should be unique");
		}
		return parkingLot;
	}

	/**
	 * Method for preparing parking object
	 * 
	 * @param parkingLot
	 * @return
	 */
	public ParkingLot prepareParkingLot(ParkingLot parkingLot) {
		parkingLot.setParking_amount(calcParkingCharge(parkingLot));
		parkingLot.setCreated_at(new Timestamp(System.currentTimeMillis()));
		parkingLot.setUpdated_date(new Timestamp(System.currentTimeMillis()));
		return parkingLot;
	}

	/**
	 * Calculate the Parking charge based on criteria
	 * 
	 * @param parkingLot
	 * @return
	 */
	public int calcParkingCharge(ParkingLot parkingLot) {
		if (parkingLot.getParking_duration() <= 60) {
			return Constants.MIN_PARKING_CHARGE;
		}
		return (int) Math.round(Constants.MIN_PARKING_CHARGE
				+ ((parkingLot.getParking_duration() - Constants.HOUR_IN_MINUTE) * Constants.CHARGE_PER_MINUTE));
	}

}
