package ru.geekbrains.qa.java2.lesson7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty(value = "WeatherText")
    private String weatherText;
    @JsonProperty(value = "Temperature")
    private Temperature temperature;

    public WeatherResponse(){}

    public void setWeatherText(String weatherText){
        this.weatherText = weatherText;
    }

    public String getWeatherText(){
        return this.weatherText;
    }

    public void setTemperature(Temperature temperature){
        this.temperature = temperature;
    }

    public Temperature getTemperature(){
        return this.temperature;
    }


    public String toString(){
        if(this.weatherText == null && this.temperature == null){
            return super.toString();
        }
        else{
            String s = "Сообщение:"  + this.weatherText + " Температура: " + this.temperature.getMetric().getValue() + this.temperature.getMetric().getUnit();
            return s;
        }
    }
}


