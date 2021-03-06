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
import io.swagger.model.StorePackage;
import io.swagger.model.StorePackageVersionWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * StorePackageWrapper
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T21:27:39.655Z")
public class StorePackageWrapper   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("Package")
  private StorePackage _package = null;

  @JsonProperty("versions")
  private List<StorePackageVersionWrapper> versions = new ArrayList<StorePackageVersionWrapper>();

  public StorePackageWrapper href(String href) {
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

  public StorePackageWrapper _package(StorePackage _package) {
    this._package = _package;
    return this;
  }

   /**
   * Get _package
   * @return _package
  **/
  @JsonProperty("Package")
  @ApiModelProperty(value = "")
  public StorePackage getPackage() {
    return _package;
  }

  public void setPackage(StorePackage _package) {
    this._package = _package;
  }

  public StorePackageWrapper versions(List<StorePackageVersionWrapper> versions) {
    this.versions = versions;
    return this;
  }

  public StorePackageWrapper addVersionsItem(StorePackageVersionWrapper versionsItem) {
    this.versions.add(versionsItem);
    return this;
  }

   /**
   * Get versions
   * @return versions
  **/
  @JsonProperty("versions")
  @ApiModelProperty(value = "")
  public List<StorePackageVersionWrapper> getVersions() {
    return versions;
  }

  public void setVersions(List<StorePackageVersionWrapper> versions) {
    this.versions = versions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StorePackageWrapper storePackageWrapper = (StorePackageWrapper) o;
    return Objects.equals(this.href, storePackageWrapper.href) &&
        Objects.equals(this._package, storePackageWrapper._package) &&
        Objects.equals(this.versions, storePackageWrapper.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, _package, versions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StorePackageWrapper {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    _package: ").append(toIndentedString(_package)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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

