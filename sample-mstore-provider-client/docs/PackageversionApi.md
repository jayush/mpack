# PackageversionApi

All URIs are relative to *http://localhost:8080/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPackageVersion**](PackageversionApi.md#getPackageVersion) | **GET** /packages/{packageName}/versions/{packageVersion} | Get package version
[**getPackageVersionDownloadUrl**](PackageversionApi.md#getPackageVersionDownloadUrl) | **GET** /packages/{packageName}/versions/{packageVersion}/downloadUrl | Get package version management pack download url
[**getPackageVersions**](PackageversionApi.md#getPackageVersions) | **GET** /packages/{packageName}/versions | List package versions


<a name="getPackageVersion"></a>
# **getPackageVersion**
> PackageVersionWrapper getPackageVersion(packageName, packageVersion)

Get package version

Returns package version information

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PackageversionApi;


PackageversionApi apiInstance = new PackageversionApi();
String packageName = "packageName_example"; // String | Name of package that needs to be fetched
String packageVersion = "packageVersion_example"; // String | Version of package that needs to be fetched
try {
    PackageVersionWrapper result = apiInstance.getPackageVersion(packageName, packageVersion);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PackageversionApi#getPackageVersion");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **packageName** | **String**| Name of package that needs to be fetched |
 **packageVersion** | **String**| Version of package that needs to be fetched |

### Return type

[**PackageVersionWrapper**](PackageVersionWrapper.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPackageVersionDownloadUrl"></a>
# **getPackageVersionDownloadUrl**
> DownloadResponse getPackageVersionDownloadUrl(packageName, packageVersion, ambariVersion, operatingSystem)

Get package version management pack download url

Get package version management pack download url

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PackageversionApi;


PackageversionApi apiInstance = new PackageversionApi();
String packageName = "packageName_example"; // String | Name of package that needs to be fetched
String packageVersion = "packageVersion_example"; // String | Version of package that needs to be fetched
String ambariVersion = "ambariVersion_example"; // String | Ambari version to use to fetch compatible mpack
String operatingSystem = "operatingSystem_example"; // String | Operating system type to use to fetch compatible mpack
try {
    DownloadResponse result = apiInstance.getPackageVersionDownloadUrl(packageName, packageVersion, ambariVersion, operatingSystem);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PackageversionApi#getPackageVersionDownloadUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **packageName** | **String**| Name of package that needs to be fetched |
 **packageVersion** | **String**| Version of package that needs to be fetched |
 **ambariVersion** | **String**| Ambari version to use to fetch compatible mpack |
 **operatingSystem** | **String**| Operating system type to use to fetch compatible mpack |

### Return type

[**DownloadResponse**](DownloadResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPackageVersions"></a>
# **getPackageVersions**
> PackageVersionCollection getPackageVersions(packageName)

List package versions

Returns list of package versions for a given package

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PackageversionApi;


PackageversionApi apiInstance = new PackageversionApi();
String packageName = "packageName_example"; // String | Name of package that needs to be fetched
try {
    PackageVersionCollection result = apiInstance.getPackageVersions(packageName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PackageversionApi#getPackageVersions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **packageName** | **String**| Name of package that needs to be fetched |

### Return type

[**PackageVersionCollection**](PackageVersionCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

