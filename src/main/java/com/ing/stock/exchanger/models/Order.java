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
 * Order
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class Order {

  private String customer;

  private String asset;

  private String side;

  private Float size;

  private Float price;

  public Order customer(String customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  
  @Schema(name = "customer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customer")
  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public Order asset(String asset) {
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

  public Order side(String side) {
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

  public Order size(Float size) {
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

  public Order price(Float price) {
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
    Order order = (Order) o;
    return Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.asset, order.asset) &&
        Objects.equals(this.side, order.side) &&
        Objects.equals(this.size, order.size) &&
        Objects.equals(this.price, order.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, asset, side, size, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
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

