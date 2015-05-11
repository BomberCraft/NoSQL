package org.lp.dasi.nosql.tp1.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.lp.dasi.nosql.tp1.model.Statistique;
import org.lp.dasi.nosql.tp1.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/collaborateurs")
public class ResourceStatistiques {

	private static final Logger LOGGER = Logger.getLogger(ResourceStatistiques.class);

	@Autowired
	EmployeService service;

	@GET
	@Produces({ "application/json" })
	public Response getStatistiques() {
		try {
			Statistique statistique = service.getStatistiquesEmployes();

			return Response.ok(statistique).build();
		} catch (Exception e) {
			LOGGER.error("", e.getCause());
			return Response.serverError().build();
		}
	}
}
