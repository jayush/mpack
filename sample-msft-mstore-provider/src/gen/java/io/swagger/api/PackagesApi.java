package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PackagesApiService;
import io.swagger.api.factories.PackagesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.DownloadResponse;
import io.swagger.model.PackageCollection;
import io.swagger.model.PackageVersionCollection;
import io.swagger.model.PackageVersionWrapper;
import io.swagger.model.PackageWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/packages")


@io.swagger.annotations.Api(description = "the packages API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public class PackagesApi  {
   private final PackagesApiService delegate = PackagesApiServiceFactory.getPackagesApi();

    @GET
    @Path("/{packageName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get package", notes = "Returns a package by name", response = PackageWrapper.class, tags={ "package", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = PackageWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid package name supplied", response = PackageWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package not found", response = PackageWrapper.class) })
    public Response getPackageByName(@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackageByName(packageName,securityContext);
    }
    @GET
    @Path("/{packageName}/versions/{packageVersion}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get package version", notes = "Returns package version information", response = PackageVersionWrapper.class, tags={ "package-version", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = PackageVersionWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid package name or package version supplied", response = PackageVersionWrapper.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package version not found", response = PackageVersionWrapper.class) })
    public Response getPackageVersion(@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@ApiParam(value = "Version of package that needs to be fetched",required=true) @PathParam("packageVersion") String packageVersion
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackageVersion(packageName,packageVersion,securityContext);
    }
    @GET
    @Path("/{packageName}/versions/{packageVersion}/downloadUrl")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get package version management pack download url", notes = "Get package version management pack download url", response = DownloadResponse.class, tags={ "package-version", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = DownloadResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid package name or package version supplied", response = DownloadResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package version not found", response = DownloadResponse.class) })
    public Response getPackageVersionDownloadUrl(@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@ApiParam(value = "Version of package that needs to be fetched",required=true) @PathParam("packageVersion") String packageVersion
,@ApiParam(value = "Ambari version to use to fetch compatible mpack",required=true) @QueryParam("ambariVersion") String ambariVersion
,@ApiParam(value = "Operating system type to use to fetch compatible mpack",required=true) @QueryParam("operatingSystem") String operatingSystem
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackageVersionDownloadUrl(packageName,packageVersion,ambariVersion,operatingSystem,securityContext);
    }
    @GET
    @Path("/{packageName}/versions")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List package versions", notes = "Returns list of package versions for a given package", response = PackageVersionCollection.class, tags={ "package-version", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = PackageVersionCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid package name supplied", response = PackageVersionCollection.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Package not found", response = PackageVersionCollection.class) })
    public Response getPackageVersions(@ApiParam(value = "Name of package that needs to be fetched",required=true) @PathParam("packageName") String packageName
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackageVersions(packageName,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List packages ", notes = "Returns a list of packages", response = PackageCollection.class, tags={ "package", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = PackageCollection.class) })
    public Response getPackages(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPackages(securityContext);
    }
}
