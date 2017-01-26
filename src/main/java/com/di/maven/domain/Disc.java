package com.di.maven.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"YOP", "TITLE"}))
@NamedQueries({ 
	@NamedQuery(name = "disc.all", query = "Select d from Disc d"),
	@NamedQuery(name = "disc.all.titlePattern", query = "Select d from Disc d where d.title like :titlePattern"),
	@NamedQuery(name = "disc.all.byTitle", query = "Select d from Disc d where d.title = :title")
	//@NamedQuery(name = "book.delete.all", query = "Delete from Book "),
	//@NamedQuery(name = "book.findByYop", query = "Select b from Book b where b.yop = :yop"),
	//@NamedQuery(name = "bookAuthor.findByAthorFirstName",
	//query = "Select a.firstName, a.lastName, b.title, b.yop from Book b JOIN b.authors a where a.firstName = :firstName")
})
@XmlRootElement
public class Disc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	private String title;
	
	@Min(1900)
	@Max(2017)
	private int yop;
	
	//@OneToMany(mappedBy="disc", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	//private List<Track> tracks = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}
	
	//public List<Track> getTracks() {
	//	return tracks;
	//}
	
	public void addTrack(Track track) {
		//if(!getTracks().contains(track)){
			//getTracks().add(track);
			//if(track.getDisc() != null) {
			//	track.getDisc().getTracks().remove(track);
			//}
			track.setDisc(this);
		//}			
	}
	
	//public void setTracks(List<Track> tracks) {
	//	this.tracks = tracks;
	//}
	
}
