package com;

import model.Hospital;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Hospitals")
public class HospitalService {
	Hospital hospitalObj = new Hospital();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitals() {
		return hospitalObj.readHospitals();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("hospitalCode") String hospitalCode, @FormParam("name") String name,
			@FormParam("chiefDoc") String chiefDoc, @FormParam("type") String type, @FormParam("phone") int phone,
			@FormParam("address") String address, @FormParam("desc") String desc) {
		String output = hospitalObj.insertHospital(hospitalCode, name, chiefDoc, type, phone, address, desc);
		return output;
	}

}