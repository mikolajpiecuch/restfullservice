package com.di.maven.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;


@XmlRootElement
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"DISC_ID", "TITLE"})) //@UniqueConstraint(columnNames={"author_id", "number"})})
@NamedQueries({
	@NamedQuery(name = "track.getAll", query = "Select t from Track t"),
	@NamedQuery(name="track.deleteAll", query="Delete from Track"),	
	@NamedQuery(name = "track.getByDiscId", query="Select t from Track t where t.disc.id = :discId")
})
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	@ManyToOne
	private Disc disc;
	
	private String title;
	
	//@Temporal(TemporalType.TIME)
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy mm:ss")
	

	@DecimalMax("59.59")
	@DecimalMin("0.01")
	@Digits(integer=2, fraction=2)
	private BigDecimal duration;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}
	
	public Disc getDisc() {
		return disc;
	}
	
	public void setDisc(Disc disc) {
		this.disc = disc;
	}
	
}
