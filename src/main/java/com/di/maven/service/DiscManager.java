package com.di.maven.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.di.maven.domain.Disc;
import com.di.maven.domain.Track;

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
	public List<Disc> getDisc(String title) {
		return em.createNamedQuery("disc.all.byTitle").setParameter("title", title).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Disc> getAll(){
		return em.createNamedQuery("disc.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Disc> getAllTitle(String titlePattern){
		return em.createNamedQuery("disc.all.titlePattern").setParameter("titlePattern", titlePattern).getResultList();
	}
	
	/*public List<Track> getTracksOfDisc(long id) {
		Disc retr = em.find(Disc.class, id);
		List<Track> result = new ArrayList<>(retr.getTracks());
		return result;
	}*/
	
	public void addTrackToDisc(Disc disc, Track track) {
		disc.addTrack(track);
		em.flush();
	}
	
	public void editDisc(Disc disc) {
		em.merge(disc);
	}
	
	public void deleteDisc(long id) {
		Disc retr = em.find(Disc.class, id);
		em.remove(retr);
	}
	
	public void deleteAllDisc() {
		em.createNamedQuery("disc.deleteAll");
	}
}
