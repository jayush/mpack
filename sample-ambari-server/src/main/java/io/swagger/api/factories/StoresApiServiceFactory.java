package io.swagger.api.factories;

import io.swagger.api.StoresApiService;
import io.swagger.api.impl.StoresApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class StoresApiServiceFactory {
    private final static StoresApiService service = new StoresApiServiceImpl();

    public static StoresApiService getStoresApi() {
        return service;
    }
}
