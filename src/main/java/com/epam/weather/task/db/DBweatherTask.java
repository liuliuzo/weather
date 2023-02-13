package com.epam.weather.task.db;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.epam.weather.core.ReportService;
import com.epam.weather.core.WeatherData;

/**
 * manage task from DB
 * 
 * @author liuliu
 *
 */
//@Component //If we have database
public class DBweatherTask implements SchedulingConfigurer {

    private final Logger logger = LoggerFactory.getLogger(DBweatherTask.class);

    @Autowired
    private ReportService reportService;

    @Autowired
    private WeatherTaskMapper weatheTaskMapper;
    
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> process(), triggerContext -> {
            String cron = weatheTaskMapper.getCron(1);
            logger.info("cron is {}", cron);
            if (StringUtils.isBlank(cron)) {
                logger.warn("cron is is blank");
            }
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        });
    }

    public void process() {
        logger.info("process weather information Task");
        WeatherData weatherData1 = new WeatherData();
        weatherData1.setTemperature(31f);
        weatherData1.setHumidity(60f);
        weatherData1.setPressure(180f);
        reportService.setWeatherData(weatherData1);
        
        WeatherData weatherData2 = new WeatherData();
        weatherData2.setTemperature(31f);
        weatherData2.setHumidity(60f);
        weatherData2.setPressure(180f);
        reportService.setWeatherData(weatherData2);
    }
}
