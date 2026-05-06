package com.restaurant.dao;

import java.sql.*;
import java.util.*;

import com.restaurant.dto.Review;
import com.restaurant.util.DBUtil;

public class ReviewDAO {
    public List<Review> getReviewByRestaurant(int restaurant_id) {
    	String sql = "select * from review where restaurant_id = ? order by review_id desc";
    	List<Review> list = new ArrayList<>();
    	try {
    		Connection conn = DBUtil.getConnection(); 
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();
    		while (rs.next()) {
    			Review r = new Review();
    			r.setReview_id(rs.getInt("review_id"));
    			r.setRestaurant_id(rs.getInt("restaurant_id"));
    			r.setMember_id(rs.getInt("member_id"));
    			r.setScore(rs.getInt("score"));
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
    
    public List<Review> getReviewByMember(int member_id) {
    	List<Review> list = new ArrayList<>();
    	String sql = "select * from review where member_id = ? order by review_id desc";
    	try (Connection conn = DBUtil.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(sql)) {
    		pstmt.setInt(1, member_id);
    		ResultSet rs = pstmt.executeQuery();
    		while (rs.next()) {
    			Review r = new Review();
    			r.setReview_id(rs.getInt("review_id"));
    			r.setRestaurant_id(rs.getInt("restaurant_id"));
    			r.setMember_id(rs.getInt("member_id"));
    			r.setScore(rs.getInt("score"));
    			r.setDescription(rs.getString("description"));
    			list.add(r);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    public int insertReview(Review r) {
        String sql = "insert into review(restaurant_id, member_id, score, description) " + "values (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
        	    PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, r.getRestaurant_id());
        	pstmt.setInt(2, r.getMember_id());
        	pstmt.setInt(3, r.getScore());
        	pstmt.setString(4, r.getDescription());
        	
        	return pstmt.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	DBUtil.close();
        }
        
        return 0;
    }
    
    public int updateReview(Review r) {
    	String sql = "update review set score = ? description = ? where review_id = ? and member_id = ? ";
    	try (Connection conn = DBUtil.getConnection();
        	    PreparedStatement pstmt = conn.prepareStatement(sql)) {
    		pstmt.setInt(1, r.getScore());
        	pstmt.setString(2, r.getDescription());
        	pstmt.setInt(3, r.getReview_id());
        	pstmt.setInt(4, r.getMember_id());
        	
        	return pstmt.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return 0;
    }
    
    public int deleteReview(Review r) {
    	String sql = "delete from review where review_id = ? and memeber_id = ?";
    	try (Connection conn = DBUtil.getConnection();
        	    PreparedStatement pstmt = conn.prepareStatement(sql)) {
    		pstmt.setInt(1, r.getReview_id());
        	pstmt.setInt(2, r.getMember_id());
        	
        	return pstmt.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return 0;
    }
}
