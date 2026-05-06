package com.restaurant.dao;

import java.sql.*;
import java.util.*;

import com.restaurant.dto.Restaurant;
import com.restaurant.util.DBUtil;

public class RestaurantDAO {
	public int insertRestaurant(Restaurant dto) {
		String sql = "insert into restaurant " + "(restaurant_id, name, address, lat, lng, description) " +
	        "values (?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement p = conn.prepareStatement(sql)) {
			p.setInt(1, dto.getRestaurant_id());
			p.setString(2, dto.getName());
			p.setString(3, dto.getAddress());
			p.setDouble(4, dto.getLat());
			p.setDouble(5, dto.getLng());
			p.setString(6, dto.getDescription());
			
			return p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
		}
		
			return 0;
	}
	
	public Restaurant getRestaurantById(int id) {
		String sql = "select * from restaurant where restaurant_id = ?";
		Restaurant r = new Restaurant();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement p = conn.prepareStatement(sql)) {
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
			    r.setRestaurant_id(rs.getInt("restaurant_id"));
			    r.setName(rs.getString("name"));
			    r.setAddress(rs.getString("address"));
			    r.setLat(rs.getDouble("lat"));
			    r.setLng(rs.getDouble("lng"));
			    r.setDescription(rs.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
		}
		
		return r;
	}
	
	public List<Restaurant> getAllRestaurant() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Restaurant> list = new ArrayList<>();
		String sql = "select * from restaurant order by restaurant_id desc";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Restaurant r = new Restaurant();
			    r.setRestaurant_id(rs.getInt("restaurant_id"));
			    r.setName(rs.getString("name"));
			    r.setAddress(rs.getString("address"));
			    r.setLat(rs.getDouble("lat"));
			    r.setLng(rs.getDouble("lng"));
			    r.setDescription(rs.getString("description"));
				list.add(r);
			} 
		} catch (Exception e) {
		    e.printStackTrace();		
		} finally {
			DBUtil.close();
		}
		
		return list;
	}
	
	public int getTotalCount() {
		String sql = "select count(*) total_restaurant from restaurant where 1 = 1;";
		ResultSet rs = null;
		int cnt = 0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			rs = pstmt.executeQuery();
			if (rs.next()) cnt = rs.getInt("total_restaurant");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
		}
		
		return cnt;
	}
	
	public List<Restaurant> getRestaurantList(int start, int pageSize) {
		List<Restaurant> list = new ArrayList<>();
		String sql = "select * from restaurant order by restaurant_id desc limit ?, ?";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageSize);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Restaurant r = new Restaurant();
				r.setRestaurant_id(rs.getInt("restaurant_id"));
				r.setName(rs.getString("name"));
				r.setAddress(rs.getString("address"));
				r.setLat(rs.getDouble("lat"));
				r.setLng(rs.getDouble("lng"));
				r.setDescription(rs.getString("description"));
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Restaurant> getRestaurantByScore() {
		List<Restaurant> list = new ArrayList<>();
		String sql = "select r.*, ifnull(avg(rv.score), 0) avg_score "
				+ "from restaurant r left join review rv on r.restaurant_id = rv.restaurant_id "
				+ "group by r.restaurant_id order by avg_score desc";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Restaurant r = new Restaurant();
				r.setRestaurant_id(rs.getInt("restaurant_id"));
				r.setName(rs.getString("name"));
				r.setAddress(rs.getString("address"));
				r.setLat(rs.getDouble("lat"));
				r.setLng(rs.getDouble("lng"));
				r.setDescription(rs.getString("description"));
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

