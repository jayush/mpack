package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public abstract class StoresApiService {
    public abstract Response addStore(StoreWrapper body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStoreAssetById(Long storeId,Long assetId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStoreAssets(Long storeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStoreById(Long storeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorePackageByName(Long storeId,String packageName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorePackageVersion(Long storeId,String packageName,String packageVersion,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorePackageVersionDownloadUrl(Long storeId,String packageName,String packageVersion,String ambariVersion,String operatingSystem,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorePackageVersions(Long storeId,String packageName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStorePackages(Long storeId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getStores(SecurityContext securityContext) throws NotFoundException;
}
