package com.sjm.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ArticleDTO {

	private String title;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime = new Date(1234);
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
