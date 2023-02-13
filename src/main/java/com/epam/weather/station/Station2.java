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
public class Station2 implements IObserver {

    private final Logger logger = LoggerFactory.getLogger(Station2.class);

    @Autowired
    private ReportService reportService;

    /**
     * Station display data object
     */
    private WeatherData weatherData;
    
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public void display() {
        logger.info("current temperature is:{}℃", weatherData.getTemperature());
        logger.info("current humidity is:{}", weatherData.getHumidity());
        logger.info("current pressure is:{}f", weatherData.getPressure());
    }

    @Override
    public void update() {
        this.weatherData = reportService.getWeatherData();
        if (logger != null && logger.isDebugEnabled()) {
            logger.debug("update weather Data {}", weatherData);
        }
        this.display();
    }
}
