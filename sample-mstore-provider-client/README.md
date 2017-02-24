# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AssetApi;

import java.io.File;
import java.util.*;

public class AssetApiExample {

    public static void main(String[] args) {
        
        AssetApi apiInstance = new AssetApi();
        Long assetId = 789L; // Long | ID of asset that needs to be fetched
        try {
            AssetWrapper result = apiInstance.getAssetById(assetId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AssetApi#getAssetById");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/rest/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AssetApi* | [**getAssetById**](docs/AssetApi.md#getAssetById) | **GET** /assets/{assetId} | Get asset
*AssetApi* | [**getAssets**](docs/AssetApi.md#getAssets) | **GET** /assets | List assets 
*PackageApi* | [**getPackageByName**](docs/PackageApi.md#getPackageByName) | **GET** /packages/{packageName} | Get package
*PackageApi* | [**getPackages**](docs/PackageApi.md#getPackages) | **GET** /packages | List packages 
*PackageversionApi* | [**getPackageVersion**](docs/PackageversionApi.md#getPackageVersion) | **GET** /packages/{packageName}/versions/{packageVersion} | Get package version
*PackageversionApi* | [**getPackageVersionDownloadUrl**](docs/PackageversionApi.md#getPackageVersionDownloadUrl) | **GET** /packages/{packageName}/versions/{packageVersion}/downloadUrl | Get package version management pack download url
*PackageversionApi* | [**getPackageVersions**](docs/PackageversionApi.md#getPackageVersions) | **GET** /packages/{packageName}/versions | List package versions


## Documentation for Models

 - [Asset](docs/Asset.md)
 - [AssetCollection](docs/AssetCollection.md)
 - [AssetWrapper](docs/AssetWrapper.md)
 - [CompatiblePackage](docs/CompatiblePackage.md)
 - [DownloadResponse](docs/DownloadResponse.md)
 - [ModelPackage](docs/ModelPackage.md)
 - [PackageCollection](docs/PackageCollection.md)
 - [PackageService](docs/PackageService.md)
 - [PackageVersion](docs/PackageVersion.md)
 - [PackageVersionCollection](docs/PackageVersionCollection.md)
 - [PackageVersionWrapper](docs/PackageVersionWrapper.md)
 - [PackageWrapper](docs/PackageWrapper.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

dev@ambari.apache.org

