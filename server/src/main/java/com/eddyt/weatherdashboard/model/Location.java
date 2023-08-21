package com.eddyt.weatherdashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
    @JsonProperty("post code") String postCode,
    String country,
    @JsonProperty("country abbreviation") String countryAbbreviation,
    Place[] places) {}
