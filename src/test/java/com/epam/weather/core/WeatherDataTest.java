package com.epam.weather.core;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WeatherDataTest {

    @Test
    void testToString() {
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(31f);
        weatherData.setHumidity(60f);
        weatherData.setPressure(180f);
        Assert.assertEquals("WeatherData [temperature=31.0, humidity=60.0, pressure=180.0]", weatherData.toString());
    }

}
