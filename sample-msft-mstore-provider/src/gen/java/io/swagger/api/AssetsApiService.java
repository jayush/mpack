package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AssetCollection;
import io.swagger.model.AssetWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public abstract class AssetsApiService {
    public abstract Response getAssetById(Long assetId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAssets(SecurityContext securityContext) throws NotFoundException;
}
