package org.lp.dasi.nosql.tp1.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.lp.dasi.nosql.tp1.model.CritereSuppression;
import org.lp.dasi.nosql.tp1.model.Employe;
import org.lp.dasi.nosql.tp1.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/collaborateurs")
public class ResourceCollaborateurs {

	private static final Logger LOGGER = Logger.getLogger(ResourceCollaborateurs.class);

	@Autowired
	EmployeService service;

	@GET
	@Produces({ "application/json" })
	public Response getAllEmployes() {
		try {
			List<Employe> employes = service.getAllEmployes();
			LOGGER.info("Get all - - - ");

			return Response.ok(employes).build();
		} catch (Exception e) {
			LOGGER.error("", e);
			return Response.serverError().build();
		}
	}

	@POST
	@Consumes({ "application/json" })
	public Response saveNewEmploye(Employe employe) {
		try {
			Long id = service.saveNewEmploye(employe);
			URI uri = new URI("/collaborateurs/" + id);
			LOGGER.info("Create - - - ");

			return Response.created(uri).build();
		} catch (Exception e) {
			LOGGER.error("", e);
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	public Response getEmployeByNum(@PathParam("id") Long numeroEmp) {
		try {
			Employe employe = service.getEmployeByNum(numeroEmp);
			LOGGER.info("Get by ID - - - ");

			if (employe != null) {
				return Response.ok(employe).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			return Response.serverError().build();
		}
	}

	@PUT
	@Consumes({ "application/json" })
	public Response updateEmploye(Employe employe) {
		try {
			service.updateEmploye(employe);
			LOGGER.info("Update - - - ");

			return Response.ok().build();
		} catch (Exception e) {
			LOGGER.error("", e);
			return Response.serverError().build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes({ "application/json" })
	public Response deleteEmployeByNum(@PathParam("id") Long numeroEmp, CritereSuppression critere) {
		try {
			service.deleteEmploye(numeroEmp, critere);
			LOGGER.info("Delete - - - ");

			return Response.ok().build();
		} catch (Exception e) {
			LOGGER.error("", e);
			return Response.serverError().build();
		}
	}

}
