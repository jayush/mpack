package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.DownloadResponse;
import io.swagger.model.PackageCollection;
import io.swagger.model.PackageVersionCollection;
import io.swagger.model.PackageVersionWrapper;
import io.swagger.model.PackageWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public abstract class PackagesApiService {
    public abstract Response getPackageByName(String packageName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackageVersion(String packageName,String packageVersion,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackageVersionDownloadUrl(String packageName,String packageVersion,String ambariVersion,String operatingSystem,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackageVersions(String packageName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackages(SecurityContext securityContext) throws NotFoundException;
}
