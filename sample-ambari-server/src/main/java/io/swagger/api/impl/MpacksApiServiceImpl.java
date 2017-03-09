package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.client.ApiClient;
import io.swagger.client.api.PackageversionApi;
import io.swagger.client.model.DownloadResponse;
import io.swagger.model.*;

import io.swagger.model.MpackCollection;
import io.swagger.model.MpackWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class MpacksApiServiceImpl extends MpacksApiService {

    public static String ambariVersion = "3.0.0";
    public static String newAmbariVersion = "3.1.0";
    public static String operatingSystem = "centos6";
    private static Long s_mpackId = 1L;
    private static String s_baseUrl = "http://localhost:8080/api/v2";
    public static MpackCollection mpackCollection = new MpackCollection().href(s_baseUrl + "/mpacks");

    public StoreCollection getStoreCollection() {
        return StoresApiServiceImpl.storeCollection;
    }
    @Override
    public Response addMpack(MpackWrapper body, SecurityContext securityContext) throws NotFoundException {

        Mpack mpack = body.getMpack();
        StoreCollection storeCollection = getStoreCollection();
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == mpack.getStoreId()) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + mpack.getStoreId() + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageversionApi apiInstance = new PackageversionApi();
        apiInstance.setApiClient(apiClient);
        try {
            DownloadResponse downloadResponse = apiInstance.getPackageVersionDownloadUrl(
                mpack.getPackageName(), mpack.getPackageVersion(), ambariVersion, operatingSystem);
            StoreDownloadResponse storeDownloadResponse = new StoreDownloadResponse();
            storeDownloadResponse.setUrl(downloadResponse.getUrl());
            body.setHref(s_baseUrl + "/mpacks/" + s_mpackId);
            mpack.setId(s_mpackId++);
            mpack.setUrl(storeDownloadResponse.getUrl());
            mpackCollection.addItemsItem(body);
            return Response.ok().entity(body).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling PackageversionApi#getPackageVersionDownloadUrl");
            e.printStackTrace();
            throw new NotFoundException(1, "Package " + mpack.getPackageName() + " with version " + mpack.getPackageVersion() +
                " not found in store with id " + mpack.getStoreId());
        }
    }
    @Override
    public Response getMpackById(Long mpackId, SecurityContext securityContext) throws NotFoundException {
        for(MpackWrapper mpackWrapper : mpackCollection.getItems()) {
            if(mpackWrapper.getMpack().getId() == mpackId) {
                return Response.ok().entity(mpackWrapper).build();
            }
        }
        throw new NotFoundException(1, "Mpack with id " + mpackId + " not found");
    }
    @Override
    public Response getMpacks(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(mpackCollection).build();
    }
    @Override
    public Response refreshMpackById(Long mpackId, Boolean refresh, SecurityContext securityContext) throws NotFoundException {

        MpackWrapper mpackWrapper = null;
        for(MpackWrapper item : mpackCollection.getItems()) {
            if(item.getMpack().getId() == mpackId) {
                mpackWrapper = item;
            }
        }
        if(mpackWrapper == null) {
            throw new NotFoundException(1, "Mpack with id " + mpackId + " not found");
        }

        Mpack mpack = mpackWrapper.getMpack();
        StoreCollection storeCollection = getStoreCollection();
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == mpack.getStoreId()) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + mpack.getStoreId() + " not found");
        }

        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageversionApi apiInstance = new PackageversionApi();
        apiInstance.setApiClient(apiClient);
        if(refresh) {
            try {
                DownloadResponse downloadResponse = apiInstance.getPackageVersionDownloadUrl(
                    mpack.getPackageName(), mpack.getPackageVersion(), newAmbariVersion, operatingSystem);
                StoreDownloadResponse storeDownloadResponse = new StoreDownloadResponse();
                storeDownloadResponse.setUrl(downloadResponse.getUrl());
                mpack.setUrl(storeDownloadResponse.getUrl());
                return Response.ok().entity(mpackWrapper).build();
            } catch (io.swagger.client.ApiException e) {
                System.err.println("Exception when calling PackageversionApi#getPackageVersionDownloadUrl");
                e.printStackTrace();
                throw new NotFoundException(1, "Package " + mpack.getPackageName() + " with version " + mpack.getPackageVersion() +
                    " not found in store with id " + mpack.getStoreId());
            }
        } else {
            // Nothing to modify
            return Response.ok().entity(mpackWrapper).build();
        }
    }
}
