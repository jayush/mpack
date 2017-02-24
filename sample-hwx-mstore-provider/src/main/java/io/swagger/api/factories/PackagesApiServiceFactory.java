package io.swagger.api.factories;

import io.swagger.api.PackagesApiService;
import io.swagger.api.impl.PackagesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-23T23:42:30.437Z")
public class PackagesApiServiceFactory {
    private final static PackagesApiService service = new PackagesApiServiceImpl();

    public static PackagesApiService getPackagesApi() {
        return service;
    }
}
