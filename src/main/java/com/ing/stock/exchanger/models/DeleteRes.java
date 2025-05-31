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
 * DeleteRes
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.4.0")
public class DeleteRes {

  private String statusCode;

  private String statusMessage;

  public DeleteRes statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  */
  
  @Schema(name = "statusCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusCode")
  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public DeleteRes statusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return this;
  }

  /**
   * Get statusMessage
   * @return statusMessage
  */
  
  @Schema(name = "statusMessage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusMessage")
  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteRes deleteRes = (DeleteRes) o;
    return Objects.equals(this.statusCode, deleteRes.statusCode) &&
        Objects.equals(this.statusMessage, deleteRes.statusMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteRes {\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
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

