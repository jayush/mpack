# AssetApi

All URIs are relative to *http://localhost:8080/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAssetById**](AssetApi.md#getAssetById) | **GET** /assets/{assetId} | Get asset
[**getAssets**](AssetApi.md#getAssets) | **GET** /assets | List assets 


<a name="getAssetById"></a>
# **getAssetById**
> AssetWrapper getAssetById(assetId)

Get asset

Returns an asset by id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AssetApi;


AssetApi apiInstance = new AssetApi();
Long assetId = 789L; // Long | ID of asset that needs to be fetched
try {
    AssetWrapper result = apiInstance.getAssetById(assetId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssetApi#getAssetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **assetId** | **Long**| ID of asset that needs to be fetched |

### Return type

[**AssetWrapper**](AssetWrapper.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAssets"></a>
# **getAssets**
> AssetCollection getAssets()

List assets 

Returns a list of assets

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AssetApi;


AssetApi apiInstance = new AssetApi();
try {
    AssetCollection result = apiInstance.getAssets();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AssetApi#getAssets");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AssetCollection**](AssetCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

