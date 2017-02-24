/*
 * Swagger Server
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

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.AssetCollection;
import io.swagger.client.model.AssetWrapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetApi {
    private ApiClient apiClient;

    public AssetApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AssetApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getAssetById */
    private com.squareup.okhttp.Call getAssetByIdCall(Long assetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/assets/{assetId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "assetId" + "\\}", apiClient.escapeString(assetId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAssetByIdValidateBeforeCall(Long assetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'assetId' is set
        if (assetId == null) {
            throw new ApiException("Missing the required parameter 'assetId' when calling getAssetById(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getAssetByIdCall(assetId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get asset
     * Returns an asset by id
     * @param assetId ID of asset that needs to be fetched (required)
     * @return AssetWrapper
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssetWrapper getAssetById(Long assetId) throws ApiException {
        ApiResponse<AssetWrapper> resp = getAssetByIdWithHttpInfo(assetId);
        return resp.getData();
    }

    /**
     * Get asset
     * Returns an asset by id
     * @param assetId ID of asset that needs to be fetched (required)
     * @return ApiResponse&lt;AssetWrapper&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AssetWrapper> getAssetByIdWithHttpInfo(Long assetId) throws ApiException {
        com.squareup.okhttp.Call call = getAssetByIdValidateBeforeCall(assetId, null, null);
        Type localVarReturnType = new TypeToken<AssetWrapper>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get asset (asynchronously)
     * Returns an asset by id
     * @param assetId ID of asset that needs to be fetched (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAssetByIdAsync(Long assetId, final ApiCallback<AssetWrapper> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAssetByIdValidateBeforeCall(assetId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssetWrapper>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getAssets */
    private com.squareup.okhttp.Call getAssetsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/assets".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAssetsValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = getAssetsCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List assets 
     * Returns a list of assets
     * @return AssetCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AssetCollection getAssets() throws ApiException {
        ApiResponse<AssetCollection> resp = getAssetsWithHttpInfo();
        return resp.getData();
    }

    /**
     * List assets 
     * Returns a list of assets
     * @return ApiResponse&lt;AssetCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AssetCollection> getAssetsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getAssetsValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<AssetCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List assets  (asynchronously)
     * Returns a list of assets
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAssetsAsync(final ApiCallback<AssetCollection> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAssetsValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AssetCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}