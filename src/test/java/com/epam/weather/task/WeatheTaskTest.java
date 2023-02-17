package com.epam.weather.task;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import com.epam.weather.core.ReportService;
import com.epam.weather.core.WeatherData;
import com.epam.weather.station.Station1;
import com.epam.weather.station.Station2;
import com.epam.weather.station.Station3;
import com.epam.weather.station.StationN;
import com.epam.weather.task.spring.SpringWeatherTask;

class WeatheTaskTest {

    @Test
    void testWeatherInforTask() {
        ReportService reportService = new ReportService();
        Station1 station1 = new Station1();
        Station2 station2 = new Station2();
        Station3 station3 = new Station3();
        Field field1 = ReflectionUtils.findField(Station1.class, "reportService");
        Field field2 = ReflectionUtils.findField(Station2.class, "reportService");
        Field field3 = ReflectionUtils.findField(Station3.class, "reportService");
        field1.setAccessible(true);
        field2.setAccessible(true);
        field3.setAccessible(true);
        ReflectionUtils.setField(field1, station1, reportService);
        ReflectionUtils.setField(field2, station2, reportService);
        ReflectionUtils.setField(field3, station3, reportService);
        reportService.registerObserver(station1);
        reportService.registerObserver(station2);
        reportService.registerObserver(station3);
        
        SpringWeatherTask weatheTask = new SpringWeatherTask();
        weatheTask.setReportService(reportService);
        weatheTask.weatherInfoTask(); //do task
        
        WeatherData weatherData = reportService.getWeatherData();
        Assert.assertEquals(181f, weatherData.getPressure(), 0f);
    }

}
