package mx.com.openweathermap.dto;

/**
 * Created by betob_000 on 22/11/2015.
 */
public enum IndexLinkName {

  CALL_CURRENT_WEATHER_DATA_FOR_ONE_LOCATION("Call current weather data for one location", "one"),
  BY_CITY_NAME("By city name", "name"),
  BY_CITY_ID("By city ID", "cityid"),
  BY_GEOGRAPHIC_COORDINATES("By geographic coordinates", "geo"),
  BY_ZIP_CODE("By ZIP code", "zip"),
  CALL_CURRENT_WEATHER_DATA_FOR_SEVERAL_CITIES("Call current weather data for several cities", "cities"),
  CITIES_WITHIN_A_RECTANGLE_ZONE("Cities within a rectangle zone", "rectangle"),
  CITIES_IN_CYCLE("Cities in cycle", "cycle"),
  CALL_FOR_SEVERAL_CITY_IDS("Call for several city IDs", "severalid"),
  BULK_DOWNLOADING("Bulk downloading", "bulk"),
  PARAMETERS_OF_API_RESPOND("Parameters of API respond", "parameter"),
  JSON("JSON", "current_JSON"),
  XML("XML", "current_XML"),
  LIST_OF_CONDITION_CODES("List of condition codes", "list"),
  MIN_MAX_TEMPERATURE_IN_CURRENT_WEATHER_API_AND_FORECAST_API("Min/max temperature in current weather API and forecast API", "min"),
  OTHER_FEATURES("Other features", "other"),
  FORMAT("Format", "format"),
  SEARCH_ACCURACY("Search accuracy", "accuracy"),
  UNITS_FORMAT("Units format", "data"),
  MULTILINGUAL_SUPPORT("Multilingual support", "multi"),
  CALL_BACK_FUNCTION_FOR_JAVASCRIPT_CODE("Call back function for JavaScript code", "call");

  IndexLinkName(String indexLinkName, String section){
    this.indexLinkName = indexLinkName;
    this.section = section;
  }

  private String indexLinkName;
  private String section;

  public String getIndexLinkName() {
    return indexLinkName;
  }

  public String getSection() {
    return section;
  }

  @Override
  public String toString() {
    return "IndexLinkName{" +
            "indexLinkName='" + indexLinkName + '\'' +
            ", section='" + section + '\'' +
            '}';
  }
}
