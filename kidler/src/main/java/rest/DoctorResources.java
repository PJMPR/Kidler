package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.DoctorDto;
import domain.model.Doctor;


@Path("/doctors")
@Stateless
public class DoctorResources {
	
	Mapper mapper = new DozerBeanMapper();
	
    	@PersistenceContext
    	EntityManager entityManager;
	
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getAll(){
    		List<DoctorDto> result = new ArrayList<DoctorDto>();
    		for(Doctor p: entityManager.createNamedQuery("doctor.all",Doctor.class).getResultList()){
    			result.add(mapper.map(p, DoctorDto.class));
    		}
    		return Response.ok(new GenericEntity<List<DoctorDto>>(result){}).build();
    	}

    	@GET
    	@Path("/{id}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response get(@PathParam("id") int id) {
    		Doctor result = entityManager.createNamedQuery("doctor.id", Doctor.class)
                .setParameter("id", id)
                .getSingleResult();
    		if (result == null) {
    			return Response.status(404).build();
    		}
    		return Response.ok(result).build();
    	}
	
}
