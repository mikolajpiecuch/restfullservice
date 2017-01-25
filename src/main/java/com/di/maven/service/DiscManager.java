package com.di.maven.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.di.maven.domain.Disc;

@Stateless
public class DiscManager {

	@PersistenceContext
	EntityManager em;
	
	public void addDisc(Disc disc){
		em.persist(disc);
	}
	
	public Disc getDisc(Long id){
		Disc retr = em.find(Disc.class, id);
		return retr;
	}
	
	@SuppressWarnings("unchecked")
	public List<Disc> getAll(){
		return em.createNamedQuery("disc.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Disc> getAllTitle(String titlePattern){
		return em.createNamedQuery("disc.all.titlePattern").setParameter("titlePattern", titlePattern).getResultList();
	}
}
