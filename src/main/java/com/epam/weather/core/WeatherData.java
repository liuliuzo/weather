package com.epam.weather.core;

/**
 * basic weather metrics info object
 * 
 * @author Liuliu Zhao
 */
public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherData [temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + "]";
    }
}
