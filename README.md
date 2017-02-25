# Management Pack Store Provider Demo

## Git Clone
```
git clone https://github.com/jayush/mpack.git
```

## Deploy Hortonworks Management Pack Store Provider
```
cd sample-hwx-mstore-provider
mvn clean package jetty:run
```
##### Note: 
The Hortonworks Store Management Pack Provider Server is configured to start as 
```
http://localhost:8081/rest/v1
```

## Deploy Third Party Management Pack Store Provider (Microsoft)
```
cd sample-msft-mstore-provider
mvn clean package jetty:run
```
##### Note: 
The Third Party Management Pack Store Provider Server is configured to start as 
```
http://localhost:8082/rest/v1
```

## Deploy Sample Ambari Server
First build the "Management Pack Store Provider Client Library". The Sample Ambari Server uses the client library to query the registered Store Providers
```
cd sample-mstore-provider-client 
mvn clean install
```
Now start the Sample Ambari Server that implements the new APIs (api/v2/stores & api/v2/mpacks)
```
cd sample-ambari-server
mvn clean package jetty:run
```
##### Note: 
The Sample Ambari Server is configured to start as 
```
http://localhost:8080/api/v2
```

## Register Store Providers
#### Register Hortonworks Store Provider with Ambari
```
POST http://localhost:8080/api/v2
{
  "Store": {
    "type": "remote",
    "name": "Hortonworks Store",
    "url": "http://localhost:8081/rest/v1"
  }
}

Response:
{
  "href": "http://localhost:8080/api/v2/stores/1",
  "Store": {
    "id": 1,
    "type": "remote",
    "name": "Hortonworks Store",
    "url": "http://localhost:8081/rest/v1"
  }
}
```

#### Register Third Party Store Provider with Ambari
```
POST http://localhost:8080/api/v2
{
  "Store": {
    "type": "remote",
    "name": "Microsoft Store",
    "url": "http://localhost:8082/rest/v1"
  }
}

Response:
{
  "href": "http://localhost:8080/api/v2/stores/2",
  "Store": {
    "id": 2,
    "type": "remote",
    "name": "Microsoft Store",
    "url": "http://localhost:8082/rest/v1"
  }
}
```

## List Packages in Registered Store Providers
Internally the Sample Ambari Server will query the registered store provider endpoints to fetch the list of packages 
```
GET http://localhost:8080/api/v2/stores/1/packages
GET http://localhost:8080/api/v2/stores/1/packages/HDP
GET http://localhost:8080/api/v2/stores/1/packages/HDP/versions/2.5.0.0
GET http://localhost:8080/api/v2/stores/1/packages/HDF
GET http://localhost:8080/api/v2/stores/1/packages/HDF/versions/2.1.0.0

GET http://localhost:8080/api/v2/stores/2/packages
GET http://localhost:8080/api/v2/stores/2/packages/MSFT_R
GET http://localhost:8080/api/v2/stores/2/packages/MSFT_R/versions/1.0.0.0
```

## Install HDP-3.0.0.0 Management Pack
```
POST http://localhost:8080/api/v2/mpacks
{
  "Mpack": {
    "storeId": 1,
    "packageName": "HDP",
    "packageVersion": "2.5.0.0"
  }
}

Response:
{
  "href": "http://localhost:8080/api/v2/mpacks/1",
  "Mpack": {
    "id": 1,
    "storeId": 1,
    "packageName": "HDP",
    "packageVersion": "2.5.0.0",
    "url": "http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.0.0-111.tar.gz"
  }
}
```
##### Note:
Internally the Sample Ambari Server uses ambariVersion=3.0.0 & operatingSystem=centos6 to query the Hortonworks Store Provider and get the compatible management pack.
```
GET http://localhost:8081/rest/v1/packages/HDP/versions/2.5.0.0/downloadUrl?ambariVersion=3.0.0&operatingSystem=centos6
{
  "url": "http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.0.0-111.tar.gz"
}
```

## Refresh installed HDP-3.0.0.0 management pack
To simulate the scenario of ambari-server upgrade requiring the installed mpack to be refreshed, this call internally uses ambariVersion=3.1.0 and will refresh the mpack url to the management pack that is compatible with ambariVersion=3.1.0
```
PATCH http://localhost:8080/api/v2/mpacks/1?refresh=true

Response:
{
  "href": "http://localhost:8080/api/v2/mpacks/1",
  "Mpack": {
    "id": 1,
    "storeId": 1,
    "packageName": "HDP",
    "packageVersion": "2.5.0.0",
    "url": "http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.1.0-222.tar.gz"
  }
}
```
##### Note: 
The mpack url gets updated from 
```
http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.0.0-111.tar.gz
``` 
to 
```
http://public-repo-1.hortonworks.com/HDP/centos6/2.x/updates/2.5.0.0/tars/hdp_ambari_mp/hdp-ambari-mpack-2.5.0.0_3.1.0-222.tar.gz
```
