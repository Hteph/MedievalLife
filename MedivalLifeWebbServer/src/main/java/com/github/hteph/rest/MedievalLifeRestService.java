package com.github.hteph.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.github.hteph.webbserving.MedivalLifeWebbPageGeneration;
import com.hteph.modules.Settlement;

@Stateless
@Path("/startvillage")
public class MedievalLifeRestService {
	
	
	
	
	@GET
	@Produces("application/XML")
	public Settlement createVillage() {
				
		return MedivalLifeWebbPageGeneration.generate();
		
		
	}
	

}
