package io.swagger.api.factories;

import io.swagger.api.AssetsApiService;
import io.swagger.api.impl.AssetsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public class AssetsApiServiceFactory {
    private final static AssetsApiService service = new AssetsApiServiceImpl();

    public static AssetsApiService getAssetsApi() {
        return service;
    }
}
