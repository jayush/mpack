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


import io.swagger.client.model.DownloadResponse;
import io.swagger.client.model.PackageVersionCollection;
import io.swagger.client.model.PackageVersionWrapper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageversionApi {
    private ApiClient apiClient;

    public PackageversionApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PackageversionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getPackageVersion */
    private com.squareup.okhttp.Call getPackageVersionCall(String packageName, String packageVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/packages/{packageName}/versions/{packageVersion}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "packageName" + "\\}", apiClient.escapeString(packageName.toString()))
        .replaceAll("\\{" + "packageVersion" + "\\}", apiClient.escapeString(packageVersion.toString()));

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
    private com.squareup.okhttp.Call getPackageVersionValidateBeforeCall(String packageName, String packageVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'packageName' is set
        if (packageName == null) {
            throw new ApiException("Missing the required parameter 'packageName' when calling getPackageVersion(Async)");
        }
        
        // verify the required parameter 'packageVersion' is set
        if (packageVersion == null) {
            throw new ApiException("Missing the required parameter 'packageVersion' when calling getPackageVersion(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getPackageVersionCall(packageName, packageVersion, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get package version
     * Returns package version information
     * @param packageName Name of package that needs to be fetched (required)
     * @param packageVersion Version of package that needs to be fetched (required)
     * @return PackageVersionWrapper
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PackageVersionWrapper getPackageVersion(String packageName, String packageVersion) throws ApiException {
        ApiResponse<PackageVersionWrapper> resp = getPackageVersionWithHttpInfo(packageName, packageVersion);
        return resp.getData();
    }

    /**
     * Get package version
     * Returns package version information
     * @param packageName Name of package that needs to be fetched (required)
     * @param packageVersion Version of package that needs to be fetched (required)
     * @return ApiResponse&lt;PackageVersionWrapper&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PackageVersionWrapper> getPackageVersionWithHttpInfo(String packageName, String packageVersion) throws ApiException {
        com.squareup.okhttp.Call call = getPackageVersionValidateBeforeCall(packageName, packageVersion, null, null);
        Type localVarReturnType = new TypeToken<PackageVersionWrapper>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get package version (asynchronously)
     * Returns package version information
     * @param packageName Name of package that needs to be fetched (required)
     * @param packageVersion Version of package that needs to be fetched (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPackageVersionAsync(String packageName, String packageVersion, final ApiCallback<PackageVersionWrapper> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getPackageVersionValidateBeforeCall(packageName, packageVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PackageVersionWrapper>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getPackageVersionDownloadUrl */
    private com.squareup.okhttp.Call getPackageVersionDownloadUrlCall(String packageName, String packageVersion, String ambariVersion, String operatingSystem, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/packages/{packageName}/versions/{packageVersion}/downloadUrl".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "packageName" + "\\}", apiClient.escapeString(packageName.toString()))
        .replaceAll("\\{" + "packageVersion" + "\\}", apiClient.escapeString(packageVersion.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (ambariVersion != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "ambariVersion", ambariVersion));
        if (operatingSystem != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "operatingSystem", operatingSystem));

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
    private com.squareup.okhttp.Call getPackageVersionDownloadUrlValidateBeforeCall(String packageName, String packageVersion, String ambariVersion, String operatingSystem, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'packageName' is set
        if (packageName == null) {
            throw new ApiException("Missing the required parameter 'packageName' when calling getPackageVersionDownloadUrl(Async)");
        }
        
        // verify the required parameter 'packageVersion' is set
        if (packageVersion == null) {
            throw new ApiException("Missing the required parameter 'packageVersion' when calling getPackageVersionDownloadUrl(Async)");
        }
        
        // verify the required parameter 'ambariVersion' is set
        if (ambariVersion == null) {
            throw new ApiException("Missing the required parameter 'ambariVersion' when calling getPackageVersionDownloadUrl(Async)");
        }
        
        // verify the required parameter 'operatingSystem' is set
        if (operatingSystem == null) {
            throw new ApiException("Missing the required parameter 'operatingSystem' when calling getPackageVersionDownloadUrl(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getPackageVersionDownloadUrlCall(packageName, packageVersion, ambariVersion, operatingSystem, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get package version management pack download url
     * Get package version management pack download url
     * @param packageName Name of package that needs to be fetched (required)
     * @param packageVersion Version of package that needs to be fetched (required)
     * @param ambariVersion Ambari version to use to fetch compatible mpack (required)
     * @param operatingSystem Operating system type to use to fetch compatible mpack (required)
     * @return DownloadResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DownloadResponse getPackageVersionDownloadUrl(String packageName, String packageVersion, String ambariVersion, String operatingSystem) throws ApiException {
        ApiResponse<DownloadResponse> resp = getPackageVersionDownloadUrlWithHttpInfo(packageName, packageVersion, ambariVersion, operatingSystem);
        return resp.getData();
    }

    /**
     * Get package version management pack download url
     * Get package version management pack download url
     * @param packageName Name of package that needs to be fetched (required)
     * @param packageVersion Version of package that needs to be fetched (required)
     * @param ambariVersion Ambari version to use to fetch compatible mpack (required)
     * @param operatingSystem Operating system type to use to fetch compatible mpack (required)
     * @return ApiResponse&lt;DownloadResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DownloadResponse> getPackageVersionDownloadUrlWithHttpInfo(String packageName, String packageVersion, String ambariVersion, String operatingSystem) throws ApiException {
        com.squareup.okhttp.Call call = getPackageVersionDownloadUrlValidateBeforeCall(packageName, packageVersion, ambariVersion, operatingSystem, null, null);
        Type localVarReturnType = new TypeToken<DownloadResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get package version management pack download url (asynchronously)
     * Get package version management pack download url
     * @param packageName Name of package that needs to be fetched (required)
     * @param packageVersion Version of package that needs to be fetched (required)
     * @param ambariVersion Ambari version to use to fetch compatible mpack (required)
     * @param operatingSystem Operating system type to use to fetch compatible mpack (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPackageVersionDownloadUrlAsync(String packageName, String packageVersion, String ambariVersion, String operatingSystem, final ApiCallback<DownloadResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getPackageVersionDownloadUrlValidateBeforeCall(packageName, packageVersion, ambariVersion, operatingSystem, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DownloadResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getPackageVersions */
    private com.squareup.okhttp.Call getPackageVersionsCall(String packageName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/packages/{packageName}/versions".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "packageName" + "\\}", apiClient.escapeString(packageName.toString()));

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
    private com.squareup.okhttp.Call getPackageVersionsValidateBeforeCall(String packageName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'packageName' is set
        if (packageName == null) {
            throw new ApiException("Missing the required parameter 'packageName' when calling getPackageVersions(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getPackageVersionsCall(packageName, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List package versions
     * Returns list of package versions for a given package
     * @param packageName Name of package that needs to be fetched (required)
     * @return PackageVersionCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PackageVersionCollection getPackageVersions(String packageName) throws ApiException {
        ApiResponse<PackageVersionCollection> resp = getPackageVersionsWithHttpInfo(packageName);
        return resp.getData();
    }

    /**
     * List package versions
     * Returns list of package versions for a given package
     * @param packageName Name of package that needs to be fetched (required)
     * @return ApiResponse&lt;PackageVersionCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PackageVersionCollection> getPackageVersionsWithHttpInfo(String packageName) throws ApiException {
        com.squareup.okhttp.Call call = getPackageVersionsValidateBeforeCall(packageName, null, null);
        Type localVarReturnType = new TypeToken<PackageVersionCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List package versions (asynchronously)
     * Returns list of package versions for a given package
     * @param packageName Name of package that needs to be fetched (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPackageVersionsAsync(String packageName, final ApiCallback<PackageVersionCollection> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getPackageVersionsValidateBeforeCall(packageName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PackageVersionCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
