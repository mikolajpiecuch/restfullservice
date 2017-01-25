package com.di.maven.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.di.maven.domain.Disc;
import com.di.maven.service.DiscManager;


//import com.di.maven.domain.Book;
//import com.example.restejbjpa.domain.Car;
//import com.example.restejbjpa.domain.Person;
//import com.example.restejbjpa.service.BookManager;
//import com.di.maven.service.PersonManager;

@Path("disc")
public class DiscRestService {

	@EJB
	DiscManager dm;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDisc(Disc disc){
		dm.addDisc(disc);
		
		return Response.status(Response.Status.CREATED).build();	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disc> getAll(){
		return dm.getAll();
	}
	
	@GET
	@Path("/{titlePattern}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disc> getAllTitle(@PathParam("titlePattern") String titlePattern){
		String pattern = "%" + titlePattern + "%";
		return dm.getAllTitle(pattern);
	}
}


