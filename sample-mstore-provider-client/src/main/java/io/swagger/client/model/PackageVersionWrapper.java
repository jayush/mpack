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


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.AssetWrapper;
import io.swagger.client.model.CompatiblePackage;
import io.swagger.client.model.PackageService;
import io.swagger.client.model.PackageVersion;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageVersionWrapper
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-02-24T19:27:10.581Z")
public class PackageVersionWrapper {
  @SerializedName("href")
  private String href = null;

  @SerializedName("PackageVersion")
  private PackageVersion packageVersion = null;

  @SerializedName("mpack")
  private AssetWrapper mpack = null;

  @SerializedName("doc")
  private AssetWrapper doc = null;

  @SerializedName("services")
  private List<PackageService> services = new ArrayList<PackageService>();

  @SerializedName("compatiblePackages")
  private List<CompatiblePackage> compatiblePackages = new ArrayList<CompatiblePackage>();

  public PackageVersionWrapper href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Get href
   * @return href
  **/
  @ApiModelProperty(example = "null", value = "")
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
  @ApiModelProperty(example = "null", value = "")
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
  @ApiModelProperty(example = "null", value = "")
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
  @ApiModelProperty(example = "null", value = "")
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
  @ApiModelProperty(example = "null", value = "")
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
  @ApiModelProperty(example = "null", value = "")
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

