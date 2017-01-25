package com.di.maven.domain;

import java.util.ArrayList;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "disc.all", query = "Select d from Disc d"),
	@NamedQuery(name = "disc.all.titlePattern", query = "Select d from Disc d where d.title like :titlePattern")
	//@NamedQuery(name = "book.delete.all", query = "Delete from Book "),
	//@NamedQuery(name = "book.findByYop", query = "Select b from Book b where b.yop = :yop"),
	//@NamedQuery(name = "bookAuthor.findByAthorFirstName",
	//query = "Select a.firstName, a.lastName, b.title, b.yop from Book b JOIN b.authors a where a.firstName = :firstName")
})
@XmlRootElement
public class Disc {
	private long id;
	
	private String title;
	
	private int yop;

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
	
	
}
