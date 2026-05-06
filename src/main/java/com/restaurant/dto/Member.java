package com.restaurant.dto;

public class Member {
    private int member_id;
    private String mid;
    private String mpw;
    private String name;
    
    public Member() {}
    
	public Member(int member_id, String mid, String mpw, String name) {
		super();
		this.member_id = member_id;
		this.mid = mid;
		this.mpw = mpw;
		this.name = name;
	}
	
	public int getMember_id() {
		return member_id;
	}
	
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getMpw() {
		return mpw;
	}
	
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
