package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.client.ApiClient;
import io.swagger.client.api.AssetApi;
import io.swagger.client.api.PackageApi;
import io.swagger.client.api.PackageversionApi;
import io.swagger.model.*;

import io.swagger.client.model.*;

import io.swagger.model.StoreAssetCollection;
import io.swagger.model.StoreAssetWrapper;
import io.swagger.model.StoreCollection;
import io.swagger.model.StoreDownloadResponse;
import io.swagger.model.StorePackageCollection;
import io.swagger.model.StorePackageVersionCollection;
import io.swagger.model.StorePackageVersionWrapper;
import io.swagger.model.StorePackageWrapper;
import io.swagger.model.StoreWrapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.util.Map;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T06:39:18.478Z")
public class StoresApiServiceImpl extends StoresApiService {
    private static Long s_storeId = 1L;
    private static String s_baseUrl = "http://localhost:8080/api/v2";
    private static StoreCollection storeCollection = new StoreCollection().href(s_baseUrl + "/stores");

    @Override
    public Response addStore(StoreWrapper body, SecurityContext securityContext) throws NotFoundException {
        body.getStore().setId(s_storeId);
        body.setHref(s_baseUrl + "/stores/" + s_storeId++);
        storeCollection.addItemsItem(body);
        return Response.ok().entity(body).build();
    }
    @Override
    public Response downloadStorePackageVersion(Long storeId, String packageName, String packageVersion, String ambariVersion, String operatingSystem, SecurityContext securityContext) throws NotFoundException {

        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageversionApi apiInstance = new PackageversionApi();
        apiInstance.setApiClient(apiClient);
        try {
            DownloadResponse downloadResponse = apiInstance.getPackageVersionDownloadUrl(
                packageName, packageVersion, ambariVersion, operatingSystem);
            StoreDownloadResponse storeDownloadResponse = new StoreDownloadResponse();
            storeDownloadResponse.setUrl(downloadResponse.getUrl());
            return Response.ok().entity(storeDownloadResponse).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling PackageversionApi#downloadPackageVersion");
            e.printStackTrace();
            throw new NotFoundException(1, "Package " + packageName + " with version " + packageVersion + 
                " not found in store with id " + storeId);
        }
    }
    @Override
    public Response getStoreAssetById(Long storeId, Long assetId, SecurityContext securityContext) throws NotFoundException {
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();
        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        AssetApi apiInstance = new AssetApi();
        apiInstance.setApiClient(apiClient);
        try {
            AssetWrapper assetWrapper = apiInstance.getAssetById(assetId);
            StoreAssetWrapper storeAssetWrapper = new StoreAssetWrapper();
            storeAssetWrapper.setHref(assetWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
            StoreAsset storeAsset = new StoreAsset();
            Asset asset = assetWrapper.getAsset();
            storeAsset.setId(asset.getId());
            storeAsset.setDescription(asset.getDescription());
            storeAsset.setName(asset.getName());
            storeAsset.setType(asset.getType());
            storeAsset.setUrls(asset.getUrls());
            storeAssetWrapper.setAsset(storeAsset);
            return Response.ok().entity(storeAssetWrapper).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling AssetApi#getAssetById");
            e.printStackTrace();
            throw new NotFoundException(1, "Asset with id " + assetId + " not found in store " + storeId);
        }
    }
    @Override
    public Response getStoreAssets(Long storeId, SecurityContext securityContext) throws NotFoundException {
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        AssetApi apiInstance = new AssetApi();
        apiInstance.setApiClient(apiClient);
        try {
            AssetCollection assetCollection = apiInstance.getAssets();
            StoreAssetCollection storeAssetCollection = new StoreAssetCollection();
            storeAssetCollection.setHref(storeWrapper.getHref() + "/assets");
            for(AssetWrapper assetWrapper: assetCollection.getItems()) {
                StoreAssetWrapper storeAssetWrapper = new StoreAssetWrapper();
                storeAssetWrapper.setHref(assetWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                StoreAsset storeAsset = new StoreAsset();
                Asset asset = assetWrapper.getAsset();
                storeAsset.setId(asset.getId());
                storeAsset.setDescription(asset.getDescription());
                storeAsset.setName(asset.getName());
                storeAsset.setType(asset.getType());
                storeAsset.setUrls(asset.getUrls());
                storeAssetWrapper.setAsset(storeAsset);
                storeAssetCollection.addItemsItem(storeAssetWrapper);
            }
            return Response.ok().entity(storeAssetCollection).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling AssetApi#getAssets");
            e.printStackTrace();
            throw new NotFoundException(1, "Assets not found in store " + storeId);
        }
    }
    @Override
    public Response getStoreById(Long storeId, SecurityContext securityContext) throws NotFoundException {
        for(StoreWrapper storeWrapper : storeCollection.getItems()) {
            if(storeWrapper.getStore().getId() == storeId) {
                return Response.ok().entity(storeWrapper).build();
            }
        }
        throw new NotFoundException(1, "Store with id " + storeId + " not found");
    }
    @Override
    public Response getStorePackageByName(Long storeId, String packageName, SecurityContext securityContext) throws NotFoundException {
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageApi apiInstance = new PackageApi();
        apiInstance.setApiClient(apiClient);
        try {
            PackageWrapper packageWrapper = apiInstance.getPackageByName(packageName);
            StorePackageWrapper storePackageWrapper = new StorePackageWrapper();
            storePackageWrapper.setHref(packageWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));

            ModelPackage modelPackage = packageWrapper.getPackage();
            StorePackage storePackage = new StorePackage();
            storePackage.setName(modelPackage.getName());
            storePackage.setDescription(modelPackage.getDescription());
            AssetWrapper logoWrapper = modelPackage.getLogo();
            StoreAssetWrapper storeLogoWrapper = new StoreAssetWrapper();
            storeLogoWrapper.setHref(logoWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
            StoreAsset storeLogo = new StoreAsset();
            Asset logo = logoWrapper.getAsset();
            storeLogo.setId(logo.getId());
            storeLogo.setName(logo.getName());
            storeLogo.setType(logo.getType());
            storeLogo.setDescription(logo.getDescription());
            storeLogo.setUrls(logo.getUrls());
            storeLogoWrapper.setAsset(storeLogo);
            storePackage.setLogo(storeLogoWrapper);
            storePackageWrapper.setPackage(storePackage);

            List<StorePackageVersionWrapper> storePackageVersions = new LinkedList<>();
            for(PackageVersionWrapper packageVersionWrapper : packageWrapper.getVersions()) {
                StorePackageVersionWrapper storePackageVersionWrapper = new StorePackageVersionWrapper();
                storePackageVersionWrapper.setHref(packageVersionWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));

                StorePackageVersion storePackageVersion = new StorePackageVersion();
                PackageVersion packageVersion = packageVersionWrapper.getPackageVersion();
                storePackageVersion.setVersion(packageVersion.getVersion());
                storePackageVersion.setBuildNumber(packageVersion.getBuildNumber());
                storePackageVersionWrapper.setPackageVersion(storePackageVersion);

                StoreAssetWrapper storeDocWrapper = new StoreAssetWrapper();
                AssetWrapper docWrapper = packageVersionWrapper.getDoc();
                storeDocWrapper.setHref(docWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                StoreAsset storeDoc = new StoreAsset();
                Asset doc = docWrapper.getAsset();
                storeDoc.setId(doc.getId());
                storeDoc.setName(doc.getName());
                storeDoc.setType(doc.getType());
                storeDoc.setDescription(doc.getDescription());
                storeDoc.setUrls(doc.getUrls());
                storeDocWrapper.setAsset(storeDoc);
                storePackageVersionWrapper.setDoc(storeDocWrapper);

                StoreAssetWrapper storeMpackWrapper = new StoreAssetWrapper();
                AssetWrapper mpackWrapper = packageVersionWrapper.getMpack();
                storeMpackWrapper.setHref(mpackWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                StoreAsset storeMpack = new StoreAsset();
                Asset mpack = mpackWrapper.getAsset();
                storeMpack.setId(mpack.getId());
                storeMpack.setName(mpack.getName());
                storeMpack.setType(mpack.getType());
                storeMpack.setDescription(mpack.getDescription());
                storeMpack.setUrls(mpack.getUrls());
                storeMpackWrapper.setAsset(storeMpack);
                storePackageVersionWrapper.setMpack(storeMpackWrapper);

                List<StoreCompatiblePackage> storeCompatiblePackages = new LinkedList<>();
                for(CompatiblePackage compatiblePackage : packageVersionWrapper.getCompatiblePackages()) {
                    StoreCompatiblePackage storeCompatiblePackage = new StoreCompatiblePackage();
                    storeCompatiblePackage.setName(compatiblePackage.getName());
                    storeCompatiblePackage.setMaxVersion(compatiblePackage.getMaxVersion());
                    storeCompatiblePackage.setMinVersion(compatiblePackage.getMinVersion());
                    storeCompatiblePackages.add(storeCompatiblePackage);
                }
                storePackageVersionWrapper.setCompatiblePackages(storeCompatiblePackages);

                List<StorePackageService> storeServices = new LinkedList<>();
                for(PackageService service : packageVersionWrapper.getServices()) {
                    StorePackageService storeService = new StorePackageService();
                    storeService.setName(service.getName());
                    storeService.setDisplayName(service.getDisplayName());
                    storeServices.add(storeService);
                }
                storePackageVersionWrapper.setServices(storeServices);
                storePackageVersions.add(storePackageVersionWrapper);
            }
            storePackageWrapper.setVersions(storePackageVersions);
            return Response.ok().entity(storePackageWrapper).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling PackageApi#getPackageByName");
            e.printStackTrace();
            throw new NotFoundException(1, "Packages not found in store " + storeId);
        }
    }
    @Override
    public Response getStorePackageVersion(Long storeId, String packageName, String packageVersion, SecurityContext securityContext) throws NotFoundException {
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageversionApi apiInstance = new PackageversionApi();
        apiInstance.setApiClient(apiClient);
        try {
            PackageVersionWrapper packageVersionWrapper = apiInstance.getPackageVersion(packageName, packageVersion);

            StorePackageVersionWrapper storePackageVersionWrapper = new StorePackageVersionWrapper();
            storePackageVersionWrapper.setHref(packageVersionWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));

            StorePackageVersion storePackageVersion = new StorePackageVersion();
            PackageVersion pkgVersion = packageVersionWrapper.getPackageVersion();
            storePackageVersion.setVersion(pkgVersion.getVersion());
            storePackageVersion.setBuildNumber(pkgVersion.getBuildNumber());
            storePackageVersionWrapper.setPackageVersion(storePackageVersion);

            StoreAssetWrapper storeDocWrapper = new StoreAssetWrapper();
            AssetWrapper docWrapper = packageVersionWrapper.getDoc();
            storeDocWrapper.setHref(docWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
            StoreAsset storeDoc = new StoreAsset();
            Asset doc = docWrapper.getAsset();
            storeDoc.setId(doc.getId());
            storeDoc.setName(doc.getName());
            storeDoc.setType(doc.getType());
            storeDoc.setDescription(doc.getDescription());
            storeDoc.setUrls(doc.getUrls());
            storeDocWrapper.setAsset(storeDoc);
            storePackageVersionWrapper.setDoc(storeDocWrapper);

            StoreAssetWrapper storeMpackWrapper = new StoreAssetWrapper();
            AssetWrapper mpackWrapper = packageVersionWrapper.getMpack();
            storeMpackWrapper.setHref(mpackWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
            StoreAsset storeMpack = new StoreAsset();
            Asset mpack = mpackWrapper.getAsset();
            storeMpack.setId(mpack.getId());
            storeMpack.setName(mpack.getName());
            storeMpack.setType(mpack.getType());
            storeMpack.setDescription(mpack.getDescription());
            storeMpack.setUrls(mpack.getUrls());
            storeMpackWrapper.setAsset(storeMpack);
            storePackageVersionWrapper.setMpack(storeMpackWrapper);

            List<StoreCompatiblePackage> storeCompatiblePackages = new LinkedList<>();
            for(CompatiblePackage compatiblePackage : packageVersionWrapper.getCompatiblePackages()) {
                StoreCompatiblePackage storeCompatiblePackage = new StoreCompatiblePackage();
                storeCompatiblePackage.setName(compatiblePackage.getName());
                storeCompatiblePackage.setMaxVersion(compatiblePackage.getMaxVersion());
                storeCompatiblePackage.setMinVersion(compatiblePackage.getMinVersion());
                storeCompatiblePackages.add(storeCompatiblePackage);
            }
            storePackageVersionWrapper.setCompatiblePackages(storeCompatiblePackages);

            List<StorePackageService> storeServices = new LinkedList<>();
            for(PackageService service : packageVersionWrapper.getServices()) {
                StorePackageService storeService = new StorePackageService();
                storeService.setName(service.getName());
                storeService.setDisplayName(service.getDisplayName());
                storeServices.add(storeService);
            }
            storePackageVersionWrapper.setServices(storeServices);
            return Response.ok().entity(storePackageVersionWrapper).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling PackageversionApi#getPackageVersion");
            e.printStackTrace();
            throw new NotFoundException(1, "Package " + packageName + " with version " + packageVersion + " not found in store with id " + storeId);
        }
    }
    @Override
    public Response getStorePackageVersions(Long storeId, String packageName, SecurityContext securityContext) throws NotFoundException {
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageversionApi apiInstance = new PackageversionApi();
        apiInstance.setApiClient(apiClient);

        try {
            PackageVersionCollection packageVersionCollection = apiInstance.getPackageVersions(packageName);
            StorePackageVersionCollection storePackageVersionCollection = new StorePackageVersionCollection();
            storePackageVersionCollection.setHref(packageVersionCollection.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
            List<StorePackageVersionWrapper> storePackageVersions = new LinkedList<>();
            for(PackageVersionWrapper packageVersionWrapper : packageVersionCollection.getItems()) {
                StorePackageVersionWrapper storePackageVersionWrapper = new StorePackageVersionWrapper();
                storePackageVersionWrapper.setHref(packageVersionWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));

                StorePackageVersion storePackageVersion = new StorePackageVersion();
                PackageVersion packageVersion = packageVersionWrapper.getPackageVersion();
                storePackageVersion.setVersion(packageVersion.getVersion());
                storePackageVersion.setBuildNumber(packageVersion.getBuildNumber());
                storePackageVersionWrapper.setPackageVersion(storePackageVersion);

                StoreAssetWrapper storeDocWrapper = new StoreAssetWrapper();
                AssetWrapper docWrapper = packageVersionWrapper.getDoc();
                storeDocWrapper.setHref(docWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                StoreAsset storeDoc = new StoreAsset();
                Asset doc = docWrapper.getAsset();
                storeDoc.setId(doc.getId());
                storeDoc.setName(doc.getName());
                storeDoc.setType(doc.getType());
                storeDoc.setDescription(doc.getDescription());
                storeDoc.setUrls(doc.getUrls());
                storeDocWrapper.setAsset(storeDoc);
                storePackageVersionWrapper.setDoc(storeDocWrapper);

                StoreAssetWrapper storeMpackWrapper = new StoreAssetWrapper();
                AssetWrapper mpackWrapper = packageVersionWrapper.getMpack();
                storeMpackWrapper.setHref(mpackWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                StoreAsset storeMpack = new StoreAsset();
                Asset mpack = mpackWrapper.getAsset();
                storeMpack.setId(mpack.getId());
                storeMpack.setName(mpack.getName());
                storeMpack.setType(mpack.getType());
                storeMpack.setDescription(mpack.getDescription());
                storeMpack.setUrls(mpack.getUrls());
                storeMpackWrapper.setAsset(storeMpack);
                storePackageVersionWrapper.setMpack(storeMpackWrapper);

                List<StoreCompatiblePackage> storeCompatiblePackages = new LinkedList<>();
                for(CompatiblePackage compatiblePackage : packageVersionWrapper.getCompatiblePackages()) {
                    StoreCompatiblePackage storeCompatiblePackage = new StoreCompatiblePackage();
                    storeCompatiblePackage.setName(compatiblePackage.getName());
                    storeCompatiblePackage.setMaxVersion(compatiblePackage.getMaxVersion());
                    storeCompatiblePackage.setMinVersion(compatiblePackage.getMinVersion());
                    storeCompatiblePackages.add(storeCompatiblePackage);
                }
                storePackageVersionWrapper.setCompatiblePackages(storeCompatiblePackages);

                List<StorePackageService> storeServices = new LinkedList<>();
                for(PackageService service : packageVersionWrapper.getServices()) {
                    StorePackageService storeService = new StorePackageService();
                    storeService.setName(service.getName());
                    storeService.setDisplayName(service.getDisplayName());
                    storeServices.add(storeService);
                }
                storePackageVersionWrapper.setServices(storeServices);
                storePackageVersions.add(storePackageVersionWrapper);
            }
            storePackageVersionCollection.setItems(storePackageVersions);
            return Response.ok().entity(storePackageVersionCollection).build();
        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling PackageversionApi#getPackageVersions");
            e.printStackTrace();
            throw new NotFoundException(1, "Package versions not found for package " + packageName + " in store " + storeId);
        }
    }
    @Override
    public Response getStorePackages(Long storeId, SecurityContext securityContext) throws NotFoundException {
        StoreWrapper storeWrapper = null;
        for(StoreWrapper item : storeCollection.getItems()) {
            if(item.getStore().getId() == storeId) {
                storeWrapper = item;
            }
        }
        if(storeWrapper == null) {
            throw new NotFoundException(1, "Store with id " + storeId + " not found");
        }
        String storeBaseUrl = storeWrapper.getStore().getUrl();

        ApiClient apiClient = new ApiClient().setBasePath(storeBaseUrl);
        PackageApi apiInstance = new PackageApi();
        apiInstance.setApiClient(apiClient);
        try {
            PackageCollection packageCollection = apiInstance.getPackages();
            StorePackageCollection storePackageCollection = new StorePackageCollection();
            storePackageCollection.setHref(packageCollection.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
            for(PackageWrapper packageWrapper : packageCollection.getItems()) {
                StorePackageWrapper storePackageWrapper = new StorePackageWrapper();
                storePackageWrapper.setHref(packageWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));

                ModelPackage modelPackage = packageWrapper.getPackage();
                StorePackage storePackage = new StorePackage();
                storePackage.setName(modelPackage.getName());
                storePackage.setDescription(modelPackage.getDescription());
                AssetWrapper logoWrapper = modelPackage.getLogo();
                StoreAssetWrapper storeLogoWrapper = new StoreAssetWrapper();
                storeLogoWrapper.setHref(logoWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                StoreAsset storeLogo = new StoreAsset();
                Asset logo = logoWrapper.getAsset();
                storeLogo.setId(logo.getId());
                storeLogo.setName(logo.getName());
                storeLogo.setType(logo.getType());
                storeLogo.setDescription(logo.getDescription());
                storeLogo.setUrls(logo.getUrls());
                storeLogoWrapper.setAsset(storeLogo);
                storePackage.setLogo(storeLogoWrapper);
                storePackageWrapper.setPackage(storePackage);

                List<StorePackageVersionWrapper> storePackageVersions = new LinkedList<>();
                for(PackageVersionWrapper packageVersionWrapper : packageWrapper.getVersions()) {
                    StorePackageVersionWrapper storePackageVersionWrapper = new StorePackageVersionWrapper();
                    storePackageVersionWrapper.setHref(packageVersionWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));

                    StorePackageVersion storePackageVersion = new StorePackageVersion();
                    PackageVersion packageVersion = packageVersionWrapper.getPackageVersion();
                    storePackageVersion.setVersion(packageVersion.getVersion());
                    storePackageVersion.setBuildNumber(packageVersion.getBuildNumber());
                    storePackageVersionWrapper.setPackageVersion(storePackageVersion);

                    StoreAssetWrapper storeDocWrapper = new StoreAssetWrapper();
                    AssetWrapper docWrapper = packageVersionWrapper.getDoc();
                    storeDocWrapper.setHref(docWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                    StoreAsset storeDoc = new StoreAsset();
                    Asset doc = docWrapper.getAsset();
                    storeDoc.setId(doc.getId());
                    storeDoc.setName(doc.getName());
                    storeDoc.setType(doc.getType());
                    storeDoc.setDescription(doc.getDescription());
                    storeDoc.setUrls(doc.getUrls());
                    storeDocWrapper.setAsset(storeDoc);
                    storePackageVersionWrapper.setDoc(storeDocWrapper);

                    StoreAssetWrapper storeMpackWrapper = new StoreAssetWrapper();
                    AssetWrapper mpackWrapper = packageVersionWrapper.getMpack();
                    storeMpackWrapper.setHref(mpackWrapper.getHref().replace(storeBaseUrl, storeWrapper.getHref()));
                    StoreAsset storeMpack = new StoreAsset();
                    Asset mpack = mpackWrapper.getAsset();
                    storeMpack.setId(mpack.getId());
                    storeMpack.setName(mpack.getName());
                    storeMpack.setType(mpack.getType());
                    storeMpack.setDescription(mpack.getDescription());
                    storeMpack.setUrls(mpack.getUrls());
                    storeMpackWrapper.setAsset(storeMpack);
                    storePackageVersionWrapper.setMpack(storeMpackWrapper);

                    List<StoreCompatiblePackage> storeCompatiblePackages = new LinkedList<>();
                    for(CompatiblePackage compatiblePackage : packageVersionWrapper.getCompatiblePackages()) {
                        StoreCompatiblePackage storeCompatiblePackage = new StoreCompatiblePackage();
                        storeCompatiblePackage.setName(compatiblePackage.getName());
                        storeCompatiblePackage.setMaxVersion(compatiblePackage.getMaxVersion());
                        storeCompatiblePackage.setMinVersion(compatiblePackage.getMinVersion());
                        storeCompatiblePackages.add(storeCompatiblePackage);
                    }
                    storePackageVersionWrapper.setCompatiblePackages(storeCompatiblePackages);

                    List<StorePackageService> storeServices = new LinkedList<>();
                    for(PackageService service : packageVersionWrapper.getServices()) {
                        StorePackageService storeService = new StorePackageService();
                        storeService.setName(service.getName());
                        storeService.setDisplayName(service.getDisplayName());
                        storeServices.add(storeService);
                    }
                    storePackageVersionWrapper.setServices(storeServices);
                    storePackageVersions.add(storePackageVersionWrapper);
                }
                storePackageWrapper.setVersions(storePackageVersions);
                storePackageCollection.addItemsItem(storePackageWrapper);
            }
            return Response.ok().entity(storePackageCollection).build();

        } catch (io.swagger.client.ApiException e) {
            System.err.println("Exception when calling PackageApi#getPackages");
            e.printStackTrace();
            throw new NotFoundException(1, "Packages not found in store " + storeId);
        }
    }
    @Override
    public Response getStores(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(storeCollection).build();
    }
}
