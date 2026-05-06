package com.restaurant.dto;

public class Review {
    private int review_id;
    private int restaurant_id;
    private int member_id;
    private int score;
    private String description;
    
	public int getReview_id() {
		return review_id;
	}
	
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	
	public int getRestaurant_id() {
		return restaurant_id;
	}
	
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	
	public int getMember_id() {
		return member_id;
	}
	
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
