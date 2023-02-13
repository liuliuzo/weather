package com.epam.weather.station;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author liuliu
 *
 */
class StationNDataTest {

    @Test
    void testToString() {
        StationNData stationNData = new StationNData();
        stationNData.setTemperature(31f);
        stationNData.setHumidity(60f);
        stationNData.setPressure(180f);
        stationNData.setTemperatureB(31f);
        stationNData.setHumidityB(60f);
        stationNData.setPressureB(180f);
        stationNData.getTemperature();
        stationNData.getHumidity();
        stationNData.getPressure();
        stationNData.getTemperatureB();
        stationNData.getHumidityB();
        stationNData.getPressureB();
        Assert.assertEquals("Station2WeatherData [temperature=31.0, humidity=60.0, pressure=180.0, temperatureB=31.0, humidityB=60.0, pressureB=180.0]", stationNData.toString());
    }

}
