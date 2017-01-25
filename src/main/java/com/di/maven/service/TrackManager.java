package com.di.maven.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.di.maven.domain.Disc;
import com.di.maven.domain.Track;

@Stateless
public class TrackManager {

	@PersistenceContext
	EntityManager em;
	
	public void addTrack(Track track){
		em.persist(track);
	}
	
	public Track getTrack(Long id){
		Track retr = em.find(Track.class, id);
		return retr;
	}
	
	@SuppressWarnings("unchecked")
	public List<Track> getAll(){
		return em.createNamedQuery("track.getAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Track> getByDiscId(long discId) {
		return em.createNamedQuery("track.getByDiscId").setParameter("discId", discId).getResultList();
	}
	
	public void editTrack(Track track) {
		em.merge(track);
	}
	
	public void deleteTrack(long id) {
		Track retr = em.find(Track.class, id);
		em.remove(retr);
	}
	
	public void deleteAllTracks() {
		em.createNamedQuery("track.deleteAll");
	}
	
	/*@SuppressWarnings("unchecked")
	public List<Track> getAllTitle(String titlePattern){
		return em.createNamedQuery("disc.all.titlePattern").setParameter("titlePattern", titlePattern).getResultList();
	}*/
	
	/*public List<Track> getTracksOfDisc(long id) {
		Disc retr = em.find(Disc.class, id);
		List<Track> result = new ArrayList<>(retr.getTracks());
		return result;
	}*/
	
	/*public void addTrackToDisc(Track track) {
		Disc retr = em.find(Disc.class, track.getDiscId());
		List<Track> trackRetr = retr.getTracks();
		trackRetr.add(track);
		retr.setTracks(trackRetr);
	}*/
}