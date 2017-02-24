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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-23T23:42:30.437Z")
public class PackagesApiServiceImpl extends PackagesApiService {
    public static String baseUrl = "http://localhost:8081/rest/v1";
    PackageCollection packageCollection = null;
    AssetCollection assetCollection = null;
    Map<Long, AssetWrapper> assetMap = new HashMap<>();

    public void init() {
        long assetId = 1;
        if(assetCollection == null) {
            assetCollection = new AssetCollection();
            assetCollection.setHref(baseUrl + "/assets");
            AssetWrapper hdpLogoWrapper = new AssetWrapper();
            hdpLogoWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset hdpLogo = new Asset()
                .id(assetId++)
                .type("img")
                .name("HDP-LOGO")
                .description("HDP Logo")
                .urls("[\n" +
                    "  {\n" +
                    "    \"resolution\": \"default\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/common/img/product_icons/icon-hdp.png\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"resolution\": \"small\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/common/img/product_icons/icon-hdp-small.png\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"resolution\": \"large\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/common/img/product_icons/icon-hdp-large.png\"\n" +
                    "  }\n" +
                    "]");
            hdpLogoWrapper.setAsset(hdpLogo);
            assetCollection.addItemsItem(hdpLogoWrapper);
            assetMap.put(hdpLogo.getId(), hdpLogoWrapper);

            AssetWrapper hdfLogoWrapper = new AssetWrapper();
            hdfLogoWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset hdfLogo = new Asset()
                .id(assetId++)
                .type("img")
                .name("HDF-LOGO")
                .description("HDF Logo")
                .urls("[\n" +
                    "  {\n" +
                    "    \"resolution\": \"default\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/common/img/product_icons/icon-hdf.png\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"resolution\": \"small\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/common/img/product_icons/icon-hdf-small.png\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"resolution\": \"large\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/common/img/product_icons/icon-hdf-large.png\"\n" +
                    "  }\n" +
                    "]");
            hdfLogoWrapper.setAsset(hdfLogo);
            assetCollection.addItemsItem(hdfLogoWrapper);
            assetMap.put(hdfLogo.getId(), hdfLogoWrapper);

            AssetWrapper hdp25DocWrapper = new AssetWrapper();
            hdp25DocWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset hdp25Doc = new Asset()
                .id(assetId++)
                .type("doc")
                .name("HDP-2.5.0.0-Doc")
                .description("HDP Documentation for HDP-2.5.0.0")
                .urls("[\n" +
                    "  {\n" +
                    "    \"type\": \"index\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.5.0/index.html\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"type\": \"relnote\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.5.0/bk_release-notes/content/ch_relnotes_v250.html\"\n" +
                    "  }\n" +
                    "]");
            hdp25DocWrapper.setAsset(hdp25Doc);
            assetCollection.addItemsItem(hdp25DocWrapper);
            assetMap.put(hdp25Doc.getId(), hdp25DocWrapper);

            AssetWrapper hdf21DocWrapper = new AssetWrapper();
            hdf21DocWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset hdf21Doc = new Asset()
                .id(assetId++)
                .type("doc")
                .name("HDF-2.1.0.0-Doc")
                .description("HDF Documentation for HDF-2.1.0.0")
                .urls("[\n" +
                    "  {\n" +
                    "    \"type\": \"index\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/HDPDocuments/HDF2/HDF-2.1.0/index.html\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"type\": \"relnote\",\n" +
                    "    \"url\": \"http://docs.hortonworks.com/HDPDocuments/HDF2/HDF-2.1.0/bk_dataflow-release-notes/content/index.html\"\n" +
                    "  }\n" +
                    "]");
            hdf21DocWrapper.setAsset(hdf21Doc);
            assetCollection.addItemsItem(hdf21DocWrapper);
            assetMap.put(hdf21Doc.getId(), hdf21DocWrapper);


            AssetWrapper hdp25MpackWrapper = new AssetWrapper();
            hdp25MpackWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset hdp25Mpack = new Asset()
                .id(assetId++)
                .type("mpack")
                .name("HDP-2.5.0.0-mpack")
                .description("HDP Management Pack for HDP-2.5.0.0")
                .urls("[\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.0.0\",\n" +
                    "    \"operatingSystem\": \"centos6\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.0.0-111.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.0.0\",\n" +
                    "    \"operatingSystem\": \"centos7\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDP/centos7/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.0.0-111.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.1.0\",\n" +
                    "    \"operatingSystem\": \"centos6\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.1.0-222.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.1.0\",\n" +
                    "    \"operatingSystem\": \"centos7\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDP/centos7/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.1.0-222.tar.gz\"\n" +
                    "  }\n" +
                    "]");
            hdp25MpackWrapper.setAsset(hdp25Mpack);
            assetCollection.addItemsItem(hdp25MpackWrapper);
            assetMap.put(hdp25Mpack.getId(), hdp25MpackWrapper);

            AssetWrapper hdf21MpackWrapper = new AssetWrapper();
            hdf21MpackWrapper.setHref(baseUrl + "/assets/" + assetId);
            Asset hdf21Mpack = new Asset()
                .id(assetId++)
                .type("mpack")
                .name("HDF-2.1.0.0-mpack")
                .description("HDF Management Pack for HDF-2.1.0.0")
                .urls("[\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.0.0\",\n" +
                    "    \"operatingSystem\": \"centos6\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDF/centos6/2.x/updates/2.1.0.0/tars/hdf_ambari_mp/hdf-ambari-mpack-2.1.0.0_3.0.0-333.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.0.0\",\n" +
                    "    \"operatingSystem\": \"centos7\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDF/centos7/2.x/updates/2.1.0.0/tars/hdf_ambari_mp/hdf-ambari-mpack-2.1.0.0_3.0.0-333.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.1.0\",\n" +
                    "    \"operatingSystem\": \"centos6\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDF/centos6/2.x/updates/2.1.0.0/tars/hdf_ambari_mp/hdf-ambari-mpack-2.1.0.0_3.1.0-444.tar.gz\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"ambariVersion\": \"3.1.0\",\n" +
                    "    \"operatingSystem\": \"centos7\",\n" +
                    "    \"url\": \"http://public-repo-1.hortonworks.com/HDF/centos7/2.x/updates/2.1.0.0/tars/hdf_ambari_mp/hdf-ambari-mpack-2.1.0.0_3.1.0-444.tar.gz\"\n" +
                    "  }\n" +
                    "]");
            hdf21MpackWrapper.setAsset(hdf21Mpack);
            assetCollection.addItemsItem(hdf21MpackWrapper);
            assetMap.put(hdf21Mpack.getId(), hdf21MpackWrapper);
        }
        if(packageCollection == null) {
            packageCollection = new PackageCollection();
            packageCollection.setHref( baseUrl + "/packages");

            PackageWrapper hdpPackageWrapper = new PackageWrapper();
            hdpPackageWrapper.setHref( baseUrl + "/packages/HDP");
            ModelPackage hdpPackage = new ModelPackage()
                .name("HDP")
                .description("Hortonworks Data Platform")
                .logo(assetMap.get((long)1));
            hdpPackageWrapper.setPackage(hdpPackage);

            List<PackageVersionWrapper> hdpVersions = new LinkedList<>();
            PackageVersionWrapper hdp25VersionWrapper = new PackageVersionWrapper();
            hdp25VersionWrapper.setHref(baseUrl + "/packages/HDP/versions/2.5.0.0");
            PackageVersion hdp25Version = new PackageVersion()
                .version("2.5.0.0")
                .buildNumber("2.5.0.0-123");
            hdp25VersionWrapper.setPackageVersion(hdp25Version);
            hdp25VersionWrapper.setDoc(assetMap.get((long)3));
            hdp25VersionWrapper.setMpack(assetMap.get((long)5));

            hdp25VersionWrapper.setServices(Arrays.asList(
                new PackageService().name("HDFS").displayName("HDFS"),
                new PackageService().name("ZOOKEEPER").displayName("Zookeeper")));
            hdp25VersionWrapper.setCompatiblePackages(Collections.<CompatiblePackage>emptyList());
            hdpVersions.add(hdp25VersionWrapper);
            hdpPackageWrapper.setVersions(hdpVersions);
            packageCollection.addItemsItem(hdpPackageWrapper);

            PackageWrapper hdfPackageWrapper = new PackageWrapper();
            hdfPackageWrapper.setHref( baseUrl + "/packages/HDF");
            ModelPackage hdfPackage = new ModelPackage()
                .name("HDF")
                .description("Hortonworks Data Flow")
                .logo(assetMap.get((long)2));
            hdfPackageWrapper.setPackage(hdfPackage);

            List<PackageVersionWrapper> hdfVersions = new LinkedList<>();
            PackageVersionWrapper hdf21VersionWrapper = new PackageVersionWrapper();
            hdf21VersionWrapper.setHref(baseUrl + "/packages/HDF/versions/2.1.0.0");
            PackageVersion hdf21Version = new PackageVersion()
                .version("2.1.0.0")
                .buildNumber("2.1.0.0-123");
            hdf21VersionWrapper.setPackageVersion(hdf21Version);
            hdf21VersionWrapper.setDoc(assetMap.get((long)4));
            hdf21VersionWrapper.setMpack(assetMap.get((long)6));
            hdf21VersionWrapper.setServices(Arrays.asList(
                new PackageService().name("NIFI").displayName("Nifi"),
                new PackageService().name("ZOOKEEPER").displayName("Zookeeper")));
            hdf21VersionWrapper.setCompatiblePackages(Arrays.asList(
                new CompatiblePackage().name("HDP").minVersion("2.5.0.0").maxVersion("3.0.0.0")));
            hdfVersions.add(hdf21VersionWrapper);
            hdfPackageWrapper.setVersions(hdfVersions);
            packageCollection.addItemsItem(hdfPackageWrapper);
        }
    }

    @Override
    public Response downloadPackageVersion(String packageName, String packageVersion, String ambariVersion, String operatingSystem, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
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
