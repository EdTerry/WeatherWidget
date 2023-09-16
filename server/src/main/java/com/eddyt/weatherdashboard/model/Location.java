package com.eddyt.weatherdashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
    @JsonProperty("post code") String postCode,
    String country,
    @JsonProperty("country abbreviation") String countryAbbreviation,
    Place[] places) {
  public record Place(
      @JsonProperty("place name") String placeName,
      String longitude,
      String state,
      @JsonProperty("state abbreviation") String stateAbbreviation,
      String latitude) {}
}
