package com.di.maven.util;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TrackParam {
	private long DiscId;
	private String title;
	private String duration;
	
	public long getDiscId() {
		return DiscId;
	}
	public void setDiscId(long discId) {
		DiscId = discId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
