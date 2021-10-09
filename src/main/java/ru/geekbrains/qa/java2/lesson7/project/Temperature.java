package ru.geekbrains.qa.java2.lesson7.project;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @JsonProperty(value = "Metric")
    private Metric metric;

    public Temperature(){}

    public void setMetric(Metric metric){
        this.metric = metric;
    }

    public Metric getMetric(){
        return this.metric;
    }
}
