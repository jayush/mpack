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

    public static String baseUrl = "http://localhost:8082/rest/v1";
    AssetCollection assetCollection = null;
    Map<Long, AssetWrapper> assetMap = new HashMap<>();

    public void init() {
        long assetId = 1;
        if (assetCollection == null) {
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
