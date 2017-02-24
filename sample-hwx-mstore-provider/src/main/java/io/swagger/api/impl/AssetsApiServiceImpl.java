package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.AssetCollection;
import io.swagger.model.AssetWrapper;

import java.util.HashMap;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.util.Map;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public class AssetsApiServiceImpl extends AssetsApiService {

    public static String baseUrl = "http://localhost:8081/rest/v1";
    AssetCollection assetCollection = null;
    Map<Long, AssetWrapper> assetMap = new HashMap<>();

    public void init() {
        long assetId = 1;
        if (assetCollection == null) {
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
    }
    @Override
    public Response getAssetById(Long assetId, SecurityContext securityContext) throws NotFoundException {
        init();
        for(AssetWrapper assetWrapper : assetCollection.getItems()) {
            if(assetWrapper.getAsset().getId() == assetId) {
                return Response.ok().entity(assetWrapper).build();
            }
        }
        throw new NotFoundException(1, "Asset with id = " + assetId + " not found");
    }
    @Override
    public Response getAssets(SecurityContext securityContext) throws NotFoundException {
        init();
        return Response.ok().entity(assetCollection).build();
    }
}
