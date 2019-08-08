package com.skillenza.parkinglotjava;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ParkingLot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "created_at")
	private Timestamp created_at;

	@Column(name = "lot", unique = true)
	private int lot;

	@Column(name = "parking_amount")
	private int parking_amount;

	@Column(name = "parking_duration")
	private int parking_duration;

	@Column(name = "updated_date")
	private Timestamp updated_date;

	@Column(name = "vehicle_number", unique = true)
	private int vehicle_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public int getParking_amount() {
		return parking_amount;
	}

	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}

	public int getParking_duration() {
		return parking_duration;
	}

	public void setParking_duration(int parking_duration) {
		this.parking_duration = parking_duration;
	}

	public int getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(int vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "ParkingLot [id=" + id + ", created_at=" + created_at + ", lot=" + lot + ", parking_amount="
				+ parking_amount + ", parking_duration=" + parking_duration + ", updated_date=" + updated_date
				+ ", vehicle_number=" + vehicle_number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + id;
		result = prime * result + lot;
		result = prime * result + parking_amount;
		result = prime * result + parking_duration;
		result = prime * result + ((updated_date == null) ? 0 : updated_date.hashCode());
		result = prime * result + vehicle_number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingLot other = (ParkingLot) obj;
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (id != other.id)
			return false;
		if (lot != other.lot)
			return false;
		if (parking_amount != other.parking_amount)
			return false;
		if (parking_duration != other.parking_duration)
			return false;
		if (updated_date == null) {
			if (other.updated_date != null)
				return false;
		} else if (!updated_date.equals(other.updated_date))
			return false;
		if (vehicle_number != other.vehicle_number)
			return false;
		return true;
	}

}
