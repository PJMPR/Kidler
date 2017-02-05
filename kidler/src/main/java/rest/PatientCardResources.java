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
import rest.dto.PatientCardDto;
import domain.model.Doctor;
import domain.model.PatientCard;


@Path("/patientCards")
@Stateless
public class PatientCardResources {
	
	Mapper mapper = new DozerBeanMapper();
	
    	@PersistenceContext
    	EntityManager entityManager;
	
    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response getAll(){
    		List<PatientCardDto> result = new ArrayList<PatientCardDto>();
    		for(PatientCard p: entityManager.createNamedQuery("patientCard.all",PatientCard.class).getResultList()){
    			result.add(mapper.map(p, PatientCardDto.class));
    		}
    		return Response.ok(new GenericEntity<List<PatientCardDto>>(result){}).build();
    	}

    	@GET
    	@Path("/{id}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response get(@PathParam("id") int id) {
    		PatientCard result = entityManager.createNamedQuery("patientCard.id", PatientCard.class)
                .setParameter("id", id)
                .getSingleResult();
    		if (result == null) {
    			return Response.status(404).build();
    		}
    		return Response.ok(result).build();
    	}
	
}

