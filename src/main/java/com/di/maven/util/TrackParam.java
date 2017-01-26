package com.di.maven.util;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TrackParam {
	private long DiscId;
	private String title;
	private BigDecimal duration;
	
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
	public BigDecimal getDuration() {
		return duration;
	}
	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}
}
