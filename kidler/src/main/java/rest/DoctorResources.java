package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;


import domain.model.Doctor;
import domain.model.PatientCard;
import rest.dto.DoctorDto;


@Path("/Doctor")
@Stateless
public class DoctorResources {

	Mapper mapper = new DozerBeanMapper();
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<DoctorDto> result = new ArrayList<DoctorDto>();
	    	for(Doctor r: entityManager.createNamedQuery("Doctor.all",Doctor.class).getResultList())
	    	{
	        	result.add(mapper.map(r, DoctorDto.class));
	        }

	       
	        return Response.ok(new GenericEntity<List<DoctorDto>>(result){}).build();
	    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response Add(Doctor Doctor)
	 {
		 entityManager.persist(Doctor);
		 return Response.ok(Doctor.getId()).build();	
	 }
	 
	    @GET
	    @Path("/{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response get(@PathParam("id") int id) {
	        Doctor result = entityManager.createNamedQuery("Doctor.id", Doctor.class)
	                .setParameter("id", id)
	                .getSingleResult();
	        if (result == null) {
	            return Response.status(404).build();
	        }
	        return Response.ok(result).build();
	    }
	    
	    @DELETE
		 @Path("/{id}")
		    public Response delete(@PathParam("id") int id) {
		        PatientCard result = entityManager.createNamedQuery("Doctor.id", PatientCard.class)
		                .setParameter("id", id)
		                .getSingleResult();
		        if (result == null)
		            return Response.status(404).build();
		        entityManager.remove(result);
		        return Response.ok().build();
		    }
}
