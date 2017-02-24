package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.swagger.model.DownloadResponse;
import io.swagger.model.PackageCollection;
import io.swagger.model.PackageVersionCollection;
import io.swagger.model.PackageVersionWrapper;
import io.swagger.model.PackageWrapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.util.Map;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public class PackagesApiServiceImpl extends PackagesApiService {
    public static String baseUrl = "http://localhost:8082/rest/v1";
    PackageCollection packageCollection = null;
    AssetCollection assetCollection = null;
    Map<Long, AssetWrapper> assetMap = new HashMap<>();

    public void init() {
        long assetId = 1;
        if(assetCollection == null) {
            assetCollection = new AssetCollection();
            assetCollection.setHref(baseUrl + "/assets");
            AssetWrapper msftRLogoWrapper = new AssetWrapper();
            msftRLogoWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset msftRLogo = new Asset()
                .id(assetId++)
                .type("img")
                .name("MSFT_R-LOGO")
                .description("Microsoft R Server Logo")
                .urls("[\n" +
                    "  {\n" +
                    "    \"resolution\": \"default\",\n" +
                    "    \"url\": \"https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE16DYY?ver=614b\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"resolution\": \"small\",\n" +
                    "    \"url\": \"https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE16DYY?ver=614b\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"resolution\": \"large\",\n" +
                    "    \"url\": \"https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE16DYY?ver=614b\"\n" +
                    "  }\n" +
                    "]");
            msftRLogoWrapper.setAsset(msftRLogo);
            assetCollection.addItemsItem(msftRLogoWrapper);
            assetMap.put(msftRLogo.getId(), msftRLogoWrapper);


            AssetWrapper msftR10DocWrapper = new AssetWrapper();
            msftR10DocWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset msftR10Doc = new Asset()
                .id(assetId++)
                .type("doc")
                .name("MSFT_R-1.0.0.0-Doc")
                .description("Microsoft R Server Documentation for MSFT_R-1.0.0.0")
                .urls("[\n" +
                    "  {\n" +
                    "    \"type\": \"index\",\n" +
                    "    \"url\": \"https://www.microsoft.com/en-us/cloud-platform/r-server\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"type\": \"relnote\",\n" +
                    "    \"url\": \"https://msdn.microsoft.com/en-us/microsoft-r/notes/r-server-notes\"\n" +
                    "  }\n" +
                    "]");
            msftR10DocWrapper.setAsset(msftR10Doc);
            assetCollection.addItemsItem(msftR10DocWrapper);
            assetMap.put(msftR10Doc.getId(), msftR10DocWrapper);


            AssetWrapper msftR10MpackWrapper = new AssetWrapper();
            msftR10MpackWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset msftR10Mpack = new Asset()
                .id(assetId++)
                .type("mpack")
                .name("MSFT_R-1.0.0.0-mpack")
                .description("Microsoft R Server Management Pack for MSFT_R-1.0.0.0")
                .urls("[\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.0.0\",\n" +
                    "    \"operatingSystem\": \"centos6\",\n" +
                    "    \"url\": \"http://public-repo.microsoft.com/MSFT_R/centos6/1.x/updates/1.0.0.0/tars/msft_r_ambari_mp/msft_r-ambari-mpack-1.0.0.0_3.0.0-111.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.0.0\",\n" +
                    "    \"operatingSystem\": \"centos7\",\n" +
                    "    \"url\": \"http://public-repo.microsoft.com/MSFT_R/centos7/1.x/updates/1.0.0.0/tars/msft_r_ambari_mp/msft_r-ambari-mpack-1.0.0.0_3.0.0-111.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.1.0\",\n" +
                    "    \"operatingSystem\": \"centos6\",\n" +
                    "    \"url\": \"http://public-repo.microsoft.com/MSFT_R/centos6/1.x/updates/1.0.0.0/tars/msft_r_ambari_mp/msft_r-ambari-mpack-1.0.0.0_3.1.0-222.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.1.0\",\n" +
                    "    \"operatingSystem\": \"centos7\",\n" +
                    "    \"url\": \"http://public-repo.microsoft.com/MSFT_R/centos7/1.x/updates/1.0.0.0/tars/msft_r_ambari_mp/msft_r-ambari-mpack-1.0.0.0_3.1.0-222.tar.gz\"\n" +
                    "  }\n" +
                    "]");
            msftR10MpackWrapper.setAsset(msftR10Mpack);
            assetCollection.addItemsItem(msftR10MpackWrapper);
            assetMap.put(msftR10Mpack.getId(), msftR10MpackWrapper);
        }
        if(packageCollection == null) {
            packageCollection = new PackageCollection();
            packageCollection.setHref( baseUrl + "/packages");

            PackageWrapper msftRPackageWrapper = new PackageWrapper();
            msftRPackageWrapper.setHref( baseUrl + "/packages/MSFT_R");
            ModelPackage msftRPackage = new ModelPackage()
                .name("MSFT_R")
                .description("Microsoft R Server")
                .logo(assetMap.get((long)1));
            msftRPackageWrapper.setPackage(msftRPackage);

            List<PackageVersionWrapper> msftRVersions = new LinkedList<>();
            PackageVersionWrapper msftR10VersionWrapper = new PackageVersionWrapper();
            msftR10VersionWrapper.setHref(baseUrl + "/packages/MSFT_R/versions/1.0.0.0");
            PackageVersion msftR10Version = new PackageVersion()
                .version("1.0.0.0")
                .buildNumber("1.0.0.0-123");
            msftR10VersionWrapper.setPackageVersion(msftR10Version);
            msftR10VersionWrapper.setDoc(assetMap.get((long)2));
            msftR10VersionWrapper.setMpack(assetMap.get((long)3));

            msftR10VersionWrapper.setServices(Arrays.asList(
                new PackageService().name("MSFT_R").displayName("Microsoft R Server")));
            msftR10VersionWrapper.setCompatiblePackages(Arrays.asList(
                new CompatiblePackage().name("HDP").minVersion("2.5.0.0").maxVersion("3.0.0.0"),
                new CompatiblePackage().name("HDF").minVersion("2.1.0.0").maxVersion("3.0.0.0")));
            msftRVersions.add(msftR10VersionWrapper);
            msftRPackageWrapper.setVersions(msftRVersions);
            packageCollection.addItemsItem(msftRPackageWrapper);
        }
    }

    @Override
    public Response getPackageVersionDownloadUrl(String packageName, String packageVersion, String ambariVersion, String operatingSystem, SecurityContext securityContext) throws NotFoundException {
        init();
        for(PackageWrapper packageWrapper : packageCollection.getItems()) {
            if(packageWrapper.getPackage().getName().equals(packageName)) {
                for(PackageVersionWrapper packageVersionWrapper : packageWrapper.getVersions()) {
                    if(packageVersionWrapper.getPackageVersion().getVersion().equals(packageVersion)) {

                        try {
                            AssetWrapper mpackAsset = packageVersionWrapper.getMpack();
                            String urls = mpackAsset.getAsset().getUrls();
                            JSONParser jsonParser = new JSONParser();
                            JSONArray jsonUrls = (JSONArray) jsonParser.parse(urls);
                            for (int i = 0; i < jsonUrls.size(); i++) {
                                JSONObject jsonUrl = (JSONObject) jsonUrls.get(i);
                                String urlAmbariVersion = (String) jsonUrl.get("ambariVersion");
                                String urlOperatingSystem = (String) jsonUrl.get("operatingSystem");
                                String url = (String) jsonUrl.get("url");
                                if (StringUtils.equals(urlAmbariVersion, ambariVersion)
                                    && StringUtils.equals(urlOperatingSystem, operatingSystem)) {
                                    return Response.ok().entity(new DownloadResponse().url(url)).build();
                                }
                            }
                        } catch (Exception e) {
                            // Parse Error
                        }
                    }
                }
            }
        }
        throw new NotFoundException(1, "Management pack for package version " + packageName + ":" + packageVersion + " not found");
    }
    @Override
    public Response getPackageByName(String packageName, SecurityContext securityContext) throws NotFoundException {
        init();
        for(PackageWrapper packageWrapper : packageCollection.getItems()) {
            if(packageWrapper.getPackage().getName().equals(packageName)) {
                return Response.ok().entity(packageWrapper).build();
            }
        }
        throw new NotFoundException(1, "Package " + packageName + " not found");
    }
    @Override
    public Response getPackageVersion(String packageName, String packageVersion, SecurityContext securityContext) throws NotFoundException {
        init();
        for(PackageWrapper packageWrapper : packageCollection.getItems()) {
            if(packageWrapper.getPackage().getName().equals(packageName)) {
                for(PackageVersionWrapper packageVersionWrapper : packageWrapper.getVersions()) {
                    if(packageVersionWrapper.getPackageVersion().getVersion().equals(packageVersion)) {
                        return Response.ok().entity(packageVersionWrapper).build();
                    }
                }
            }
        }
        throw new NotFoundException(1, "Package version " + packageName + ":" + packageVersion + " not found");
    }

    @Override
    public Response getPackageVersions(String packageName, SecurityContext securityContext) throws NotFoundException {
        init();
        for(PackageWrapper packageWrapper : packageCollection.getItems()) {
            if(packageWrapper.getPackage().getName().equals(packageName)) {
                PackageVersionCollection packageVersionCollection = new PackageVersionCollection();
                packageVersionCollection.setHref(baseUrl + "/packages/" + packageName + "/versions");
                packageVersionCollection.setItems(packageWrapper.getVersions());
                return Response.ok().entity(packageVersionCollection).build();
            }
        }
        throw new NotFoundException(1, "Package versions for package " + packageName + " not found");
    }
    @Override
    public Response getPackages(SecurityContext securityContext) throws NotFoundException {
        init();
        return Response.ok().entity(packageCollection).build();
    }
}
