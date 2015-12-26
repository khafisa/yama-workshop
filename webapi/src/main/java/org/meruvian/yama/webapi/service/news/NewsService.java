package org.meruvian.yama.webapi.service.news;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.tot.news.News;

@Path("/api/news")
@Api("/news")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NewsService {
	@GET
	@Path("/{id}")
	@ApiOperation(httpMethod = "GET", value = "Get news by ID",
    response = News.class)
	News getNewsById(@PathParam("id") long id);
	
	@GET
	@ApiOperation(httpMethod = "GET", value = "Find News by title", 
    response = News.class, responseContainer = "Page")
	List<News> findNewsByTitle(@QueryParam("title") @DefaultValue("") String title);
	
	@POST
	@ApiOperation(httpMethod = "POST", value = "Post News", 
    response = News.class)
	News saveNews(News news);
	
	@PUT
	@Path("/{id}")
	@ApiOperation(httpMethod = "PUT", value = "PUT N by ID", 
    response = News.class)
	News updateNews(@PathParam("id") long id, News news);
	
	@DELETE
	@Path("/{id}")
	@ApiOperation(httpMethod = "DELETE", value = "Delete News by ID")
	void deleteNews(@PathParam("id") long id);
}
