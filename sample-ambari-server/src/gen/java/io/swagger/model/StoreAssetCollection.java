/*
 * Apache Ambari - Ambari Stores API
 * Unified API for registering multiple management package store providers with Ambari and querying list of available packages across multiple management package store providers.  [Learn about Apache Ambari](https://ambari.apache.org/) 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@ambari.apache.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.StoreAssetWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * StoreAssetCollection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class StoreAssetCollection   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("items")
  private List<StoreAssetWrapper> items = new ArrayList<StoreAssetWrapper>();

  public StoreAssetCollection href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Get href
   * @return href
  **/
  @JsonProperty("href")
  @ApiModelProperty(value = "")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public StoreAssetCollection items(List<StoreAssetWrapper> items) {
    this.items = items;
    return this;
  }

  public StoreAssetCollection addItemsItem(StoreAssetWrapper itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * List of assets
   * @return items
  **/
  @JsonProperty("items")
  @ApiModelProperty(value = "List of assets")
  public List<StoreAssetWrapper> getItems() {
    return items;
  }

  public void setItems(List<StoreAssetWrapper> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoreAssetCollection storeAssetCollection = (StoreAssetCollection) o;
    return Objects.equals(this.href, storeAssetCollection.href) &&
        Objects.equals(this.items, storeAssetCollection.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoreAssetCollection {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

