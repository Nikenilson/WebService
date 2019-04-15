/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.PathParam;


/**
 * REST Web Service
 *
 * @author u18169
 */
@Path("filmes")
public class FilmesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FilmesResource
     */
    private static List<Filme> filmes;

    public FilmesResource()
    {
		filmes = new ArrayList<Filme>();
		MeuResultSet ret = Filmes.getFilmes();
		int i = 1;
		while(ret.next())
		{
			filmes.add(ret);
		}
    }

    /**
     * Retrieves representation of an instance of br.metodista.servicos.FilmesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/gson")
    public String getXml() {
    Gson gson = new Gson();
        return gson.toJson(filmes);
  }



    /**
     * PUT method for updating or creating an instance of FilmesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Path("{filmeId}")
    @Produces("application/json")
    public String getFilme(@PathParam("filmeId")
    String filmeId) {

    for(Filme f : filmes) {
      if(f.getId() == Long.valueOf(filmeId)) {
        Gson gson = new Gson();
        return gson.toJson(f);
      }
    }

    return null;
  }

}
