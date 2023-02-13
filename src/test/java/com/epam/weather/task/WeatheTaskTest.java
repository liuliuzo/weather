package com.epam.weather.task;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.epam.weather.core.ReportService;
import com.epam.weather.core.WeatherData;
import com.epam.weather.station.Station1;
import com.epam.weather.station.Station2;
import com.epam.weather.station.StationN;
import com.epam.weather.task.spring.SpringWeatherTask;

class WeatheTaskTest {

    @Test
    void testWeatherInforTask() {
        ReportService reportService = new ReportService();
        Station1 station1 = new Station1();
        station1.setReportService(reportService);
        Station2 station2 = new Station2();
        station2.setReportService(reportService);
        StationN stationN = new StationN();
        stationN.setReportService(reportService);
        reportService.registerObserver(station1);
        reportService.registerObserver(station2);
        reportService.registerObserver(stationN);
        
        SpringWeatherTask weatheTask = new SpringWeatherTask();
        weatheTask.setReportService(reportService);
        weatheTask.weatherInfoTask(); //do task
        
        WeatherData weatherData = reportService.getWeatherData();
        Assert.assertEquals(181f, weatherData.getPressure(), 0f);
    }

}
