package com.di.maven.rest;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.di.maven.domain.Disc;
import com.di.maven.domain.Track;
import com.di.maven.service.DiscManager;
import com.di.maven.service.TrackManager;
import com.di.maven.util.TrackParam;


//import com.di.maven.domain.Book;
//import com.example.restejbjpa.domain.Car;
//import com.example.restejbjpa.domain.Person;
//import com.example.restejbjpa.service.BookManager;
//import com.di.maven.service.PersonManager;

@Path("track")
public class TrackRestService {

	@EJB
	TrackManager tm;
	@EJB
	DiscManager dm;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTrack(TrackParam trackParam){
		//tm.addTrack(track);
		Track track = new Track();
		Disc disc = dm.getDisc(trackParam.getDiscId());
		//disc.addTrack(track);
		//track.setDisc(disc);
		track.setTitle(trackParam.getTitle());

		//SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		//Date dur;
		//try {
		//	dur = sdf.parse(trackParam.getDuration());
		//} catch(Exception e) {
		//	dur = new Date(0, 0, 0, 0, 0, 0);
		//}
		track.setDuration(trackParam.getDuration());
		
		dm.addTrackToDisc(disc, track);
		tm.addTrack(track);
		
		
		return Response.status(Response.Status.CREATED).build();	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Track> getAll(){
		return tm.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getById(@PathParam("id") long id){
		return tm.getTrack(id);
	}
	
	@GET
	@Path("/bydisc/{discId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Track> getAllByDisc(@PathParam("discId") long discId) {
		return tm.getByDiscId(discId);
	}
	
	@PUT 
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editTrack(@PathParam("id") long id, Track track) {
		track.setId(id);
		tm.editTrack(track);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTrack(@PathParam("id") long id) {
		tm.deleteTrack(id);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("deleteAll")
	public Response deleteAllTracks() {
		tm.deleteAllTracks();
		return Response.status(Response.Status.OK).build();
	}
	
	/*@GET
	@Path("/{titlePattern}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disc> getAllTitle(@PathParam("titlePattern") String titlePattern){
		String pattern = "%" + titlePattern + "%";
		return tm.getAllTitle(pattern);
	}*/
	
	/*@POST
	@Path("/addTrack")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTrackToDisc(Track track)	{
		dm.addTrackToDisc(discId, track);
		
		return Response.status(Response.Status.CREATED).build();
	}*/
}