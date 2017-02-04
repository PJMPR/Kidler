package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import domain.model.PatientCard;
import domain.model.Person;
import rest.dto.PersonDto;


@Path("/people")
@Stateless
public class PersonResources {

	
	Mapper mapper = new DozerBeanMapper();
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 
	 @GET
	  @Produces(MediaType.APPLICATION_JSON)
	    public Response getAll(){
	    	List<PersonDto> result = new ArrayList<PersonDto>();
	    	for(Person p: entityManager.createNamedQuery("person.all",Person.class).getResultList())
	    	{
	        	result.add(mapper.map(p, PersonDto.class));
	        }
	        return Response.ok(new GenericEntity<List<PersonDto>>(result){}).build();
	    }
	 

	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response Add(Person person)
	 {
		 entityManager.persist(person);
		 return Response.ok(person.getId()).build();	
	 }
	 
	 @GET
	 @Path("/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response get(@PathParam("id") int id){
		Person result = entityManager.createNamedQuery("person.id", Person.class).setParameter("id", id).getSingleResult();
		if(result==null){
			return Response.status(404).build();
		}
			return Response.ok(result).build();
		}
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response update(@PathParam("id") int id, Person p){
			Person result = entityManager.createNamedQuery("person.id", Person.class).setParameter("id", id).getSingleResult();
			if(result==null){
				return Response.status(404).build();
			}
			result.setName(p.getName());
			result.setSurname(p.getSurname());
			entityManager.persist(result);
			return Response.ok().build();
		}
		@DELETE
		@Path("/{id}")
		public Response delete(@PathParam("id") int id){
			Person result = entityManager.createNamedQuery("person.id", Person.class).setParameter("id", id).getSingleResult();
			if(result==null){
				return Response.status(404).build();
			}
			entityManager.remove(result);
			return Response.ok().build();
		}
}
