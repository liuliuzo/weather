package com.epam.weather.station;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.weather.core.IObserver;
import com.epam.weather.core.ReportService;
import com.epam.weather.core.WeatherData;

/**
 * 
 * @author Liuliu Zhao
 *
 */
@Component
public class StationN implements IObserver {

    private final Logger logger = LoggerFactory.getLogger(StationN.class);

    @Autowired
    private ReportService reportService;

    /**
     * StationN display data object
     */
    private StationNData stationNData = new StationNData();

    @Override
    public void display() {
        logger.info("current temperature is:{}℃", stationNData.getTemperatureB());
        logger.info("current humidity is:{}", stationNData.getHumidityB());
        logger.info("current pressure is:{}f", stationNData.getPressureB());
    }

    @Override
    public void update() {
        WeatherData weatherData = reportService.getWeatherData();
        stationNData.setTemperatureB(weatherData.getTemperature());
        stationNData.setHumidityB(weatherData.getHumidity());
        stationNData.setPressureB(weatherData.getPressure());
        if (logger != null && logger.isDebugEnabled()) {
            logger.debug("update StationN Weather Data {}", stationNData);
        }
        this.display();
    }
}
