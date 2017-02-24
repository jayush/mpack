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


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ModelPackage;
import io.swagger.model.PackageVersionWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageWrapper
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public class PackageWrapper   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("Package")
  private ModelPackage _package = null;

  @JsonProperty("versions")
  private List<PackageVersionWrapper> versions = new ArrayList<PackageVersionWrapper>();

  public PackageWrapper href(String href) {
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

  public PackageWrapper _package(ModelPackage _package) {
    this._package = _package;
    return this;
  }

   /**
   * Get _package
   * @return _package
  **/
  @JsonProperty("Package")
  @ApiModelProperty(value = "")
  public ModelPackage getPackage() {
    return _package;
  }

  public void setPackage(ModelPackage _package) {
    this._package = _package;
  }

  public PackageWrapper versions(List<PackageVersionWrapper> versions) {
    this.versions = versions;
    return this;
  }

  public PackageWrapper addVersionsItem(PackageVersionWrapper versionsItem) {
    this.versions.add(versionsItem);
    return this;
  }

   /**
   * Get versions
   * @return versions
  **/
  @JsonProperty("versions")
  @ApiModelProperty(value = "")
  public List<PackageVersionWrapper> getVersions() {
    return versions;
  }

  public void setVersions(List<PackageVersionWrapper> versions) {
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
    PackageWrapper packageWrapper = (PackageWrapper) o;
    return Objects.equals(this.href, packageWrapper.href) &&
        Objects.equals(this._package, packageWrapper._package) &&
        Objects.equals(this.versions, packageWrapper.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, _package, versions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageWrapper {\n");
    
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

