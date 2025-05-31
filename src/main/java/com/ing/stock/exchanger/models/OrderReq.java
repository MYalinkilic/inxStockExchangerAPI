package com.ing.stock.exchanger.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * OrderReq
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class OrderReq {

  private String customerID;

  private String asset;

  private String side;

  private Float size;

  private Float price;

  public OrderReq customerID(String customerID) {
    this.customerID = customerID;
    return this;
  }

  /**
   * Get customerID
   * @return customerID
  */
  
  @Schema(name = "customerID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerID")
  public String getCustomerID() {
    return customerID;
  }

  public void setCustomerID(String customerID) {
    this.customerID = customerID;
  }

  public OrderReq asset(String asset) {
    this.asset = asset;
    return this;
  }

  /**
   * Get asset
   * @return asset
  */
  
  @Schema(name = "asset", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("asset")
  public String getAsset() {
    return asset;
  }

  public void setAsset(String asset) {
    this.asset = asset;
  }

  public OrderReq side(String side) {
    this.side = side;
    return this;
  }

  /**
   * Get side
   * @return side
  */
  
  @Schema(name = "side", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("side")
  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public OrderReq size(Float size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
  */
  
  @Schema(name = "size", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Float getSize() {
    return size;
  }

  public void setSize(Float size) {
    this.size = size;
  }

  public OrderReq price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderReq orderReq = (OrderReq) o;
    return Objects.equals(this.customerID, orderReq.customerID) &&
        Objects.equals(this.asset, orderReq.asset) &&
        Objects.equals(this.side, orderReq.side) &&
        Objects.equals(this.size, orderReq.size) &&
        Objects.equals(this.price, orderReq.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerID, asset, side, size, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderReq {\n");
    sb.append("    customerID: ").append(toIndentedString(customerID)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    side: ").append(toIndentedString(side)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

