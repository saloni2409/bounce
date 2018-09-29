package assingment;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.codahale.metrics.annotation.Timed;

@Path("/cash-flow")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CashFlowResource {

	private CashFlowService service;

	public CashFlowResource() {
		this.service = new CashFlowService();
	}
	@POST
	@Timed
	public Response getBill(@Valid Bill bill) {
		ResponseBuilder response=null;
		try {
			response=Response.ok().entity(service.getBill(bill));
			
		} catch (Exception e) {
			response=Response.serverError().entity("{ \"status\"  : \""+ e.getMessage()+"\"}");
		}
		return response.build();
	}
 
	@Path("/basic")
	@POST
	@Timed
	public Response getBillSimplified(@Valid Bill bill) {
		ResponseBuilder response=null;
		try {
			response=Response.ok().entity(service.getBillBasic(bill));
			
		} catch (Exception e) {
			response=Response.serverError().entity("{ \"status\"  : \""+ e.getMessage()+"\"}");
		}

		return response.build();

	}

	@POST
	@Timed
	@Path("/simplified")
	public Response getBillBasic(@Valid Bill bill) {
		ResponseBuilder response=null;
		try {
			response=Response.ok().entity(service.getBillSimplified(bill));
			
		} catch (Exception e) {
			response=Response.serverError().entity("{ \"status\"  : \""+ e.getMessage()+"\"}");
		}

		return response.build();

	}
}