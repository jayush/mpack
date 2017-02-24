/*
 * Apache Ambari - Management Pack Store Provider APIs
 * Management pack store provider APIs for Apache Ambari  [Learn about Apache Ambari](https://ambari.apache.org/) 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@ambari.apache.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.PackageCollection;
import io.swagger.client.model.PackageWrapper;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PackageApi
 */
@Ignore
public class PackageApiTest {

    private final PackageApi api = new PackageApi();

    
    /**
     * Get package
     *
     * Returns a package by name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPackageByNameTest() throws ApiException {
        String packageName = null;
        PackageWrapper response = api.getPackageByName(packageName);

        // TODO: test validations
    }
    
    /**
     * List packages 
     *
     * Returns a list of packages
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPackagesTest() throws ApiException {
        PackageCollection response = api.getPackages();

        // TODO: test validations
    }
    
}
