package com.restaurant.dto;

public class Restaurant {
    private int restaurant_id;
    private String name;
    private String address;
    private double lat;
    private double lng;
    private String description;
    
    public Restaurant() {}
    
	public Restaurant(int restaurant_id, String name, String address, double lat, double lng, String description) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.description = description;
	}
	
	public int getRestaurant_id() {
		return restaurant_id;
	}
	
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
