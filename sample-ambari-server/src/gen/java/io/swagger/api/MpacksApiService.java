package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.MpackCollection;
import io.swagger.model.MpackWrapper;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public abstract class MpacksApiService {
    public abstract Response addMpack(MpackWrapper body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMpackById(Long mpackId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getMpacks(SecurityContext securityContext) throws NotFoundException;
    public abstract Response refreshMpackById(Long mpackId,Boolean refresh,SecurityContext securityContext) throws NotFoundException;
}
