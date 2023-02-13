package com.epam.weather.task.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.epam.weather.core.ReportService;
import com.epam.weather.core.WeatherData;

/**
 * provide the latest weather information in each minute 
 * 
 * @author liuliu
 *
 */
@Component
@EnableScheduling
public class SpringWeatherTask {
    
    private final Logger logger = LoggerFactory.getLogger(SpringWeatherTask.class);

    @Autowired
    private ReportService reportService ;

    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @Scheduled(cron="${epam.weather.task}")//configuration from properties file
    public void weatherInfoTask() {
        logger.info("Weather Information Task");
        WeatherData weatherData1 = new WeatherData();
        weatherData1.setTemperature(31f);
        weatherData1.setHumidity(60f);
        weatherData1.setPressure(180f);
        reportService.setWeatherData(weatherData1);
        logger.info("set weatherData1");
        
        WeatherData weatherData2 = new WeatherData();
        weatherData2.setTemperature(31f);
        weatherData2.setHumidity(60f);
        weatherData2.setPressure(181f);
        reportService.setWeatherData(weatherData2);
        logger.info("set weatherData2");
    }
}
