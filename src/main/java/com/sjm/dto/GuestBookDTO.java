package com.sjm.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GuestBookDTO {

	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime = new Date(1234);
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
