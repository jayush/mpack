package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.StoresApiService;
import io.swagger.api.factories.StoresApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.StoreAssetCollection;
import io.swagger.model.StoreAssetWrapper;
import io.swagger.model.StoreCollection;
import io.swagger.model.StoreDownloadResponse;
import io.swagger.model.StorePackageCollection;
import io.swagger.model.StorePackageVersionCollection;
import io.swagger.model.StorePackageVersionWrapper;
import io.swagger.model.StorePackageWrapper;
import io.swagger.model.StoreWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/stores")


@io.swagger.annotations.Api(description = "the stores API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class StoresApi  {
   private final StoresApiService delegate = StoresApiServiceFactory.getStoresApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Register management pack store provider with Ambari ", notes = "Register management pack store provider with Ambari ", response = StoreWrapper.class, tags={ "store", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = StoreWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = StoreWrapper.class) })
    public Response addStore(@ApiParam(value = "Management pack store provider to be registered." ) StoreWrapper body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addStore(body,securityContext);
    }
    @GET
    @Path("/{storeId}/assets/{assetId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get specific asset in a registered management pack store provider", notes = "Returns a specific asset in a registered management pack store provider", response = StoreAssetWrapper.class, tags={ "store-asset", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = StoreAssetWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid store ID or asset ID supplied", response = StoreAssetWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Store asset not found", response = StoreAssetWrapper.class) })
    public Response getStoreAssetById(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@ApiParam(value = "ID of asset that needs to be fetched",required=true) @PathParam("assetId") Long assetId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStoreAssetById(storeId,assetId,securityContext);
    }
    @GET
    @Path("/{storeId}/assets")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List assets available in a registered management pack store provider ", notes = "Returns a list of assets in a registered management pack store provider", response = StoreAssetCollection.class, tags={ "store-asset", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = StoreAssetCollection.class) })
    public Response getStoreAssets(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStoreAssets(storeId,securityContext);
    }
    @GET
    @Path("/{storeId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get registered management pack store provider info", notes = "Returns a registered management pack store provider by id", response = StoreWrapper.class, tags={ "store", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = StoreWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid store ID supplied", response = StoreWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Store not found", response = StoreWrapper.class) })
    public Response getStoreById(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStoreById(storeId,securityContext);
    }
    @GET
    @Path("/{storeId}/packages/{packageName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get specific management package in a registered management pack store provider", notes = "Returns a management package by name within a registered management pack store provider", response = StorePackageWrapper.class, tags={ "store-package", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = StorePackageWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid store ID or package name supplied", response = StorePackageWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Store Package not found", response = StorePackageWrapper.class) })
    public Response getStorePackageByName(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorePackageByName(storeId,packageName,securityContext);
    }
    @GET
    @Path("/{storeId}/packages/{packageName}/versions/{packageVersion}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get package version", notes = "Returns package version information", response = StorePackageVersionWrapper.class, tags={ "store-package-version", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = StorePackageVersionWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid package name or package version supplied", response = StorePackageVersionWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package version not found", response = StorePackageVersionWrapper.class) })
    public Response getStorePackageVersion(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@ApiParam(value = "Version of package that needs to be fetched",required=true) @PathParam("packageVersion") String packageVersion
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorePackageVersion(storeId,packageName,packageVersion,securityContext);
    }
    @GET
    @Path("/{storeId}/packages/{packageName}/versions/{packageVersion}/downloadUrl")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Download package version mpack", notes = "Dowload package version mpack", response = StoreDownloadResponse.class, tags={ "store-package-version", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = StoreDownloadResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid package name or package version supplied", response = StoreDownloadResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package version not found", response = StoreDownloadResponse.class) })
    public Response getStorePackageVersionDownloadUrl(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@ApiParam(value = "Version of package that needs to be fetched",required=true) @PathParam("packageVersion") String packageVersion
,@ApiParam(value = "Ambari version to use to fetch compatible mpack",required=true) @QueryParam("ambariVersion") String ambariVersion
,@ApiParam(value = "Operating system type to use to fetch compatible mpack",required=true) @QueryParam("operatingSystem") String operatingSystem
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorePackageVersionDownloadUrl(storeId,packageName,packageVersion,ambariVersion,operatingSystem,securityContext);
    }
    @GET
    @Path("/{storeId}/packages/{packageName}/versions")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List package versions", notes = "Returns list of package versions for a given package in a given management pack store registered with Ambari.", response = StorePackageVersionCollection.class, tags={ "store-package-version", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = StorePackageVersionCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid store ID or package name supplied", response = StorePackageVersionCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package not found", response = StorePackageVersionCollection.class) })
    public Response getStorePackageVersions(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorePackageVersions(storeId,packageName,securityContext);
    }
    @GET
    @Path("/{storeId}/packages")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List packages available in a registered management pack store provider ", notes = "Returns a list of packages available in a registered management pack store provider", response = StorePackageCollection.class, tags={ "store-package", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = StorePackageCollection.class) })
    public Response getStorePackages(@ApiParam(value = "ID of registered management pack store provider",required=true) @PathParam("storeId") Long storeId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStorePackages(storeId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List registered management pack store providers ", notes = "Returns a list of registered management pack store proviers", response = StoreCollection.class, tags={ "store", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = StoreCollection.class) })
    public Response getStores(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getStores(securityContext);
    }
}
