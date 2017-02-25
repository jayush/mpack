package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MpacksApiService;
import io.swagger.api.factories.MpacksApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.MpackCollection;
import io.swagger.model.MpackWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/mpacks")


@io.swagger.annotations.Api(description = "the mpacks API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class MpacksApi  {
   private final MpacksApiService delegate = MpacksApiServiceFactory.getMpacksApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Install management pack in Ambari ", notes = "Install management pack in Ambari ", response = MpackWrapper.class, tags={ "mpack", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = MpackWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = MpackWrapper.class) })
    public Response addMpack(@ApiParam(value = "Management pack to be registered." ) MpackWrapper body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addMpack(body,securityContext);
    }
    @GET
    @Path("/{mpackId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get management pack info", notes = "Returns management pack by id", response = MpackWrapper.class, tags={ "mpack", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = MpackWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid mpack ID supplied", response = MpackWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Mpack not found", response = MpackWrapper.class) })
    public Response getMpackById(@ApiParam(value = "ID of installed management pack",required=true) @PathParam("mpackId") Long mpackId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMpackById(mpackId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List installed management packs ", notes = "Returns list of installed management packs", response = MpackCollection.class, tags={ "mpack", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = MpackCollection.class) })
    public Response getMpacks(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getMpacks(securityContext);
    }
    @PATCH
    @Path("/{mpackId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Refresh managemnt pack by redownloading compatible management pack from the store", notes = "Refresh managemnt pack by redownloading compatible management pack from the store", response = MpackWrapper.class, tags={ "mpack", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = MpackWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid mpack ID supplied", response = MpackWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Mpack not found", response = MpackWrapper.class) })
    public Response refreshMpackById(@ApiParam(value = "ID of installed management pack",required=true) @PathParam("mpackId") Long mpackId
,@ApiParam(value = "", defaultValue="true") @DefaultValue("true") @QueryParam("refresh") Boolean refresh
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.refreshMpackById(mpackId,refresh,securityContext);
    }
}
