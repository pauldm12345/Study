package ru.geekbrains.qa.java2.lesson7.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metric{

    @JsonProperty(value = "Value")
    private double value;

    @JsonProperty(value = "Unit")
    private String unit;

    public Metric(){}

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getUnit(){
        return this.unit;
    }
}