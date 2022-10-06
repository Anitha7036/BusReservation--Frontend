package com.busreservation.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bus")

public class Busentity {
	@Id
	private long id;
	@Indexed(unique = true)
    private long busNo;
    private long price;
	private String source;
	private String destination;	
	private String arrival;	
	private String departure;	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBusNo() {
		return busNo;
	}
	public void setBusNo(long busNo) {
		this.busNo = busNo;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	
}
