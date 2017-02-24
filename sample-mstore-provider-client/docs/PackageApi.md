# PackageApi

All URIs are relative to *http://localhost:8080/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPackageByName**](PackageApi.md#getPackageByName) | **GET** /packages/{packageName} | Get package
[**getPackages**](PackageApi.md#getPackages) | **GET** /packages | List packages 


<a name="getPackageByName"></a>
# **getPackageByName**
> PackageWrapper getPackageByName(packageName)

Get package

Returns a package by name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PackageApi;


PackageApi apiInstance = new PackageApi();
String packageName = "packageName_example"; // String | Name of package that needs to be fetched
try {
    PackageWrapper result = apiInstance.getPackageByName(packageName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PackageApi#getPackageByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **packageName** | **String**| Name of package that needs to be fetched |

### Return type

[**PackageWrapper**](PackageWrapper.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPackages"></a>
# **getPackages**
> PackageCollection getPackages()

List packages 

Returns a list of packages

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PackageApi;


PackageApi apiInstance = new PackageApi();
try {
    PackageCollection result = apiInstance.getPackages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PackageApi#getPackages");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PackageCollection**](PackageCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

