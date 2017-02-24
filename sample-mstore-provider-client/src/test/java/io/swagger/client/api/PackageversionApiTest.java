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
import io.swagger.client.model.DownloadResponse;
import io.swagger.client.model.PackageVersionCollection;
import io.swagger.client.model.PackageVersionWrapper;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PackageversionApi
 */
@Ignore
public class PackageversionApiTest {

    private final PackageversionApi api = new PackageversionApi();

    
    /**
     * Get package version
     *
     * Returns package version information
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPackageVersionTest() throws ApiException {
        String packageName = null;
        String packageVersion = null;
        PackageVersionWrapper response = api.getPackageVersion(packageName, packageVersion);

        // TODO: test validations
    }
    
    /**
     * Get package version management pack download url
     *
     * Get package version management pack download url
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPackageVersionDownloadUrlTest() throws ApiException {
        String packageName = null;
        String packageVersion = null;
        String ambariVersion = null;
        String operatingSystem = null;
        DownloadResponse response = api.getPackageVersionDownloadUrl(packageName, packageVersion, ambariVersion, operatingSystem);

        // TODO: test validations
    }
    
    /**
     * List package versions
     *
     * Returns list of package versions for a given package
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPackageVersionsTest() throws ApiException {
        String packageName = null;
        PackageVersionCollection response = api.getPackageVersions(packageName);

        // TODO: test validations
    }
    
}
