package com.sjm.test;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		date.setTime(0);
		System.out.println(date);
		System.out.println(date.getTime());
	}
}
