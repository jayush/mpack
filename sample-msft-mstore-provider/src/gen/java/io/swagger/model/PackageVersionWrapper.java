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
import io.swagger.model.AssetWrapper;
import io.swagger.model.CompatiblePackage;
import io.swagger.model.PackageService;
import io.swagger.model.PackageVersion;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageVersionWrapper
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-02-24T19:26:54.139Z")
public class PackageVersionWrapper   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("PackageVersion")
  private PackageVersion packageVersion = null;

  @JsonProperty("mpack")
  private AssetWrapper mpack = null;

  @JsonProperty("doc")
  private AssetWrapper doc = null;

  @JsonProperty("services")
  private List<PackageService> services = new ArrayList<PackageService>();

  @JsonProperty("compatiblePackages")
  private List<CompatiblePackage> compatiblePackages = new ArrayList<CompatiblePackage>();

  public PackageVersionWrapper href(String href) {
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

  public PackageVersionWrapper packageVersion(PackageVersion packageVersion) {
    this.packageVersion = packageVersion;
    return this;
  }

   /**
   * Get packageVersion
   * @return packageVersion
  **/
  @JsonProperty("PackageVersion")
  @ApiModelProperty(value = "")
  public PackageVersion getPackageVersion() {
    return packageVersion;
  }

  public void setPackageVersion(PackageVersion packageVersion) {
    this.packageVersion = packageVersion;
  }

  public PackageVersionWrapper mpack(AssetWrapper mpack) {
    this.mpack = mpack;
    return this;
  }

   /**
   * Get mpack
   * @return mpack
  **/
  @JsonProperty("mpack")
  @ApiModelProperty(value = "")
  public AssetWrapper getMpack() {
    return mpack;
  }

  public void setMpack(AssetWrapper mpack) {
    this.mpack = mpack;
  }

  public PackageVersionWrapper doc(AssetWrapper doc) {
    this.doc = doc;
    return this;
  }

   /**
   * Get doc
   * @return doc
  **/
  @JsonProperty("doc")
  @ApiModelProperty(value = "")
  public AssetWrapper getDoc() {
    return doc;
  }

  public void setDoc(AssetWrapper doc) {
    this.doc = doc;
  }

  public PackageVersionWrapper services(List<PackageService> services) {
    this.services = services;
    return this;
  }

  public PackageVersionWrapper addServicesItem(PackageService servicesItem) {
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @JsonProperty("services")
  @ApiModelProperty(value = "")
  public List<PackageService> getServices() {
    return services;
  }

  public void setServices(List<PackageService> services) {
    this.services = services;
  }

  public PackageVersionWrapper compatiblePackages(List<CompatiblePackage> compatiblePackages) {
    this.compatiblePackages = compatiblePackages;
    return this;
  }

  public PackageVersionWrapper addCompatiblePackagesItem(CompatiblePackage compatiblePackagesItem) {
    this.compatiblePackages.add(compatiblePackagesItem);
    return this;
  }

   /**
   * Get compatiblePackages
   * @return compatiblePackages
  **/
  @JsonProperty("compatiblePackages")
  @ApiModelProperty(value = "")
  public List<CompatiblePackage> getCompatiblePackages() {
    return compatiblePackages;
  }

  public void setCompatiblePackages(List<CompatiblePackage> compatiblePackages) {
    this.compatiblePackages = compatiblePackages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageVersionWrapper packageVersionWrapper = (PackageVersionWrapper) o;
    return Objects.equals(this.href, packageVersionWrapper.href) &&
        Objects.equals(this.packageVersion, packageVersionWrapper.packageVersion) &&
        Objects.equals(this.mpack, packageVersionWrapper.mpack) &&
        Objects.equals(this.doc, packageVersionWrapper.doc) &&
        Objects.equals(this.services, packageVersionWrapper.services) &&
        Objects.equals(this.compatiblePackages, packageVersionWrapper.compatiblePackages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, packageVersion, mpack, doc, services, compatiblePackages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageVersionWrapper {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    packageVersion: ").append(toIndentedString(packageVersion)).append("\n");
    sb.append("    mpack: ").append(toIndentedString(mpack)).append("\n");
    sb.append("    doc: ").append(toIndentedString(doc)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    compatiblePackages: ").append(toIndentedString(compatiblePackages)).append("\n");
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

