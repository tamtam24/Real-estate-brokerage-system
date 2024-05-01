package com.javaweb.utils;

public class NumberUtils {
	public static boolean isLong(String value) {
		if(value == null)return false;
		try { 
			Long numBer = Long.parseLong(value);
		}
		catch(NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
