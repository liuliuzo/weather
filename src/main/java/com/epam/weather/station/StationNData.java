package com.epam.weather.station;

/**
 * StationN display data object
 * 
 * @author liuliu
 *
 */
public class StationNData {

    private float temperature;
    private float humidity;
    private float pressure;

    // data from other report service B
    private float temperatureB;
    private float humidityB;
    private float pressureB;

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

    public float getTemperatureB() {
        return temperatureB;
    }

    public void setTemperatureB(float temperatureB) {
        this.temperatureB = temperatureB;
    }

    public float getHumidityB() {
        return humidityB;
    }

    public void setHumidityB(float humidityB) {
        this.humidityB = humidityB;
    }

    public float getPressureB() {
        return pressureB;
    }

    public void setPressureB(float pressureB) {
        this.pressureB = pressureB;
    }

    @Override
    public String toString() {
        return "Station2WeatherData [temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure
                + ", temperatureB=" + temperatureB + ", humidityB=" + humidityB + ", pressureB=" + pressureB + "]";
    }

}
