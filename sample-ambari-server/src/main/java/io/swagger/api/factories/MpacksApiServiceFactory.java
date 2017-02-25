package io.swagger.api.factories;

import io.swagger.api.MpacksApiService;
import io.swagger.api.impl.MpacksApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class MpacksApiServiceFactory {
    private final static MpacksApiService service = new MpacksApiServiceImpl();

    public static MpacksApiService getMpacksApi() {
        return service;
    }
}
