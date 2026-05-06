package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.restaurant.dto.Member;
import com.restaurant.util.DBUtil;

public class MemberDAO {
	public boolean isUserExists(String uid) {
		boolean exists = false;
		String sql = "select member_id from member where mid = ?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) exists = true; 
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exists;
	}
	
	public int insertMember(Member m) {
		int result = 0;
		String sql = "insert into member (mid, mpw, name) values(?,?,?)";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMid());
			pstmt.setString(2, m.getMpw());
			pstmt.setString(3, m.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Member login(String uid, String pwd) {
		Member member = null; 
		String sql = "SELECT * FROM member WHERE mid = ? and mpw = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); 
			
			if (rs.next()) { 
				member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMpw(rs.getString("mpw"));
				member.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return member;
	}
}
