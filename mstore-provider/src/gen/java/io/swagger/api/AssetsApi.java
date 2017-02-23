package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.AssetsApiService;
import io.swagger.api.factories.AssetsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.AssetCollection;
import io.swagger.model.AssetWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/assets")


@io.swagger.annotations.Api(description = "the assets API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-17T18:13:19.921Z")
public class AssetsApi  {
   private final AssetsApiService delegate = AssetsApiServiceFactory.getAssetsApi();

    @GET
    @Path("/{assetId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get asset", notes = "Returns an asset by id", response = AssetWrapper.class, tags={ "asset", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = AssetWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid asset ID supplied", response = AssetWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Asset not found", response = AssetWrapper.class) })
    public Response getAssetById(@ApiParam(value = "ID of asset that needs to be fetched",required=true) @PathParam("assetId") Long assetId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAssetById(assetId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List assets ", notes = "Returns a list of assets", response = AssetCollection.class, tags={ "asset", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = AssetCollection.class) })
    public Response getAssets(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAssets(securityContext);
    }
}
