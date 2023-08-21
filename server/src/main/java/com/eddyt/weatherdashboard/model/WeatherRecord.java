package com.eddyt.weatherdashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherRecord(
    Coord coord,
    Weather[] weather,
    String base,
    Main main,
    int visibility,
    Wind wind,
    Clouds clouds,
    long dt,
    Sys sys,
    int timezone,
    long id,
    String name,
    int cod) {
  public static record Coord(double lon, double lat) {}

  public static record Weather(int id, String main, String description, String icon) {}

  public static record Main(
      double temp,
      @JsonProperty("feels_like") double feelsLike,
      @JsonProperty("temp_min") double tempMin,
      @JsonProperty("temp_max") double tempMax,
      double pressure,
      int humidity) {}

  public static record Wind(double speed, double deg) {}

  public static record Clouds(int all) {}

  public static record Sys(int type, int id, String country, long sunrise, long sunset) {}
}
