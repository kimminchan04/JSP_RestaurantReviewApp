package com.restaurant.util;

import java.security.MessageDigest;

public class PasswordUtil {
	public static String hashPassword(String pwd) {
		String hashed = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pwd.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				sb.append(String.format("%02x", b));
			}
			hashed = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hashed;
	}
}
